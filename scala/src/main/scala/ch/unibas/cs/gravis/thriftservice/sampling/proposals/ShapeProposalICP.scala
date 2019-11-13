package ch.unibas.cs.gravis.thriftservice.sampling.proposals

import ch.unibas.cs.gravis.thriftservice.utils.DecimateModel
import ch.unibas.cs.gravis.thriftservice.utils.Helpers.Sample

case class ShapeProposalICP(model: StatisticalMeshModel,
                            targetMesh: TriangleMesh[_3D],
                            uncertainty: MultivariateNormalDistribution,
                            stepLength: Double)(implicit val rng: scalismo.utils.Random) extends
    ProposalGenerator[Sample] with TransitionProbability[Sample] {

    val targetMeshPoints: IndexedSeq[Point[_3D]] = UniformMeshSampler3D(targetMesh, 1000).sample().map(_._1)
    val decimatedModel: StatisticalMeshModel = DecimateModel.decimate(model, 0.95)
    val referenceMesh: TriangleMesh[_3D] = decimatedModel.referenceMesh
    val gpInterpolated: LowRankGaussianProcess[_3D, EuclideanVector[_3D]] = decimatedModel.gp.interpolateNearestNeighbor

    override def propose(current: Sample): Sample = {
        val inversePoseTransform: RigidTransformation[_3D] = current.poseTransformation.inverse
        val currentModelInstance: TriangleMesh[_3D] = decimatedModel.instance(current.parameters.modelCoefficients)
        val targetPtsInModelSpace: IndexedSeq[Point[_3D]] = targetMeshPoints.map(inversePoseTransform)

        val deformation = for (targetPointModelSpace <- targetPtsInModelSpace) yield {
            val referenceId: PointId = currentModelInstance.pointSet.findClosestPoint(targetPointModelSpace).id
            val referencePt: Point[_3D] = decimatedModel.referenceMesh.pointSet.point(referenceId)
            (referencePt, targetPointModelSpace - referencePt, uncertainty)
        }

        val modelCoeffs: DenseVector[Double] = gpInterpolated.coefficients(deformation.toIndexedSeq)
        val currentModelParams: DenseVector[Double] = current.parameters.modelCoefficients
        val newShapeParameters: DenseVector[Double] = currentModelParams + (modelCoeffs - currentModelParams) * stepLength
        val newParameters: RenderParameter = current.rps.copy(momo = current.rps.momo.copy(shape = newShapeParameters.toArray))
        current.copy(generatedBy = s"ShapeProposalICP ($stepLength)", rps = newParameters)
    }

    override def logTransitionProbability(from: Sample, to: Sample): Double = {
        0.0 // deterministic setting
    }
}
