/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.exampleDemo.NettyDemo.intergraThrift.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-08-30")
public class ThriftRequest implements org.apache.thrift.TBase<ThriftRequest, ThriftRequest._Fields>, java.io.Serializable, Cloneable, Comparable<ThriftRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ThriftRequest");

  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField REQUEST_PARAM_FIELD_DESC = new org.apache.thrift.protocol.TField("requestParam", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ThriftRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ThriftRequestTupleSchemeFactory();

  /**
   * 
   * @see RequestType
   */
  public RequestType type; // required
  public java.nio.ByteBuffer requestParam; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see RequestType
     */
    TYPE((short)1, "type"),
    REQUEST_PARAM((short)2, "requestParam");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TYPE
          return TYPE;
        case 2: // REQUEST_PARAM
          return REQUEST_PARAM;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.REQUEST_PARAM};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, RequestType.class)));
    tmpMap.put(_Fields.REQUEST_PARAM, new org.apache.thrift.meta_data.FieldMetaData("requestParam", org.apache.thrift.TFieldRequirementType.OPTIONAL,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ThriftRequest.class, metaDataMap);
  }

  public ThriftRequest() {
  }

  public ThriftRequest(
    RequestType type)
  {
    this();
    this.type = type;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftRequest(ThriftRequest other) {
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetRequestParam()) {
      this.requestParam = org.apache.thrift.TBaseHelper.copyBinary(other.requestParam);
    }
  }

  public ThriftRequest deepCopy() {
    return new ThriftRequest(this);
  }

  @Override
  public void clear() {
    this.type = null;
    this.requestParam = null;
  }

  /**
   *
   * @see RequestType
   */
  public RequestType getType() {
    return this.type;
  }

  /**
   *
   * @see RequestType
   */
  public ThriftRequest setType(RequestType type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  public byte[] getRequestParam() {
    setRequestParam(org.apache.thrift.TBaseHelper.rightSize(requestParam));
    return requestParam == null ? null : requestParam.array();
  }

  public java.nio.ByteBuffer bufferForRequestParam() {
    return org.apache.thrift.TBaseHelper.copyBinary(requestParam);
  }

  public ThriftRequest setRequestParam(byte[] requestParam) {
    this.requestParam = requestParam == null ? (java.nio.ByteBuffer)null : java.nio.ByteBuffer.wrap(requestParam.clone());
    return this;
  }

  public ThriftRequest setRequestParam(java.nio.ByteBuffer requestParam) {
    this.requestParam = org.apache.thrift.TBaseHelper.copyBinary(requestParam);
    return this;
  }

  public void unsetRequestParam() {
    this.requestParam = null;
  }

  /** Returns true if field requestParam is set (has been assigned a value) and false otherwise */
  public boolean isSetRequestParam() {
    return this.requestParam != null;
  }

  public void setRequestParamIsSet(boolean value) {
    if (!value) {
      this.requestParam = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((RequestType)value);
      }
      break;

    case REQUEST_PARAM:
      if (value == null) {
        unsetRequestParam();
      } else {
        if (value instanceof byte[]) {
          setRequestParam((byte[])value);
        } else {
          setRequestParam((java.nio.ByteBuffer)value);
        }
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TYPE:
      return getType();

    case REQUEST_PARAM:
      return getRequestParam();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TYPE:
      return isSetType();
    case REQUEST_PARAM:
      return isSetRequestParam();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftRequest)
      return this.equals((ThriftRequest)that);
    return false;
  }

  public boolean equals(ThriftRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_requestParam = true && this.isSetRequestParam();
    boolean that_present_requestParam = true && that.isSetRequestParam();
    if (this_present_requestParam || that_present_requestParam) {
      if (!(this_present_requestParam && that_present_requestParam))
        return false;
      if (!this.requestParam.equals(that.requestParam))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetType()) ? 131071 : 524287);
    if (isSetType())
      hashCode = hashCode * 8191 + type.getValue();

    hashCode = hashCode * 8191 + ((isSetRequestParam()) ? 131071 : 524287);
    if (isSetRequestParam())
      hashCode = hashCode * 8191 + requestParam.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(ThriftRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetType()).compareTo(other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRequestParam()).compareTo(other.isSetRequestParam());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRequestParam()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.requestParam, other.requestParam);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ThriftRequest(");
    boolean first = true;

    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
    }
    first = false;
    if (isSetRequestParam()) {
      if (!first) sb.append(", ");
      sb.append("requestParam:");
      if (this.requestParam == null) {
        sb.append("null");
      } else {
        org.apache.thrift.TBaseHelper.toString(this.requestParam, sb);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (type == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'type' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ThriftRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ThriftRequestStandardScheme getScheme() {
      return new ThriftRequestStandardScheme();
    }
  }

  private static class ThriftRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<ThriftRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ThriftRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
          break;
        }
        switch (schemeField.id) {
          case 1: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type = RequestType.findByValue(iprot.readI32());
              struct.setTypeIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // REQUEST_PARAM
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.requestParam = iprot.readBinary();
              struct.setRequestParamIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ThriftRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        oprot.writeI32(struct.type.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.requestParam != null) {
        if (struct.isSetRequestParam()) {
          oprot.writeFieldBegin(REQUEST_PARAM_FIELD_DESC);
          oprot.writeBinary(struct.requestParam);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ThriftRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ThriftRequestTupleScheme getScheme() {
      return new ThriftRequestTupleScheme();
    }
  }

  private static class ThriftRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<ThriftRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ThriftRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.type.getValue());
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetRequestParam()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetRequestParam()) {
        oprot.writeBinary(struct.requestParam);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ThriftRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.type = RequestType.findByValue(iprot.readI32());
      struct.setTypeIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.requestParam = iprot.readBinary();
        struct.setRequestParamIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
