// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: descriptor.proto

package com.google.protobuf;

/**
 * Protobuf type {@code google.protobuf.MethodDescriptorProto}
 *
 * <pre>
 * Describes a method of a service.
 * </pre>
 */
public  final class MethodDescriptorProto extends
    com.google.protobuf.GeneratedMessage
    implements MethodDescriptorProtoOrBuilder {
  // Use MethodDescriptorProto.newBuilder() to construct.
  private MethodDescriptorProto(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private MethodDescriptorProto(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final MethodDescriptorProto defaultInstance;
  public static MethodDescriptorProto getDefaultInstance() {
    return defaultInstance;
  }

  public MethodDescriptorProto getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private MethodDescriptorProto(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    initFields();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(input, unknownFields,
                                   extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            bitField0_ |= 0x00000001;
            name_ = input.readBytes();
            break;
          }
          case 18: {
            bitField0_ |= 0x00000002;
            inputType_ = input.readBytes();
            break;
          }
          case 26: {
            bitField0_ |= 0x00000004;
            outputType_ = input.readBytes();
            break;
          }
          case 34: {
            com.google.protobuf.MethodOptions.Builder subBuilder = null;
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
              subBuilder = options_.toBuilder();
            }
            options_ = input.readMessage(com.google.protobuf.MethodOptions.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(options_);
              options_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000008;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e.getMessage()).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.protobuf.MethodDescriptorProto.class, com.google.protobuf.MethodDescriptorProto.Builder.class);
  }

  public static com.google.protobuf.Parser<MethodDescriptorProto> PARSER =
      new com.google.protobuf.AbstractParser<MethodDescriptorProto>() {
    public MethodDescriptorProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MethodDescriptorProto(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<MethodDescriptorProto> getParserForType() {
    return PARSER;
  }

  private int bitField0_;
  // optional string name = 1;
  public static final int NAME_FIELD_NUMBER = 1;
  private java.lang.Object name_;
  /**
   * <code>optional string name = 1;</code>
   */
  public boolean hasName() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional string name = 1;</code>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        name_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string name = 1;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  // optional string input_type = 2;
  public static final int INPUT_TYPE_FIELD_NUMBER = 2;
  private java.lang.Object inputType_;
  /**
   * <code>optional string input_type = 2;</code>
   *
   * <pre>
   * Input and output type names.  These are resolved in the same way as
   * FieldDescriptorProto.type_name, but must refer to a message type.
   * </pre>
   */
  public boolean hasInputType() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional string input_type = 2;</code>
   *
   * <pre>
   * Input and output type names.  These are resolved in the same way as
   * FieldDescriptorProto.type_name, but must refer to a message type.
   * </pre>
   */
  public java.lang.String getInputType() {
    java.lang.Object ref = inputType_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        inputType_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string input_type = 2;</code>
   *
   * <pre>
   * Input and output type names.  These are resolved in the same way as
   * FieldDescriptorProto.type_name, but must refer to a message type.
   * </pre>
   */
  public com.google.protobuf.ByteString
      getInputTypeBytes() {
    java.lang.Object ref = inputType_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      inputType_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  // optional string output_type = 3;
  public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
  private java.lang.Object outputType_;
  /**
   * <code>optional string output_type = 3;</code>
   */
  public boolean hasOutputType() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional string output_type = 3;</code>
   */
  public java.lang.String getOutputType() {
    java.lang.Object ref = outputType_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        outputType_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string output_type = 3;</code>
   */
  public com.google.protobuf.ByteString
      getOutputTypeBytes() {
    java.lang.Object ref = outputType_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      outputType_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  // optional .google.protobuf.MethodOptions options = 4;
  public static final int OPTIONS_FIELD_NUMBER = 4;
  private com.google.protobuf.MethodOptions options_;
  /**
   * <code>optional .google.protobuf.MethodOptions options = 4;</code>
   */
  public boolean hasOptions() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional .google.protobuf.MethodOptions options = 4;</code>
   */
  public com.google.protobuf.MethodOptions getOptions() {
    return options_;
  }
  /**
   * <code>optional .google.protobuf.MethodOptions options = 4;</code>
   */
  public com.google.protobuf.MethodOptionsOrBuilder getOptionsOrBuilder() {
    return options_;
  }

  private void initFields() {
    name_ = "";
    inputType_ = "";
    outputType_ = "";
    options_ = com.google.protobuf.MethodOptions.getDefaultInstance();
  }
  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) return isInitialized == 1;

    if (hasOptions()) {
      if (!getOptions().isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeBytes(1, getNameBytes());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeBytes(2, getInputTypeBytes());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeBytes(3, getOutputTypeBytes());
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeMessage(4, options_);
    }
    getUnknownFields().writeTo(output);
  }

  private int memoizedSerializedSize = -1;
  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(1, getNameBytes());
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, getInputTypeBytes());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(3, getOutputTypeBytes());
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, options_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  protected java.lang.Object writeReplace()
      throws java.io.ObjectStreamException {
    return super.writeReplace();
  }

  public static com.google.protobuf.MethodDescriptorProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.protobuf.MethodDescriptorProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.protobuf.MethodDescriptorProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.protobuf.MethodDescriptorProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.protobuf.MethodDescriptorProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static com.google.protobuf.MethodDescriptorProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static com.google.protobuf.MethodDescriptorProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static com.google.protobuf.MethodDescriptorProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static com.google.protobuf.MethodDescriptorProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static com.google.protobuf.MethodDescriptorProto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(com.google.protobuf.MethodDescriptorProto prototype) {
    return newBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() { return newBuilder(this); }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code google.protobuf.MethodDescriptorProto}
   *
   * <pre>
   * Describes a method of a service.
   * </pre>
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder>
     implements com.google.protobuf.MethodDescriptorProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.protobuf.MethodDescriptorProto.class, com.google.protobuf.MethodDescriptorProto.Builder.class);
    }

    // Construct using com.google.protobuf.MethodDescriptorProto.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        getOptionsFieldBuilder();
      }
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      name_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      inputType_ = "";
      bitField0_ = (bitField0_ & ~0x00000002);
      outputType_ = "";
      bitField0_ = (bitField0_ & ~0x00000004);
      if (optionsBuilder_ == null) {
        options_ = com.google.protobuf.MethodOptions.getDefaultInstance();
      } else {
        optionsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
    }

    public com.google.protobuf.MethodDescriptorProto getDefaultInstanceForType() {
      return com.google.protobuf.MethodDescriptorProto.getDefaultInstance();
    }

    public com.google.protobuf.MethodDescriptorProto build() {
      com.google.protobuf.MethodDescriptorProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.google.protobuf.MethodDescriptorProto buildPartial() {
      com.google.protobuf.MethodDescriptorProto result = new com.google.protobuf.MethodDescriptorProto(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.name_ = name_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.inputType_ = inputType_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.outputType_ = outputType_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      if (optionsBuilder_ == null) {
        result.options_ = options_;
      } else {
        result.options_ = optionsBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.protobuf.MethodDescriptorProto) {
        return mergeFrom((com.google.protobuf.MethodDescriptorProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.protobuf.MethodDescriptorProto other) {
      if (other == com.google.protobuf.MethodDescriptorProto.getDefaultInstance()) return this;
      if (other.hasName()) {
        bitField0_ |= 0x00000001;
        name_ = other.name_;
        onChanged();
      }
      if (other.hasInputType()) {
        bitField0_ |= 0x00000002;
        inputType_ = other.inputType_;
        onChanged();
      }
      if (other.hasOutputType()) {
        bitField0_ |= 0x00000004;
        outputType_ = other.outputType_;
        onChanged();
      }
      if (other.hasOptions()) {
        mergeOptions(other.getOptions());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      return this;
    }

    public final boolean isInitialized() {
      if (hasOptions()) {
        if (!getOptions().isInitialized()) {
          
          return false;
        }
      }
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.google.protobuf.MethodDescriptorProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.protobuf.MethodDescriptorProto) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    // optional string name = 1;
    private java.lang.Object name_ = "";
    /**
     * <code>optional string name = 1;</code>
     */
    public boolean hasName() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional string name = 1;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        java.lang.String s = ((com.google.protobuf.ByteString) ref)
            .toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string name = 1;</code>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string name = 1;</code>
     */
    public Builder clearName() {
      bitField0_ = (bitField0_ & ~0x00000001);
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string name = 1;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      name_ = value;
      onChanged();
      return this;
    }

    // optional string input_type = 2;
    private java.lang.Object inputType_ = "";
    /**
     * <code>optional string input_type = 2;</code>
     *
     * <pre>
     * Input and output type names.  These are resolved in the same way as
     * FieldDescriptorProto.type_name, but must refer to a message type.
     * </pre>
     */
    public boolean hasInputType() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string input_type = 2;</code>
     *
     * <pre>
     * Input and output type names.  These are resolved in the same way as
     * FieldDescriptorProto.type_name, but must refer to a message type.
     * </pre>
     */
    public java.lang.String getInputType() {
      java.lang.Object ref = inputType_;
      if (!(ref instanceof java.lang.String)) {
        java.lang.String s = ((com.google.protobuf.ByteString) ref)
            .toStringUtf8();
        inputType_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string input_type = 2;</code>
     *
     * <pre>
     * Input and output type names.  These are resolved in the same way as
     * FieldDescriptorProto.type_name, but must refer to a message type.
     * </pre>
     */
    public com.google.protobuf.ByteString
        getInputTypeBytes() {
      java.lang.Object ref = inputType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        inputType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string input_type = 2;</code>
     *
     * <pre>
     * Input and output type names.  These are resolved in the same way as
     * FieldDescriptorProto.type_name, but must refer to a message type.
     * </pre>
     */
    public Builder setInputType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      inputType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string input_type = 2;</code>
     *
     * <pre>
     * Input and output type names.  These are resolved in the same way as
     * FieldDescriptorProto.type_name, but must refer to a message type.
     * </pre>
     */
    public Builder clearInputType() {
      bitField0_ = (bitField0_ & ~0x00000002);
      inputType_ = getDefaultInstance().getInputType();
      onChanged();
      return this;
    }
    /**
     * <code>optional string input_type = 2;</code>
     *
     * <pre>
     * Input and output type names.  These are resolved in the same way as
     * FieldDescriptorProto.type_name, but must refer to a message type.
     * </pre>
     */
    public Builder setInputTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      inputType_ = value;
      onChanged();
      return this;
    }

    // optional string output_type = 3;
    private java.lang.Object outputType_ = "";
    /**
     * <code>optional string output_type = 3;</code>
     */
    public boolean hasOutputType() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional string output_type = 3;</code>
     */
    public java.lang.String getOutputType() {
      java.lang.Object ref = outputType_;
      if (!(ref instanceof java.lang.String)) {
        java.lang.String s = ((com.google.protobuf.ByteString) ref)
            .toStringUtf8();
        outputType_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string output_type = 3;</code>
     */
    public com.google.protobuf.ByteString
        getOutputTypeBytes() {
      java.lang.Object ref = outputType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        outputType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string output_type = 3;</code>
     */
    public Builder setOutputType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
      outputType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string output_type = 3;</code>
     */
    public Builder clearOutputType() {
      bitField0_ = (bitField0_ & ~0x00000004);
      outputType_ = getDefaultInstance().getOutputType();
      onChanged();
      return this;
    }
    /**
     * <code>optional string output_type = 3;</code>
     */
    public Builder setOutputTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
      outputType_ = value;
      onChanged();
      return this;
    }

    // optional .google.protobuf.MethodOptions options = 4;
    private com.google.protobuf.MethodOptions options_ = com.google.protobuf.MethodOptions.getDefaultInstance();
    private com.google.protobuf.SingleFieldBuilder<
        com.google.protobuf.MethodOptions, com.google.protobuf.MethodOptions.Builder, com.google.protobuf.MethodOptionsOrBuilder> optionsBuilder_;
    /**
     * <code>optional .google.protobuf.MethodOptions options = 4;</code>
     */
    public boolean hasOptions() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional .google.protobuf.MethodOptions options = 4;</code>
     */
    public com.google.protobuf.MethodOptions getOptions() {
      if (optionsBuilder_ == null) {
        return options_;
      } else {
        return optionsBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .google.protobuf.MethodOptions options = 4;</code>
     */
    public Builder setOptions(com.google.protobuf.MethodOptions value) {
      if (optionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        options_ = value;
        onChanged();
      } else {
        optionsBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000008;
      return this;
    }
    /**
     * <code>optional .google.protobuf.MethodOptions options = 4;</code>
     */
    public Builder setOptions(
        com.google.protobuf.MethodOptions.Builder builderForValue) {
      if (optionsBuilder_ == null) {
        options_ = builderForValue.build();
        onChanged();
      } else {
        optionsBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000008;
      return this;
    }
    /**
     * <code>optional .google.protobuf.MethodOptions options = 4;</code>
     */
    public Builder mergeOptions(com.google.protobuf.MethodOptions value) {
      if (optionsBuilder_ == null) {
        if (((bitField0_ & 0x00000008) == 0x00000008) &&
            options_ != com.google.protobuf.MethodOptions.getDefaultInstance()) {
          options_ =
            com.google.protobuf.MethodOptions.newBuilder(options_).mergeFrom(value).buildPartial();
        } else {
          options_ = value;
        }
        onChanged();
      } else {
        optionsBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000008;
      return this;
    }
    /**
     * <code>optional .google.protobuf.MethodOptions options = 4;</code>
     */
    public Builder clearOptions() {
      if (optionsBuilder_ == null) {
        options_ = com.google.protobuf.MethodOptions.getDefaultInstance();
        onChanged();
      } else {
        optionsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }
    /**
     * <code>optional .google.protobuf.MethodOptions options = 4;</code>
     */
    public com.google.protobuf.MethodOptions.Builder getOptionsBuilder() {
      bitField0_ |= 0x00000008;
      onChanged();
      return getOptionsFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .google.protobuf.MethodOptions options = 4;</code>
     */
    public com.google.protobuf.MethodOptionsOrBuilder getOptionsOrBuilder() {
      if (optionsBuilder_ != null) {
        return optionsBuilder_.getMessageOrBuilder();
      } else {
        return options_;
      }
    }
    /**
     * <code>optional .google.protobuf.MethodOptions options = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        com.google.protobuf.MethodOptions, com.google.protobuf.MethodOptions.Builder, com.google.protobuf.MethodOptionsOrBuilder> 
        getOptionsFieldBuilder() {
      if (optionsBuilder_ == null) {
        optionsBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            com.google.protobuf.MethodOptions, com.google.protobuf.MethodOptions.Builder, com.google.protobuf.MethodOptionsOrBuilder>(
                options_,
                getParentForChildren(),
                isClean());
        options_ = null;
      }
      return optionsBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:google.protobuf.MethodDescriptorProto)
  }

  static {
    defaultInstance = new MethodDescriptorProto(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:google.protobuf.MethodDescriptorProto)
}
