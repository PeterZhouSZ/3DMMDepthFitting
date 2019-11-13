package ch.unibas.cs.gravis.thriftservice.rendering

/**
 * This is a static class with static intrinsic/extrinsic parameters
 * which are going to be injected into RenderParameter object.
 * Unless you change the resolution of the image for the Camera, those
 * parameters will always be the same as bellow. ImageSize -> 640x480
 */
class InjectExtrinsicParameters(pose: Pose,
                                view: ViewParameter,
                                camera: Camera,
                                envMap: SphericalHarmonicsLight,
                                dirLight: DirectionalLight,
                                momo: MoMoInstance,
                                imageSize: ImageSize,
                                cT: ColorTransform)
    extends RenderParameter(pose, view, camera, envMap, dirLight, momo, imageSize, cT) {

    override def modelViewTransform: Affine3D = {

        /* Depth modules extrinsic parameters for 640x480 resolution */
        val depthExtrinsics = Affine3D.apply(
            SquareMatrix(Array(
                0.999976, 0.000557234, -0.00697231,
                -0.000544951, 0.999998, 0.00176348,
                0.00697328, -0.00175964, 0.999974
            )),
            geometry.EuclideanVector3D(0.0150543, 0.000121441, -0.00041644)
        )

        /* Color modules extrinsic parameters for 640x480 resolution */
        val colorExtrinsics = Affine3D.apply(
            SquareMatrix(Array(
                0.999976, -0.000544951, 0.00697328,
                0.000557234, 0.999998, -0.00175964,
                -0.00697231, 0.00176348, 0.999974
            )),
            geometry.EuclideanVector3D(-0.0150569, -0.000112502, 0.000311666)
        )

        /**
         * This will shift the rendered object left and right depending on which extrinsic parameters you use
         * and whether you invert them or not. The shift is representing the distance between physical camera
         * modules on the body.
         *
         * NOTE: The extrinsic parameters above are each sensor module's information about the 'location' of the
         * other module and what transformation it has to do in order to match the second module.
         *
         * Depending on your use-case this might not be necessary.
         */
        view.viewTransform compose colorExtrinsics compose pose.transform
    }
}

object InjectExtrinsicParameters {
    def apply(rps: RenderParameter) = new InjectExtrinsicParameters(
        rps.pose,
        rps.view,
        rps.camera,
        rps.environmentMap,
        rps.directionalLight,
        rps.momo,
        rps.imageSize,
        rps.colorTransform
    )
}
