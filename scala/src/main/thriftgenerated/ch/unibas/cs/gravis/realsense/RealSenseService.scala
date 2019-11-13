/**
 * Generated by Scrooge
 *   version: 18.4.0
 *   rev: b64bcb47af2451b2e51a1ed1b3876f6c06c642b3
 *   built at: 20180410-144039
 */
package ch.unibas.cs.gravis.realsense

import com.twitter.scrooge.{
  LazyTProtocol,
  TFieldBlob,
  ThriftService,
  ThriftStruct,
  ThriftStructCodec,
  ThriftStructFieldInfo,
  ThriftResponse,
  ThriftUtil,
  ToThriftService,
  ValidatingThriftStruct,
  ValidatingThriftStructCodec3
}
import com.twitter.finagle.{service => ctfs}
import com.twitter.finagle.thrift.{
  Protocols,
  RichClientParam,
  RichServerParam,
  ThriftClientRequest,
  ThriftServiceIface
}
import com.twitter.util.Future
import java.nio.ByteBuffer
import java.util.Arrays
import org.apache.thrift.protocol._
import org.apache.thrift.transport.TTransport
import org.apache.thrift.TApplicationException
import org.apache.thrift.transport.TMemoryBuffer
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.{
  Builder,
  ArrayBuffer => mutable$ArrayBuffer, Buffer => mutable$Buffer,
  HashMap => mutable$HashMap, HashSet => mutable$HashSet}
import scala.collection.{Map, Set}
import scala.language.higherKinds


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
trait RealSenseService[+MM[_]] extends ThriftService {
  
  def capture(): MM[ch.unibas.cs.gravis.realsense.CaptureResult]

  /**
   * Used to close the underlying `Service`.
   * Not a user-defined API.
   */
  def asClosable: _root_.com.twitter.util.Closable = _root_.com.twitter.util.Closable.nop
}


object RealSenseService { self =>

  val annotations: immutable$Map[String, String] = immutable$Map.empty

  trait ServicePerEndpoint
    extends ToThriftService
    with _root_.com.twitter.finagle.thrift.ThriftServiceIface.Filterable[ServicePerEndpoint] {
    def capture : _root_.com.twitter.finagle.Service[self.Capture.Args, self.Capture.SuccessType]

    def withCapture(capture : _root_.com.twitter.finagle.Service[self.Capture.Args, self.Capture.SuccessType]): ServicePerEndpoint = this

    /**
     * Prepends the given type-agnostic `Filter` to all of the `Services`
     * and returns a copy of the `ServicePerEndpoint` now including the filter.
     */
    def filtered(filter: _root_.com.twitter.finagle.Filter.TypeAgnostic): ServicePerEndpoint = this

    /**
     * Converts the `ServicePerEndpoint` to a `ThriftService`.
     * @see _root_.com.twitter.scrooge.ToThriftService
     */
    def toThriftService: ThriftService = MethodPerEndpoint(this)

    /**
     * Used to close the underlying `Service`.
     * Not a user-defined API.
     */
    def asClosable: _root_.com.twitter.util.Closable = _root_.com.twitter.util.Closable.nop
  }

  trait ReqRepServicePerEndpoint
    extends ToThriftService
    with _root_.com.twitter.finagle.thrift.service.Filterable[ReqRepServicePerEndpoint] {
    def capture : _root_.com.twitter.finagle.Service[com.twitter.scrooge.Request[self.Capture.Args], _root_.com.twitter.scrooge.Response[self.Capture.SuccessType]]

    def withCapture(capture : _root_.com.twitter.finagle.Service[com.twitter.scrooge.Request[self.Capture.Args], _root_.com.twitter.scrooge.Response[self.Capture.SuccessType]]): ReqRepServicePerEndpoint = this

    /**
     * Prepends the given type-agnostic `Filter` to all of the `Services`
     * and returns a copy of the `ServicePerEndpoint` now including the filter.
     */
    def filtered(filter: com.twitter.finagle.Filter.TypeAgnostic): ReqRepServicePerEndpoint = this

    /**
     * Converts the `ServicePerEndpoint` to a `ThriftService`.
     * @see _root_.com.twitter.scrooge.ToThriftService
     */
    def toThriftService: ThriftService = ReqRepMethodPerEndpoint(this)

    /**
     * Used to close the underlying `Service`.
     * Not a user-defined API.
     */
    def asClosable: _root_.com.twitter.util.Closable = _root_.com.twitter.util.Closable.nop
  }

  @deprecated("Use ServicePerEndpoint", "2017-11-07")
  trait BaseServiceIface extends ToThriftService {
    def capture : com.twitter.finagle.Service[self.Capture.Args, self.Capture.SuccessType]

    def toThriftService: ThriftService = new MethodIface(this)
  }

  object ServicePerEndpoint {

    def apply(
      capture : _root_.com.twitter.finagle.Service[self.Capture.Args, self.Capture.SuccessType]
    ): ServicePerEndpoint = new ServicePerEndpointImpl(capture)

    private final class ServicePerEndpointImpl(
      override val capture : _root_.com.twitter.finagle.Service[self.Capture.Args, self.Capture.SuccessType]
    ) extends ServicePerEndpoint {

      override def withCapture(
        capture : _root_.com.twitter.finagle.Service[self.Capture.Args, self.Capture.SuccessType]
      ): ServicePerEndpoint =
        new ServicePerEndpointImpl(capture)

      override def filtered(filter: _root_.com.twitter.finagle.Filter.TypeAgnostic): ServicePerEndpoint =
        new ServicePerEndpointImpl(
          capture = filter.toFilter.andThen(capture)
        )

      override def asClosable: _root_.com.twitter.util.Closable =
        _root_.com.twitter.util.Closable.all(
          this.capture
        )
    }
  }

  object ReqRepServicePerEndpoint {

    def apply(
      capture :  _root_.com.twitter.finagle.Service[_root_.com.twitter.scrooge.Request[self.Capture.Args], _root_.com.twitter.scrooge.Response[self.Capture.SuccessType]]
    ): ReqRepServicePerEndpoint =
      new ReqRepServicePerEndpointImpl(capture)

    private final class ReqRepServicePerEndpointImpl(
      override val capture : _root_.com.twitter.finagle.Service[_root_.com.twitter.scrooge.Request[self.Capture.Args], _root_.com.twitter.scrooge.Response[self.Capture.SuccessType]]
    ) extends ReqRepServicePerEndpoint {

      override def withCapture(
        capture : _root_.com.twitter.finagle.Service[com.twitter.scrooge.Request[self.Capture.Args], _root_.com.twitter.scrooge.Response[self.Capture.SuccessType]]
      ): ReqRepServicePerEndpoint =
        new ReqRepServicePerEndpointImpl(capture)

      override def filtered(filter: com.twitter.finagle.Filter.TypeAgnostic): ReqRepServicePerEndpoint =
        new ReqRepServicePerEndpointImpl(
          capture = filter.toFilter.andThen(capture)
        )

      override def asClosable: _root_.com.twitter.util.Closable =
        _root_.com.twitter.util.Closable.all(
          this.capture
        )
    }
  }

  @deprecated("Use ServicePerEndpoint", "2017-11-07")
  case class ServiceIface(
    capture : com.twitter.finagle.Service[self.Capture.Args, self.Capture.SuccessType]
  ) extends BaseServiceIface
    with com.twitter.finagle.thrift.ThriftServiceIface.Filterable[ServiceIface] {

    /**
     * Prepends the given type-agnostic `Filter` to all of the `Services`
     * and returns a copy of the `ServiceIface` now including the filter.
     */
    def filtered(filter: com.twitter.finagle.Filter.TypeAgnostic): ServiceIface =
      copy(
        capture = filter.toFilter.andThen(capture)
      )
  }

  implicit object ServicePerEndpointBuilder
    extends _root_.com.twitter.finagle.thrift.service.ServicePerEndpointBuilder[ServicePerEndpoint] {
      def servicePerEndpoint(
        thriftService: _root_.com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
        clientParam: RichClientParam
      ): ServicePerEndpoint =
        ServicePerEndpoint(
          capture = ThriftServiceIface(self.Capture, thriftService, clientParam)
        )
  }

  implicit object ReqRepServicePerEndpointBuilder
    extends _root_.com.twitter.finagle.thrift.service.ReqRepServicePerEndpointBuilder[ReqRepServicePerEndpoint] {
      def servicePerEndpoint(
        thriftService: _root_.com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
        clientParam: RichClientParam
      ): ReqRepServicePerEndpoint =
        ReqRepServicePerEndpoint(
          capture = _root_.com.twitter.finagle.thrift.service.ThriftReqRepServicePerEndpoint(self.Capture, thriftService, clientParam)
        )
  }

  @deprecated("Use ServicePerEndpointBuilder", "2017-11-07")
  implicit object ServiceIfaceBuilder
    extends com.twitter.finagle.thrift.ServiceIfaceBuilder[ServiceIface] {
      def newServiceIface(
        binaryService: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
        clientParam: RichClientParam
      ): ServiceIface =
        ServiceIface(
          capture = ThriftServiceIface(self.Capture, binaryService, clientParam)
        )
  }

  object Capture extends com.twitter.scrooge.ThriftMethod {
    
    object Args extends ValidatingThriftStructCodec3[Args] {
      val NoPassthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty[Short, TFieldBlob]
      val Struct = new TStruct("capture_args")
    
      /**
       * Field information in declaration order.
       */
      lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
      )
    
      lazy val structAnnotations: immutable$Map[String, String] =
        immutable$Map.empty[String, String]
    
      /**
       * Checks that all required fields are non-null.
       */
      def validate(_item: Args): Unit = {
      }
    
      /**
       * Checks that the struct is a valid as a new instance. If there are any missing required or
       * construction required fields, return a non-empty list.
       */
      def validateNewInstance(item: Args): scala.Seq[com.twitter.scrooge.validation.Issue] = {
        val buf = scala.collection.mutable.ListBuffer.empty[com.twitter.scrooge.validation.Issue]
    
        buf.toList
      }
    
      def withoutPassthroughFields(original: Args): Args =
        new Args(
        )
    
      override def encode(_item: Args, _oproto: TProtocol): Unit = {
        _item.write(_oproto)
      }
    
    
      override def decode(_iprot: TProtocol): Args = {
        var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
        var _done = false
    
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case _ =>
                if (_passthroughFields == null)
                  _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
                _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
    
        new Args(
          if (_passthroughFields == null)
            NoPassthroughFields
          else
            _passthroughFields.result()
        )
      }
    
      def apply(
      ): Args =
        new Args(
        )
    
      def unapply(_item: Args): Boolean = true
    
    
    
    }
    
    class Args(
        val _passthroughFields: immutable$Map[Short, TFieldBlob])
      extends ThriftStruct
      with _root_.scala.Product
      with ValidatingThriftStruct[Args]
      with java.io.Serializable
    {
      import Args._
      def this(
      ) = this(
        Map.empty
      )
    
    
    
    
      override def write(_oprot: TProtocol): Unit = {
        Args.validate(this)
        _oprot.writeStructBegin(Struct)
        if (_passthroughFields.nonEmpty) {
          _passthroughFields.values.foreach { _.write(_oprot) }
        }
        _oprot.writeFieldStop()
        _oprot.writeStructEnd()
      }
    
      def copy(
        _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
      ): Args =
        new Args(
          _passthroughFields
        )
    
      override def canEqual(other: Any): Boolean = other.isInstanceOf[Args]
    
      private def _equals(x: Args, y: Args): Boolean =
          x.productArity == y.productArity &&
          x.productIterator.sameElements(y.productIterator)
    
      override def equals(other: Any): Boolean =
        canEqual(other) &&
          _equals(this, other.asInstanceOf[Args]) &&
          _passthroughFields == other.asInstanceOf[Args]._passthroughFields
    
      override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)
    
      override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)
    
    
      override def productArity: Int = 0
    
      override def productElement(n: Int): Any = n match {
        case _ => throw new IndexOutOfBoundsException(n.toString)
      }
    
      override def productPrefix: String = "Args"
    
      def _codec: ValidatingThriftStructCodec3[Args] = Args
    }

    type SuccessType = ch.unibas.cs.gravis.realsense.CaptureResult
    
    object Result extends ValidatingThriftStructCodec3[Result] {
      val NoPassthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty[Short, TFieldBlob]
      val Struct = new TStruct("capture_result")
      val SuccessField = new TField("success", TType.STRUCT, 0)
      val SuccessFieldManifest = implicitly[Manifest[ch.unibas.cs.gravis.realsense.CaptureResult]]
      val ErrorField = new TField("error", TType.STRUCT, 1)
      val ErrorFieldManifest = implicitly[Manifest[ch.unibas.cs.gravis.realsense.ThriftServerError]]
    
      /**
       * Field information in declaration order.
       */
      lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
        new ThriftStructFieldInfo(
          SuccessField,
          true,
          false,
          SuccessFieldManifest,
          _root_.scala.None,
          _root_.scala.None,
          immutable$Map.empty[String, String],
          immutable$Map.empty[String, String],
          None
        ),
        new ThriftStructFieldInfo(
          ErrorField,
          true,
          false,
          ErrorFieldManifest,
          _root_.scala.None,
          _root_.scala.None,
          immutable$Map.empty[String, String],
          immutable$Map.empty[String, String],
          None
        )
      )
    
      lazy val structAnnotations: immutable$Map[String, String] =
        immutable$Map.empty[String, String]
    
      /**
       * Checks that all required fields are non-null.
       */
      def validate(_item: Result): Unit = {
      }
    
      /**
       * Checks that the struct is a valid as a new instance. If there are any missing required or
       * construction required fields, return a non-empty list.
       */
      def validateNewInstance(item: Result): scala.Seq[com.twitter.scrooge.validation.Issue] = {
        val buf = scala.collection.mutable.ListBuffer.empty[com.twitter.scrooge.validation.Issue]
    
        buf ++= validateField(item.success)
        buf ++= validateField(item.error)
        buf.toList
      }
    
      def withoutPassthroughFields(original: Result): Result =
        new Result(
          success =
            {
              val field = original.success
              field.map { field =>
                ch.unibas.cs.gravis.realsense.CaptureResult.withoutPassthroughFields(field)
              }
            },
          error =
            {
              val field = original.error
              field.map { field =>
                ch.unibas.cs.gravis.realsense.ThriftServerError.withoutPassthroughFields(field)
              }
            }
        )
    
      override def encode(_item: Result, _oproto: TProtocol): Unit = {
        _item.write(_oproto)
      }
    
    
      override def decode(_iprot: TProtocol): Result = {
        var success: _root_.scala.Option[ch.unibas.cs.gravis.realsense.CaptureResult] = _root_.scala.None
        var error: _root_.scala.Option[ch.unibas.cs.gravis.realsense.ThriftServerError] = _root_.scala.None
        var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
        var _done = false
    
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 0 =>
                _field.`type` match {
                  case TType.STRUCT =>
                    success = _root_.scala.Some(readSuccessValue(_iprot))
                  case _actualType =>
                    val _expectedType = TType.STRUCT
                    throw new TProtocolException(
                      "Received wrong type for field 'success' (expected=%s, actual=%s).".format(
                        ttypeToString(_expectedType),
                        ttypeToString(_actualType)
                      )
                    )
                }
              case 1 =>
                _field.`type` match {
                  case TType.STRUCT =>
                    error = _root_.scala.Some(readErrorValue(_iprot))
                  case _actualType =>
                    val _expectedType = TType.STRUCT
                    throw new TProtocolException(
                      "Received wrong type for field 'error' (expected=%s, actual=%s).".format(
                        ttypeToString(_expectedType),
                        ttypeToString(_actualType)
                      )
                    )
                }
              case _ =>
                if (_passthroughFields == null)
                  _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
                _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
    
        new Result(
          success,
          error,
          if (_passthroughFields == null)
            NoPassthroughFields
          else
            _passthroughFields.result()
        )
      }
    
      def apply(
        success: _root_.scala.Option[ch.unibas.cs.gravis.realsense.CaptureResult] = _root_.scala.None,
        error: _root_.scala.Option[ch.unibas.cs.gravis.realsense.ThriftServerError] = _root_.scala.None
      ): Result =
        new Result(
          success,
          error
        )
    
      def unapply(_item: Result): _root_.scala.Option[_root_.scala.Tuple2[Option[ch.unibas.cs.gravis.realsense.CaptureResult], Option[ch.unibas.cs.gravis.realsense.ThriftServerError]]] = _root_.scala.Some(_item.toTuple)
    
    
      @inline private[realsense] def readSuccessValue(_iprot: TProtocol): ch.unibas.cs.gravis.realsense.CaptureResult = {
        ch.unibas.cs.gravis.realsense.CaptureResult.decode(_iprot)
      }
    
      @inline private def writeSuccessField(success_item: ch.unibas.cs.gravis.realsense.CaptureResult, _oprot: TProtocol): Unit = {
        _oprot.writeFieldBegin(SuccessField)
        writeSuccessValue(success_item, _oprot)
        _oprot.writeFieldEnd()
      }
    
      @inline private def writeSuccessValue(success_item: ch.unibas.cs.gravis.realsense.CaptureResult, _oprot: TProtocol): Unit = {
        success_item.write(_oprot)
      }
    
      @inline private[realsense] def readErrorValue(_iprot: TProtocol): ch.unibas.cs.gravis.realsense.ThriftServerError = {
        ch.unibas.cs.gravis.realsense.ThriftServerError.decode(_iprot)
      }
    
      @inline private def writeErrorField(error_item: ch.unibas.cs.gravis.realsense.ThriftServerError, _oprot: TProtocol): Unit = {
        _oprot.writeFieldBegin(ErrorField)
        writeErrorValue(error_item, _oprot)
        _oprot.writeFieldEnd()
      }
    
      @inline private def writeErrorValue(error_item: ch.unibas.cs.gravis.realsense.ThriftServerError, _oprot: TProtocol): Unit = {
        error_item.write(_oprot)
      }
    
    
    }
    
    class Result(
        val success: _root_.scala.Option[ch.unibas.cs.gravis.realsense.CaptureResult],
        val error: _root_.scala.Option[ch.unibas.cs.gravis.realsense.ThriftServerError],
        val _passthroughFields: immutable$Map[Short, TFieldBlob])
      extends ThriftResponse[ch.unibas.cs.gravis.realsense.CaptureResult] with ThriftStruct
      with _root_.scala.Product2[Option[ch.unibas.cs.gravis.realsense.CaptureResult], Option[ch.unibas.cs.gravis.realsense.ThriftServerError]]
      with ValidatingThriftStruct[Result]
      with java.io.Serializable
    {
      import Result._
      def this(
        success: _root_.scala.Option[ch.unibas.cs.gravis.realsense.CaptureResult] = _root_.scala.None,
        error: _root_.scala.Option[ch.unibas.cs.gravis.realsense.ThriftServerError] = _root_.scala.None
      ) = this(
        success,
        error,
        Map.empty
      )
    
      def _1 = success
      def _2 = error
    
      def toTuple: _root_.scala.Tuple2[Option[ch.unibas.cs.gravis.realsense.CaptureResult], Option[ch.unibas.cs.gravis.realsense.ThriftServerError]] = {
        (
          success,
          error
        )
      }
    
      def successField: Option[ch.unibas.cs.gravis.realsense.CaptureResult] = success
      def exceptionFields: Iterable[Option[com.twitter.scrooge.ThriftException]] = Seq(error)
    
    
      override def write(_oprot: TProtocol): Unit = {
        Result.validate(this)
        _oprot.writeStructBegin(Struct)
        if (success.isDefined) writeSuccessField(success.get, _oprot)
        if (error.isDefined) writeErrorField(error.get, _oprot)
        if (_passthroughFields.nonEmpty) {
          _passthroughFields.values.foreach { _.write(_oprot) }
        }
        _oprot.writeFieldStop()
        _oprot.writeStructEnd()
      }
    
      def copy(
        success: _root_.scala.Option[ch.unibas.cs.gravis.realsense.CaptureResult] = this.success,
        error: _root_.scala.Option[ch.unibas.cs.gravis.realsense.ThriftServerError] = this.error,
        _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
      ): Result =
        new Result(
          success,
          error,
          _passthroughFields
        )
    
      override def canEqual(other: Any): Boolean = other.isInstanceOf[Result]
    
      private def _equals(x: Result, y: Result): Boolean =
          x.productArity == y.productArity &&
          x.productIterator.sameElements(y.productIterator)
    
      override def equals(other: Any): Boolean =
        canEqual(other) &&
          _equals(this, other.asInstanceOf[Result]) &&
          _passthroughFields == other.asInstanceOf[Result]._passthroughFields
    
      override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)
    
      override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)
    
    
      override def productArity: Int = 2
    
      override def productElement(n: Int): Any = n match {
        case 0 => this.success
        case 1 => this.error
        case _ => throw new IndexOutOfBoundsException(n.toString)
      }
    
      override def productPrefix: String = "Result"
    
      def _codec: ValidatingThriftStructCodec3[Result] = Result
    }

    val annotations: immutable$Map[String, String] = immutable$Map.empty

    type FunctionType = Function1[Args,Future[ch.unibas.cs.gravis.realsense.CaptureResult]]
    type ReqRepFunctionType = Function1[_root_.com.twitter.scrooge.Request[Args],Future[_root_.com.twitter.scrooge.Response[ch.unibas.cs.gravis.realsense.CaptureResult]]]

    type ServiceIfaceServiceType = _root_.com.twitter.finagle.Service[Args, SuccessType]
    type ServicePerEndpointServiceType = _root_.com.twitter.finagle.Service[Args, SuccessType]
    type ReqRepServicePerEndpointServiceType = _root_.com.twitter.finagle.Service[_root_.com.twitter.scrooge.Request[Args], _root_.com.twitter.scrooge.Response[SuccessType]]

    def toServiceIfaceService(f: FunctionType): ServiceIfaceServiceType =
      _root_.com.twitter.finagle.Service.mk { args: Args =>
        f(args)
      }

    def toServicePerEndpointService(f: FunctionType): ServicePerEndpointServiceType =
      _root_.com.twitter.finagle.Service.mk { args: Args =>
        f(args)
      }

    def toReqRepServicePerEndpointService(f: ReqRepFunctionType): ReqRepServicePerEndpointServiceType =
      _root_.com.twitter.finagle.Service.mk[_root_.com.twitter.scrooge.Request[Args], _root_.com.twitter.scrooge.Response[SuccessType]] { request: _root_.com.twitter.scrooge.Request[Args] =>
        f(request)
      }

    private[this] val toResult = (res: SuccessType) => Result(Some(res))

    val name: String = "capture"
    val serviceName: String = "RealSenseService"
    val argsCodec = Args
    val responseCodec = Result
    val oneway: Boolean = false
  }

  // Compatibility aliases.
  val capture$args = Capture.Args
  type capture$args = Capture.Args

  val capture$result = Capture.Result
  type capture$result = Capture.Result


  trait MethodPerEndpoint
    extends RealSenseService[Future] {
    
    def capture(): Future[ch.unibas.cs.gravis.realsense.CaptureResult]
  }

  object MethodPerEndpoint {

    def apply(servicePerEndpoint: ServicePerEndpoint): MethodPerEndpoint = {
      new MethodPerEndpointImpl(servicePerEndpoint) {}
    }

    /**
     * Use `MethodPerEndpoint.apply()` instead of this constructor.
     */
    class MethodPerEndpointImpl protected (servicePerEndpoint: ServicePerEndpoint)
      extends MethodPerEndpoint {
        def capture(): Future[ch.unibas.cs.gravis.realsense.CaptureResult] =
          servicePerEndpoint.capture(self.Capture.Args())

        override def asClosable: _root_.com.twitter.util.Closable =
          servicePerEndpoint.asClosable
    }
  }

  object ReqRepMethodPerEndpoint {

    def apply(servicePerEndpoint: ReqRepServicePerEndpoint): MethodPerEndpoint =
      new ReqRepMethodPerEndpointImpl(servicePerEndpoint) { }

    /**
     * Use `ReqRepMethodPerEndpoint.apply()` instead of this constructor.
     */
    class ReqRepMethodPerEndpointImpl protected (servicePerEndpoint: ReqRepServicePerEndpoint)
      extends MethodPerEndpoint {

        def capture(): Future[ch.unibas.cs.gravis.realsense.CaptureResult] = {
          val requestCtx = _root_.com.twitter.finagle.context.Contexts.local.getOrElse(_root_.com.twitter.finagle.thrift.Headers.Request.Key, () => _root_.com.twitter.finagle.thrift.Headers.Request.newValues)
          val scroogeRequest = _root_.com.twitter.scrooge.Request(requestCtx.values, self.Capture.Args())
          servicePerEndpoint.capture(scroogeRequest).transform(_root_.com.twitter.finagle.thrift.service.ThriftReqRepServicePerEndpoint.transformResult(_))
        }

        override def asClosable: _root_.com.twitter.util.Closable =
          servicePerEndpoint.asClosable
    }
  }

  @deprecated("Use MethodPerEndpoint", "2017-11-07")
  class MethodIface(serviceIface: BaseServiceIface)
    extends FutureIface {
    def capture(): Future[ch.unibas.cs.gravis.realsense.CaptureResult] =
      serviceIface.capture(self.Capture.Args())
  }

  implicit object MethodPerEndpointBuilder
    extends _root_.com.twitter.finagle.thrift.service.MethodPerEndpointBuilder[ServicePerEndpoint, MethodPerEndpoint] {
    def methodPerEndpoint(servicePerEndpoint: ServicePerEndpoint): MethodPerEndpoint =
      MethodPerEndpoint(servicePerEndpoint)
  }

  @deprecated("Use MethodPerEndpointBuilder", "2018-01-12")
  implicit object ThriftServiceBuilder
    extends _root_.com.twitter.finagle.thrift.service.ThriftServiceBuilder[ServicePerEndpoint, RealSenseService[Future]] {
    def build(servicePerEndpoint: ServicePerEndpoint): MethodPerEndpoint =
      MethodPerEndpoint(servicePerEndpoint)
  }

  implicit object ReqRepMethodPerEndpointBuilder
    extends _root_.com.twitter.finagle.thrift.service.ReqRepMethodPerEndpointBuilder[ReqRepServicePerEndpoint, MethodPerEndpoint] {
    def methodPerEndpoint(servicePerEndpoint: ReqRepServicePerEndpoint): MethodPerEndpoint =
      ReqRepMethodPerEndpoint(servicePerEndpoint)
  }

  @deprecated("Use ReqRepMethodPerEndpointBuilder", "2018-01-12")
  implicit object ReqRepThriftServiceBuilder
    extends _root_.com.twitter.finagle.thrift.service.ReqRepThriftServiceBuilder[ReqRepServicePerEndpoint, RealSenseService[Future]] {
    def build(servicePerEndpoint: ReqRepServicePerEndpoint): MethodPerEndpoint =
      ReqRepMethodPerEndpoint(servicePerEndpoint)
  }

  @deprecated("Use MethodPerEndpointBuilder", "2017-11-07")
  implicit object MethodIfaceBuilder
    extends com.twitter.finagle.thrift.MethodIfaceBuilder[ServiceIface, RealSenseService[Future]] {
    def newMethodIface(serviceIface: ServiceIface): MethodIface =
      new MethodIface(serviceIface)
  }

  @deprecated("Use MethodPerEndpoint", "2017-11-07")
  trait FutureIface
    extends RealSenseService[Future] {
    
    def capture(): Future[ch.unibas.cs.gravis.realsense.CaptureResult]
  }

  class FinagledClient(
      service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
      clientParam: RichClientParam)
    extends RealSenseService$FinagleClient(service, clientParam)
    with FutureIface
    with MethodPerEndpoint {

    @deprecated("Use com.twitter.finagle.thrift.RichClientParam", "2017-08-16")
    def this(
      service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
      protocolFactory: org.apache.thrift.protocol.TProtocolFactory = Protocols.binaryFactory(),
      serviceName: String = "RealSenseService",
      stats: com.twitter.finagle.stats.StatsReceiver = com.twitter.finagle.stats.NullStatsReceiver,
      responseClassifier: ctfs.ResponseClassifier = ctfs.ResponseClassifier.Default
    ) = this(
      service,
      RichClientParam(
        protocolFactory,
        serviceName,
        clientStats = stats,
        responseClassifier = responseClassifier
      )
    )

    @deprecated("Use com.twitter.finagle.thrift.RichClientParam", "2017-08-16")
    def this(
      service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
      protocolFactory: org.apache.thrift.protocol.TProtocolFactory,
      serviceName: String,
      stats: com.twitter.finagle.stats.StatsReceiver
    ) = this(
      service,
      RichClientParam(
        protocolFactory,
        serviceName,
        clientStats = stats
      )
    )
  }

  class FinagledService(
      iface: RealSenseService[Future],
      serverParam: RichServerParam)
    extends RealSenseService$FinagleService(iface, serverParam) {

    @deprecated("Use com.twitter.finagle.thrift.RichServerParam", "2017-08-16")
    def this(
      iface: RealSenseService[Future],
      protocolFactory: org.apache.thrift.protocol.TProtocolFactory,
      serviceName: String = "RealSenseService"
    ) = this(iface, RichServerParam(protocolFactory, serviceName))
  }
}