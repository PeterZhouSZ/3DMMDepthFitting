/**
 * Generated by Scrooge
 * version: 18.4.0
 * rev: b64bcb47af2451b2e51a1ed1b3876f6c06c642b3
 * built at: 20180410-144039
 */
package ch.unibas.cs.gravis.realsense

import scala.collection.Map
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder


object ThriftVector3D extends ValidatingThriftStructCodec3[ThriftVector3D] {
    val NoPassthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty[Short, TFieldBlob]
    val Struct = new TStruct("ThriftVector3D")
    val XField = new TField("x", TType.DOUBLE, 1)
    val XFieldManifest = implicitly[Manifest[Double]]
    val YField = new TField("y", TType.DOUBLE, 2)
    val YFieldManifest = implicitly[Manifest[Double]]
    val ZField = new TField("z", TType.DOUBLE, 3)
    val ZFieldManifest = implicitly[Manifest[Double]]

    /**
     * Field information in declaration order.
     */
    lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
        new ThriftStructFieldInfo(
            XField,
            false,
            true,
            XFieldManifest,
            _root_.scala.None,
            _root_.scala.None,
            immutable$Map.empty[String, String],
            immutable$Map.empty[String, String],
            None
        ),
        new ThriftStructFieldInfo(
            YField,
            false,
            true,
            YFieldManifest,
            _root_.scala.None,
            _root_.scala.None,
            immutable$Map.empty[String, String],
            immutable$Map.empty[String, String],
            None
        ),
        new ThriftStructFieldInfo(
            ZField,
            false,
            true,
            ZFieldManifest,
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
    def validate(_item: ThriftVector3D): Unit = {
    }

    /**
     * Checks that the struct is a valid as a new instance. If there are any missing required or
     * construction required fields, return a non-empty list.
     */
    def validateNewInstance(item: ThriftVector3D): scala.Seq[com.twitter.scrooge.validation.Issue] = {
        val buf = scala.collection.mutable.ListBuffer.empty[com.twitter.scrooge.validation.Issue]

        buf ++= validateField(item.x)
        buf ++= validateField(item.y)
        buf ++= validateField(item.z)
        buf.toList
    }

    def withoutPassthroughFields(original: ThriftVector3D): ThriftVector3D =
        new Immutable(
            x = {
                val field = original.x
                field
            },
            y = {
                val field = original.y
                field
            },
            z = {
                val field = original.z
                field
            }
        )

    override def encode(_item: ThriftVector3D, _oproto: TProtocol): Unit = {
        _item.write(_oproto)
    }


    private[this] def lazyDecode(_iprot: LazyTProtocol): ThriftVector3D = {

        var x: Double = 0.0
        var _got_x = false
        var y: Double = 0.0
        var _got_y = false
        var z: Double = 0.0
        var _got_z = false

        var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
        var _done = false
        val _start_offset = _iprot.offset

        _iprot.readStructBegin()
        while (!_done) {
            val _field = _iprot.readFieldBegin()
            if (_field.`type` == TType.STOP) {
                _done = true
            } else {
                _field.id match {
                    case 1 =>
                        _field.`type` match {
                            case TType.DOUBLE =>

                                x = readXValue(_iprot)
                                _got_x = true
                            case _actualType =>
                                val _expectedType = TType.DOUBLE
                                throw new TProtocolException(
                                    "Received wrong type for field 'x' (expected=%s, actual=%s).".format(
                                        ttypeToString(_expectedType),
                                        ttypeToString(_actualType)
                                    )
                                )
                        }
                    case 2 =>
                        _field.`type` match {
                            case TType.DOUBLE =>

                                y = readYValue(_iprot)
                                _got_y = true
                            case _actualType =>
                                val _expectedType = TType.DOUBLE
                                throw new TProtocolException(
                                    "Received wrong type for field 'y' (expected=%s, actual=%s).".format(
                                        ttypeToString(_expectedType),
                                        ttypeToString(_actualType)
                                    )
                                )
                        }
                    case 3 =>
                        _field.`type` match {
                            case TType.DOUBLE =>

                                z = readZValue(_iprot)
                                _got_z = true
                            case _actualType =>
                                val _expectedType = TType.DOUBLE
                                throw new TProtocolException(
                                    "Received wrong type for field 'z' (expected=%s, actual=%s).".format(
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

        if (!_got_x) throw new TProtocolException("Required field 'x' was not found in serialized data for struct ThriftVector3D")
        if (!_got_y) throw new TProtocolException("Required field 'y' was not found in serialized data for struct ThriftVector3D")
        if (!_got_z) throw new TProtocolException("Required field 'z' was not found in serialized data for struct ThriftVector3D")
        new LazyImmutable(
            _iprot,
            _iprot.buffer,
            _start_offset,
            _iprot.offset,
            x,
            y,
            z,
            if (_passthroughFields == null)
                NoPassthroughFields
            else
                _passthroughFields.result()
        )
    }

    override def decode(_iprot: TProtocol): ThriftVector3D =
        _iprot match {
            case i: LazyTProtocol => lazyDecode(i)
            case i => eagerDecode(i)
        }

    private[realsense] def eagerDecode(_iprot: TProtocol): ThriftVector3D = {
        var x: Double = 0.0
        var _got_x = false
        var y: Double = 0.0
        var _got_y = false
        var z: Double = 0.0
        var _got_z = false
        var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
        var _done = false

        _iprot.readStructBegin()
        while (!_done) {
            val _field = _iprot.readFieldBegin()
            if (_field.`type` == TType.STOP) {
                _done = true
            } else {
                _field.id match {
                    case 1 =>
                        _field.`type` match {
                            case TType.DOUBLE =>
                                x = readXValue(_iprot)
                                _got_x = true
                            case _actualType =>
                                val _expectedType = TType.DOUBLE
                                throw new TProtocolException(
                                    "Received wrong type for field 'x' (expected=%s, actual=%s).".format(
                                        ttypeToString(_expectedType),
                                        ttypeToString(_actualType)
                                    )
                                )
                        }
                    case 2 =>
                        _field.`type` match {
                            case TType.DOUBLE =>
                                y = readYValue(_iprot)
                                _got_y = true
                            case _actualType =>
                                val _expectedType = TType.DOUBLE
                                throw new TProtocolException(
                                    "Received wrong type for field 'y' (expected=%s, actual=%s).".format(
                                        ttypeToString(_expectedType),
                                        ttypeToString(_actualType)
                                    )
                                )
                        }
                    case 3 =>
                        _field.`type` match {
                            case TType.DOUBLE =>
                                z = readZValue(_iprot)
                                _got_z = true
                            case _actualType =>
                                val _expectedType = TType.DOUBLE
                                throw new TProtocolException(
                                    "Received wrong type for field 'z' (expected=%s, actual=%s).".format(
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

        if (!_got_x) throw new TProtocolException("Required field 'x' was not found in serialized data for struct ThriftVector3D")
        if (!_got_y) throw new TProtocolException("Required field 'y' was not found in serialized data for struct ThriftVector3D")
        if (!_got_z) throw new TProtocolException("Required field 'z' was not found in serialized data for struct ThriftVector3D")
        new Immutable(
            x,
            y,
            z,
            if (_passthroughFields == null)
                NoPassthroughFields
            else
                _passthroughFields.result()
        )
    }

    def apply(
                 x: Double,
                 y: Double,
                 z: Double
             ): ThriftVector3D =
        new Immutable(
            x,
            y,
            z
        )

    def unapply(_item: ThriftVector3D): _root_.scala.Option[_root_.scala.Tuple3[Double, Double, Double]] = _root_.scala.Some(_item.toTuple)


    @inline private[realsense] def readXValue(_iprot: TProtocol): Double = {
        _iprot.readDouble()
    }

    @inline private def writeXField(x_item: Double, _oprot: TProtocol): Unit = {
        _oprot.writeFieldBegin(XField)
        writeXValue(x_item, _oprot)
        _oprot.writeFieldEnd()
    }

    @inline private def writeXValue(x_item: Double, _oprot: TProtocol): Unit = {
        _oprot.writeDouble(x_item)
    }

    @inline private[realsense] def readYValue(_iprot: TProtocol): Double = {
        _iprot.readDouble()
    }

    @inline private def writeYField(y_item: Double, _oprot: TProtocol): Unit = {
        _oprot.writeFieldBegin(YField)
        writeYValue(y_item, _oprot)
        _oprot.writeFieldEnd()
    }

    @inline private def writeYValue(y_item: Double, _oprot: TProtocol): Unit = {
        _oprot.writeDouble(y_item)
    }

    @inline private[realsense] def readZValue(_iprot: TProtocol): Double = {
        _iprot.readDouble()
    }

    @inline private def writeZField(z_item: Double, _oprot: TProtocol): Unit = {
        _oprot.writeFieldBegin(ZField)
        writeZValue(z_item, _oprot)
        _oprot.writeFieldEnd()
    }

    @inline private def writeZValue(z_item: Double, _oprot: TProtocol): Unit = {
        _oprot.writeDouble(z_item)
    }


    object Immutable extends ThriftStructCodec3[ThriftVector3D] {
        override def encode(_item: ThriftVector3D, _oproto: TProtocol): Unit = {
            _item.write(_oproto)
        }

        override def decode(_iprot: TProtocol): ThriftVector3D = ThriftVector3D.decode(_iprot)

        override lazy val metaData: ThriftStructMetaData[ThriftVector3D] = ThriftVector3D.metaData
    }

    /**
     * The default read-only implementation of ThriftVector3D.  You typically should not need to
     * directly reference this class; instead, use the ThriftVector3D.apply method to construct
     * new instances.
     */
    class Immutable(
                       val x: Double,
                       val y: Double,
                       val z: Double,
                       override val _passthroughFields: immutable$Map[Short, TFieldBlob])
        extends ThriftVector3D {
        def this(
                    x: Double,
                    y: Double,
                    z: Double
                ) = this(
            x,
            y,
            z,
            Map.empty[Short, TFieldBlob]
        )
    }

    /**
     * This is another Immutable, this however keeps strings as lazy values that are lazily decoded from the backing
     * array byte on read.
     */
    private[this] class LazyImmutable(
                                         _proto: LazyTProtocol,
                                         _buf: Array[Byte],
                                         _start_offset: Int,
                                         _end_offset: Int,
                                         val x: Double,
                                         val y: Double,
                                         val z: Double,
                                         override val _passthroughFields: immutable$Map[Short, TFieldBlob])
        extends ThriftVector3D {

        override def write(_oprot: TProtocol): Unit = {
            _oprot match {
                case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
                case _ => super.write(_oprot)
            }
        }


        /**
         * Override the super hash code to make it a lazy val rather than def.
         *
         * Calculating the hash code can be expensive, caching it where possible
         * can provide significant performance wins. (Key in a hash map for instance)
         * Usually not safe since the normal constructor will accept a mutable map or
         * set as an arg
         * Here however we control how the class is generated from serialized data.
         * With the class private and the contract that we throw away our mutable references
         * having the hash code lazy here is safe.
         */
        override lazy val hashCode = super.hashCode
    }

    /**
     * This Proxy trait allows you to extend the ThriftVector3D trait with additional state or
     * behavior and implement the read-only methods from ThriftVector3D using an underlying
     * instance.
     */
    trait Proxy extends ThriftVector3D {
        protected def _underlying_ThriftVector3D: ThriftVector3D

        override def x: Double = _underlying_ThriftVector3D.x

        override def y: Double = _underlying_ThriftVector3D.y

        override def z: Double = _underlying_ThriftVector3D.z

        override def _passthroughFields = _underlying_ThriftVector3D._passthroughFields
    }

}

/**
 * Prefer the companion object's [[ch.unibas.cs.gravis.realsense.ThriftVector3D.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait ThriftVector3D
    extends ThriftStruct
        with _root_.scala.Product3[Double, Double, Double]
        with ValidatingThriftStruct[ThriftVector3D]
        with java.io.Serializable {

    import ThriftVector3D._

    def x: Double

    def y: Double

    def z: Double

    def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

    def _1 = x

    def _2 = y

    def _3 = z

    def toTuple: _root_.scala.Tuple3[Double, Double, Double] = {
        (
            x,
            y,
            z
        )
    }


    /**
     * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
     * is present in the passthrough map, that value is returned.  Otherwise, if the specified field
     * is known and not optional and set to None, then the field is serialized and returned.
     */
    def getFieldBlob(_fieldId: Short): _root_.scala.Option[TFieldBlob] = {
        lazy val _buff = new TMemoryBuffer(32)
        lazy val _oprot = new TCompactProtocol(_buff)
        _passthroughFields.get(_fieldId) match {
            case blob: _root_.scala.Some[TFieldBlob] => blob
            case _root_.scala.None => {
                val _fieldOpt: _root_.scala.Option[TField] =
                    _fieldId match {
                        case 1 =>
                            if (true) {
                                writeXValue(x, _oprot)
                                _root_.scala.Some(ThriftVector3D.XField)
                            } else {
                                _root_.scala.None
                            }
                        case 2 =>
                            if (true) {
                                writeYValue(y, _oprot)
                                _root_.scala.Some(ThriftVector3D.YField)
                            } else {
                                _root_.scala.None
                            }
                        case 3 =>
                            if (true) {
                                writeZValue(z, _oprot)
                                _root_.scala.Some(ThriftVector3D.ZField)
                            } else {
                                _root_.scala.None
                            }
                        case _ => _root_.scala.None
                    }
                _fieldOpt match {
                    case _root_.scala.Some(_field) =>
                        _root_.scala.Some(TFieldBlob(_field, Buf.ByteArray.Owned(_buff.getArray())))
                    case _root_.scala.None =>
                        _root_.scala.None
                }
            }
        }
    }

    /**
     * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
     */
    def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
        (ids flatMap { id => getFieldBlob(id) map {
            id -> _
        }
        }).toMap

    /**
     * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
     * field, the blob is decoded and the field is set to the decoded value.  If the field
     * is unknown and passthrough fields are enabled, then the blob will be stored in
     * _passthroughFields.
     */
    def setField(_blob: TFieldBlob): ThriftVector3D = {
        var x: Double = this.x
        var y: Double = this.y
        var z: Double = this.z
        var _passthroughFields = this._passthroughFields
        _blob.id match {
            case 1 =>
                x = readXValue(_blob.read)
            case 2 =>
                y = readYValue(_blob.read)
            case 3 =>
                z = readZValue(_blob.read)
            case _ => _passthroughFields += (_blob.id -> _blob)
        }
        new Immutable(
            x,
            y,
            z,
            _passthroughFields
        )
    }

    /**
     * If the specified field is optional, it is set to None.  Otherwise, if the field is
     * known, it is reverted to its default value; if the field is unknown, it is removed
     * from the passthroughFields map, if present.
     */
    def unsetField(_fieldId: Short): ThriftVector3D = {
        var x: Double = this.x
        var y: Double = this.y
        var z: Double = this.z

        _fieldId match {
            case 1 =>
                x = 0.0
            case 2 =>
                y = 0.0
            case 3 =>
                z = 0.0
            case _ =>
        }
        new Immutable(
            x,
            y,
            z,
            _passthroughFields - _fieldId
        )
    }

    /**
     * If the specified field is optional, it is set to None.  Otherwise, if the field is
     * known, it is reverted to its default value; if the field is unknown, it is removed
     * from the passthroughFields map, if present.
     */
    def unsetX: ThriftVector3D = unsetField(1)

    def unsetY: ThriftVector3D = unsetField(2)

    def unsetZ: ThriftVector3D = unsetField(3)


    override def write(_oprot: TProtocol): Unit = {
        ThriftVector3D.validate(this)
        _oprot.writeStructBegin(Struct)
        writeXField(x, _oprot)
        writeYField(y, _oprot)
        writeZField(z, _oprot)
        if (_passthroughFields.nonEmpty) {
            _passthroughFields.values.foreach {
                _.write(_oprot)
            }
        }
        _oprot.writeFieldStop()
        _oprot.writeStructEnd()
    }

    def copy(
                x: Double = this.x,
                y: Double = this.y,
                z: Double = this.z,
                _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
            ): ThriftVector3D =
        new Immutable(
            x,
            y,
            z,
            _passthroughFields
        )

    override def canEqual(other: Any): Boolean = other.isInstanceOf[ThriftVector3D]

    private def _equals(x: ThriftVector3D, y: ThriftVector3D): Boolean =
        x.productArity == y.productArity &&
            x.productIterator.sameElements(y.productIterator)

    override def equals(other: Any): Boolean =
        canEqual(other) &&
            _equals(this, other.asInstanceOf[ThriftVector3D]) &&
            _passthroughFields == other.asInstanceOf[ThriftVector3D]._passthroughFields

    override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

    override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


    override def productArity: Int = 3

    override def productElement(n: Int): Any = n match {
        case 0 => this.x
        case 1 => this.y
        case 2 => this.z
        case _ => throw new IndexOutOfBoundsException(n.toString)
    }

    override def productPrefix: String = "ThriftVector3D"

    def _codec: ValidatingThriftStructCodec3[ThriftVector3D] = ThriftVector3D
}

