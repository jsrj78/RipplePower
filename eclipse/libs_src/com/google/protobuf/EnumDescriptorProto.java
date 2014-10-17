// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: descriptor.proto

package com.google.protobuf;

/**
 * Protobuf type {@code google.protobuf.EnumDescriptorProto}
 * 
 * <pre>
 * Describes an enum type.
 * </pre>
 */
public final class EnumDescriptorProto extends
		com.google.protobuf.GeneratedMessage implements
		EnumDescriptorProtoOrBuilder {
	// Use EnumDescriptorProto.newBuilder() to construct.
	private EnumDescriptorProto(
			com.google.protobuf.GeneratedMessage.Builder<?> builder) {
		super(builder);
		this.unknownFields = builder.getUnknownFields();
	}

	private EnumDescriptorProto(boolean noInit) {
		this.unknownFields = com.google.protobuf.UnknownFieldSet
				.getDefaultInstance();
	}

	private static final EnumDescriptorProto defaultInstance;

	public static EnumDescriptorProto getDefaultInstance() {
		return defaultInstance;
	}

	public EnumDescriptorProto getDefaultInstanceForType() {
		return defaultInstance;
	}

	private final com.google.protobuf.UnknownFieldSet unknownFields;

	@java.lang.Override
	public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
		return this.unknownFields;
	}

	private EnumDescriptorProto(com.google.protobuf.CodedInputStream input,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws com.google.protobuf.InvalidProtocolBufferException {
		initFields();
		int mutable_bitField0_ = 0;
		com.google.protobuf.UnknownFieldSet.Builder unknownFields = com.google.protobuf.UnknownFieldSet
				.newBuilder();
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
					if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
						value_ = new java.util.ArrayList<com.google.protobuf.EnumValueDescriptorProto>();
						mutable_bitField0_ |= 0x00000002;
					}
					value_.add(input
							.readMessage(
									com.google.protobuf.EnumValueDescriptorProto.PARSER,
									extensionRegistry));
					break;
				}
				case 26: {
					com.google.protobuf.EnumOptions.Builder subBuilder = null;
					if (((bitField0_ & 0x00000002) == 0x00000002)) {
						subBuilder = options_.toBuilder();
					}
					options_ = input.readMessage(
							com.google.protobuf.EnumOptions.PARSER,
							extensionRegistry);
					if (subBuilder != null) {
						subBuilder.mergeFrom(options_);
						options_ = subBuilder.buildPartial();
					}
					bitField0_ |= 0x00000002;
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
			if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
				value_ = java.util.Collections.unmodifiableList(value_);
			}
			this.unknownFields = unknownFields.build();
			makeExtensionsImmutable();
		}
	}

	public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
		return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
	}

	protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
		return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable
				.ensureFieldAccessorsInitialized(
						com.google.protobuf.EnumDescriptorProto.class,
						com.google.protobuf.EnumDescriptorProto.Builder.class);
	}

	public static com.google.protobuf.Parser<EnumDescriptorProto> PARSER = new com.google.protobuf.AbstractParser<EnumDescriptorProto>() {
		public EnumDescriptorProto parsePartialFrom(
				com.google.protobuf.CodedInputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return new EnumDescriptorProto(input, extensionRegistry);
		}
	};

	@java.lang.Override
	public com.google.protobuf.Parser<EnumDescriptorProto> getParserForType() {
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
			com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
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
	public com.google.protobuf.ByteString getNameBytes() {
		java.lang.Object ref = name_;
		if (ref instanceof java.lang.String) {
			com.google.protobuf.ByteString b = com.google.protobuf.ByteString
					.copyFromUtf8((java.lang.String) ref);
			name_ = b;
			return b;
		} else {
			return (com.google.protobuf.ByteString) ref;
		}
	}

	// repeated .google.protobuf.EnumValueDescriptorProto value = 2;
	public static final int VALUE_FIELD_NUMBER = 2;
	private java.util.List<com.google.protobuf.EnumValueDescriptorProto> value_;

	/**
	 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
	 */
	public java.util.List<com.google.protobuf.EnumValueDescriptorProto> getValueList() {
		return value_;
	}

	/**
	 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
	 */
	public java.util.List<? extends com.google.protobuf.EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList() {
		return value_;
	}

	/**
	 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
	 */
	public int getValueCount() {
		return value_.size();
	}

	/**
	 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
	 */
	public com.google.protobuf.EnumValueDescriptorProto getValue(int index) {
		return value_.get(index);
	}

	/**
	 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
	 */
	public com.google.protobuf.EnumValueDescriptorProtoOrBuilder getValueOrBuilder(
			int index) {
		return value_.get(index);
	}

	// optional .google.protobuf.EnumOptions options = 3;
	public static final int OPTIONS_FIELD_NUMBER = 3;
	private com.google.protobuf.EnumOptions options_;

	/**
	 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
	 */
	public boolean hasOptions() {
		return ((bitField0_ & 0x00000002) == 0x00000002);
	}

	/**
	 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
	 */
	public com.google.protobuf.EnumOptions getOptions() {
		return options_;
	}

	/**
	 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
	 */
	public com.google.protobuf.EnumOptionsOrBuilder getOptionsOrBuilder() {
		return options_;
	}

	private void initFields() {
		name_ = "";
		value_ = java.util.Collections.emptyList();
		options_ = com.google.protobuf.EnumOptions.getDefaultInstance();
	}

	private byte memoizedIsInitialized = -1;

	public final boolean isInitialized() {
		byte isInitialized = memoizedIsInitialized;
		if (isInitialized != -1)
			return isInitialized == 1;

		for (int i = 0; i < getValueCount(); i++) {
			if (!getValue(i).isInitialized()) {
				memoizedIsInitialized = 0;
				return false;
			}
		}
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
		for (int i = 0; i < value_.size(); i++) {
			output.writeMessage(2, value_.get(i));
		}
		if (((bitField0_ & 0x00000002) == 0x00000002)) {
			output.writeMessage(3, options_);
		}
		getUnknownFields().writeTo(output);
	}

	private int memoizedSerializedSize = -1;

	public int getSerializedSize() {
		int size = memoizedSerializedSize;
		if (size != -1)
			return size;

		size = 0;
		if (((bitField0_ & 0x00000001) == 0x00000001)) {
			size += com.google.protobuf.CodedOutputStream.computeBytesSize(1,
					getNameBytes());
		}
		for (int i = 0; i < value_.size(); i++) {
			size += com.google.protobuf.CodedOutputStream.computeMessageSize(2,
					value_.get(i));
		}
		if (((bitField0_ & 0x00000002) == 0x00000002)) {
			size += com.google.protobuf.CodedOutputStream.computeMessageSize(3,
					options_);
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

	public static com.google.protobuf.EnumDescriptorProto parseFrom(
			com.google.protobuf.ByteString data)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data);
	}

	public static com.google.protobuf.EnumDescriptorProto parseFrom(
			com.google.protobuf.ByteString data,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data, extensionRegistry);
	}

	public static com.google.protobuf.EnumDescriptorProto parseFrom(byte[] data)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data);
	}

	public static com.google.protobuf.EnumDescriptorProto parseFrom(
			byte[] data,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data, extensionRegistry);
	}

	public static com.google.protobuf.EnumDescriptorProto parseFrom(
			java.io.InputStream input) throws java.io.IOException {
		return PARSER.parseFrom(input);
	}

	public static com.google.protobuf.EnumDescriptorProto parseFrom(
			java.io.InputStream input,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws java.io.IOException {
		return PARSER.parseFrom(input, extensionRegistry);
	}

	public static com.google.protobuf.EnumDescriptorProto parseDelimitedFrom(
			java.io.InputStream input) throws java.io.IOException {
		return PARSER.parseDelimitedFrom(input);
	}

	public static com.google.protobuf.EnumDescriptorProto parseDelimitedFrom(
			java.io.InputStream input,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws java.io.IOException {
		return PARSER.parseDelimitedFrom(input, extensionRegistry);
	}

	public static com.google.protobuf.EnumDescriptorProto parseFrom(
			com.google.protobuf.CodedInputStream input)
			throws java.io.IOException {
		return PARSER.parseFrom(input);
	}

	public static com.google.protobuf.EnumDescriptorProto parseFrom(
			com.google.protobuf.CodedInputStream input,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws java.io.IOException {
		return PARSER.parseFrom(input, extensionRegistry);
	}

	public static Builder newBuilder() {
		return Builder.create();
	}

	public Builder newBuilderForType() {
		return newBuilder();
	}

	public static Builder newBuilder(
			com.google.protobuf.EnumDescriptorProto prototype) {
		return newBuilder().mergeFrom(prototype);
	}

	public Builder toBuilder() {
		return newBuilder(this);
	}

	@java.lang.Override
	protected Builder newBuilderForType(
			com.google.protobuf.GeneratedMessage.BuilderParent parent) {
		Builder builder = new Builder(parent);
		return builder;
	}

	/**
	 * Protobuf type {@code google.protobuf.EnumDescriptorProto}
	 * 
	 * <pre>
	 * Describes an enum type.
	 * </pre>
	 */
	public static final class Builder extends
			com.google.protobuf.GeneratedMessage.Builder<Builder> implements
			com.google.protobuf.EnumDescriptorProtoOrBuilder {
		public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
			return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
		}

		protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
			return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable
					.ensureFieldAccessorsInitialized(
							com.google.protobuf.EnumDescriptorProto.class,
							com.google.protobuf.EnumDescriptorProto.Builder.class);
		}

		// Construct using com.google.protobuf.EnumDescriptorProto.newBuilder()
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
				getValueFieldBuilder();
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
			if (valueBuilder_ == null) {
				value_ = java.util.Collections.emptyList();
				bitField0_ = (bitField0_ & ~0x00000002);
			} else {
				valueBuilder_.clear();
			}
			if (optionsBuilder_ == null) {
				options_ = com.google.protobuf.EnumOptions.getDefaultInstance();
			} else {
				optionsBuilder_.clear();
			}
			bitField0_ = (bitField0_ & ~0x00000004);
			return this;
		}

		public Builder clone() {
			return create().mergeFrom(buildPartial());
		}

		public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
			return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
		}

		public com.google.protobuf.EnumDescriptorProto getDefaultInstanceForType() {
			return com.google.protobuf.EnumDescriptorProto.getDefaultInstance();
		}

		public com.google.protobuf.EnumDescriptorProto build() {
			com.google.protobuf.EnumDescriptorProto result = buildPartial();
			if (!result.isInitialized()) {
				throw newUninitializedMessageException(result);
			}
			return result;
		}

		public com.google.protobuf.EnumDescriptorProto buildPartial() {
			com.google.protobuf.EnumDescriptorProto result = new com.google.protobuf.EnumDescriptorProto(
					this);
			int from_bitField0_ = bitField0_;
			int to_bitField0_ = 0;
			if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
				to_bitField0_ |= 0x00000001;
			}
			result.name_ = name_;
			if (valueBuilder_ == null) {
				if (((bitField0_ & 0x00000002) == 0x00000002)) {
					value_ = java.util.Collections.unmodifiableList(value_);
					bitField0_ = (bitField0_ & ~0x00000002);
				}
				result.value_ = value_;
			} else {
				result.value_ = valueBuilder_.build();
			}
			if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
				to_bitField0_ |= 0x00000002;
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
			if (other instanceof com.google.protobuf.EnumDescriptorProto) {
				return mergeFrom((com.google.protobuf.EnumDescriptorProto) other);
			} else {
				super.mergeFrom(other);
				return this;
			}
		}

		public Builder mergeFrom(com.google.protobuf.EnumDescriptorProto other) {
			if (other == com.google.protobuf.EnumDescriptorProto
					.getDefaultInstance())
				return this;
			if (other.hasName()) {
				bitField0_ |= 0x00000001;
				name_ = other.name_;
				onChanged();
			}
			if (valueBuilder_ == null) {
				if (!other.value_.isEmpty()) {
					if (value_.isEmpty()) {
						value_ = other.value_;
						bitField0_ = (bitField0_ & ~0x00000002);
					} else {
						ensureValueIsMutable();
						value_.addAll(other.value_);
					}
					onChanged();
				}
			} else {
				if (!other.value_.isEmpty()) {
					if (valueBuilder_.isEmpty()) {
						valueBuilder_.dispose();
						valueBuilder_ = null;
						value_ = other.value_;
						bitField0_ = (bitField0_ & ~0x00000002);
						valueBuilder_ = com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ? getValueFieldBuilder()
								: null;
					} else {
						valueBuilder_.addAllMessages(other.value_);
					}
				}
			}
			if (other.hasOptions()) {
				mergeOptions(other.getOptions());
			}
			this.mergeUnknownFields(other.getUnknownFields());
			return this;
		}

		public final boolean isInitialized() {
			for (int i = 0; i < getValueCount(); i++) {
				if (!getValue(i).isInitialized()) {

					return false;
				}
			}
			if (hasOptions()) {
				if (!getOptions().isInitialized()) {

					return false;
				}
			}
			return true;
		}

		public Builder mergeFrom(com.google.protobuf.CodedInputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws java.io.IOException {
			com.google.protobuf.EnumDescriptorProto parsedMessage = null;
			try {
				parsedMessage = PARSER.parsePartialFrom(input,
						extensionRegistry);
			} catch (com.google.protobuf.InvalidProtocolBufferException e) {
				parsedMessage = (com.google.protobuf.EnumDescriptorProto) e
						.getUnfinishedMessage();
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
		public com.google.protobuf.ByteString getNameBytes() {
			java.lang.Object ref = name_;
			if (ref instanceof String) {
				com.google.protobuf.ByteString b = com.google.protobuf.ByteString
						.copyFromUtf8((java.lang.String) ref);
				name_ = b;
				return b;
			} else {
				return (com.google.protobuf.ByteString) ref;
			}
		}

		/**
		 * <code>optional string name = 1;</code>
		 */
		public Builder setName(java.lang.String value) {
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
		public Builder setNameBytes(com.google.protobuf.ByteString value) {
			if (value == null) {
				throw new NullPointerException();
			}
			bitField0_ |= 0x00000001;
			name_ = value;
			onChanged();
			return this;
		}

		// repeated .google.protobuf.EnumValueDescriptorProto value = 2;
		private java.util.List<com.google.protobuf.EnumValueDescriptorProto> value_ = java.util.Collections
				.emptyList();

		private void ensureValueIsMutable() {
			if (!((bitField0_ & 0x00000002) == 0x00000002)) {
				value_ = new java.util.ArrayList<com.google.protobuf.EnumValueDescriptorProto>(
						value_);
				bitField0_ |= 0x00000002;
			}
		}

		private com.google.protobuf.RepeatedFieldBuilder<com.google.protobuf.EnumValueDescriptorProto, com.google.protobuf.EnumValueDescriptorProto.Builder, com.google.protobuf.EnumValueDescriptorProtoOrBuilder> valueBuilder_;

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public java.util.List<com.google.protobuf.EnumValueDescriptorProto> getValueList() {
			if (valueBuilder_ == null) {
				return java.util.Collections.unmodifiableList(value_);
			} else {
				return valueBuilder_.getMessageList();
			}
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public int getValueCount() {
			if (valueBuilder_ == null) {
				return value_.size();
			} else {
				return valueBuilder_.getCount();
			}
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public com.google.protobuf.EnumValueDescriptorProto getValue(int index) {
			if (valueBuilder_ == null) {
				return value_.get(index);
			} else {
				return valueBuilder_.getMessage(index);
			}
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public Builder setValue(int index,
				com.google.protobuf.EnumValueDescriptorProto value) {
			if (valueBuilder_ == null) {
				if (value == null) {
					throw new NullPointerException();
				}
				ensureValueIsMutable();
				value_.set(index, value);
				onChanged();
			} else {
				valueBuilder_.setMessage(index, value);
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public Builder setValue(
				int index,
				com.google.protobuf.EnumValueDescriptorProto.Builder builderForValue) {
			if (valueBuilder_ == null) {
				ensureValueIsMutable();
				value_.set(index, builderForValue.build());
				onChanged();
			} else {
				valueBuilder_.setMessage(index, builderForValue.build());
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public Builder addValue(
				com.google.protobuf.EnumValueDescriptorProto value) {
			if (valueBuilder_ == null) {
				if (value == null) {
					throw new NullPointerException();
				}
				ensureValueIsMutable();
				value_.add(value);
				onChanged();
			} else {
				valueBuilder_.addMessage(value);
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public Builder addValue(int index,
				com.google.protobuf.EnumValueDescriptorProto value) {
			if (valueBuilder_ == null) {
				if (value == null) {
					throw new NullPointerException();
				}
				ensureValueIsMutable();
				value_.add(index, value);
				onChanged();
			} else {
				valueBuilder_.addMessage(index, value);
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public Builder addValue(
				com.google.protobuf.EnumValueDescriptorProto.Builder builderForValue) {
			if (valueBuilder_ == null) {
				ensureValueIsMutable();
				value_.add(builderForValue.build());
				onChanged();
			} else {
				valueBuilder_.addMessage(builderForValue.build());
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public Builder addValue(
				int index,
				com.google.protobuf.EnumValueDescriptorProto.Builder builderForValue) {
			if (valueBuilder_ == null) {
				ensureValueIsMutable();
				value_.add(index, builderForValue.build());
				onChanged();
			} else {
				valueBuilder_.addMessage(index, builderForValue.build());
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public Builder addAllValue(
				java.lang.Iterable<? extends com.google.protobuf.EnumValueDescriptorProto> values) {
			if (valueBuilder_ == null) {
				ensureValueIsMutable();
				super.addAll(values, value_);
				onChanged();
			} else {
				valueBuilder_.addAllMessages(values);
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public Builder clearValue() {
			if (valueBuilder_ == null) {
				value_ = java.util.Collections.emptyList();
				bitField0_ = (bitField0_ & ~0x00000002);
				onChanged();
			} else {
				valueBuilder_.clear();
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public Builder removeValue(int index) {
			if (valueBuilder_ == null) {
				ensureValueIsMutable();
				value_.remove(index);
				onChanged();
			} else {
				valueBuilder_.remove(index);
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public com.google.protobuf.EnumValueDescriptorProto.Builder getValueBuilder(
				int index) {
			return getValueFieldBuilder().getBuilder(index);
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public com.google.protobuf.EnumValueDescriptorProtoOrBuilder getValueOrBuilder(
				int index) {
			if (valueBuilder_ == null) {
				return value_.get(index);
			} else {
				return valueBuilder_.getMessageOrBuilder(index);
			}
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public java.util.List<? extends com.google.protobuf.EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList() {
			if (valueBuilder_ != null) {
				return valueBuilder_.getMessageOrBuilderList();
			} else {
				return java.util.Collections.unmodifiableList(value_);
			}
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public com.google.protobuf.EnumValueDescriptorProto.Builder addValueBuilder() {
			return getValueFieldBuilder().addBuilder(
					com.google.protobuf.EnumValueDescriptorProto
							.getDefaultInstance());
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public com.google.protobuf.EnumValueDescriptorProto.Builder addValueBuilder(
				int index) {
			return getValueFieldBuilder().addBuilder(
					index,
					com.google.protobuf.EnumValueDescriptorProto
							.getDefaultInstance());
		}

		/**
		 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
		 */
		public java.util.List<com.google.protobuf.EnumValueDescriptorProto.Builder> getValueBuilderList() {
			return getValueFieldBuilder().getBuilderList();
		}

		private com.google.protobuf.RepeatedFieldBuilder<com.google.protobuf.EnumValueDescriptorProto, com.google.protobuf.EnumValueDescriptorProto.Builder, com.google.protobuf.EnumValueDescriptorProtoOrBuilder> getValueFieldBuilder() {
			if (valueBuilder_ == null) {
				valueBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<com.google.protobuf.EnumValueDescriptorProto, com.google.protobuf.EnumValueDescriptorProto.Builder, com.google.protobuf.EnumValueDescriptorProtoOrBuilder>(
						value_, ((bitField0_ & 0x00000002) == 0x00000002),
						getParentForChildren(), isClean());
				value_ = null;
			}
			return valueBuilder_;
		}

		// optional .google.protobuf.EnumOptions options = 3;
		private com.google.protobuf.EnumOptions options_ = com.google.protobuf.EnumOptions
				.getDefaultInstance();
		private com.google.protobuf.SingleFieldBuilder<com.google.protobuf.EnumOptions, com.google.protobuf.EnumOptions.Builder, com.google.protobuf.EnumOptionsOrBuilder> optionsBuilder_;

		/**
		 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
		 */
		public boolean hasOptions() {
			return ((bitField0_ & 0x00000004) == 0x00000004);
		}

		/**
		 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
		 */
		public com.google.protobuf.EnumOptions getOptions() {
			if (optionsBuilder_ == null) {
				return options_;
			} else {
				return optionsBuilder_.getMessage();
			}
		}

		/**
		 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
		 */
		public Builder setOptions(com.google.protobuf.EnumOptions value) {
			if (optionsBuilder_ == null) {
				if (value == null) {
					throw new NullPointerException();
				}
				options_ = value;
				onChanged();
			} else {
				optionsBuilder_.setMessage(value);
			}
			bitField0_ |= 0x00000004;
			return this;
		}

		/**
		 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
		 */
		public Builder setOptions(
				com.google.protobuf.EnumOptions.Builder builderForValue) {
			if (optionsBuilder_ == null) {
				options_ = builderForValue.build();
				onChanged();
			} else {
				optionsBuilder_.setMessage(builderForValue.build());
			}
			bitField0_ |= 0x00000004;
			return this;
		}

		/**
		 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
		 */
		public Builder mergeOptions(com.google.protobuf.EnumOptions value) {
			if (optionsBuilder_ == null) {
				if (((bitField0_ & 0x00000004) == 0x00000004)
						&& options_ != com.google.protobuf.EnumOptions
								.getDefaultInstance()) {
					options_ = com.google.protobuf.EnumOptions
							.newBuilder(options_).mergeFrom(value)
							.buildPartial();
				} else {
					options_ = value;
				}
				onChanged();
			} else {
				optionsBuilder_.mergeFrom(value);
			}
			bitField0_ |= 0x00000004;
			return this;
		}

		/**
		 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
		 */
		public Builder clearOptions() {
			if (optionsBuilder_ == null) {
				options_ = com.google.protobuf.EnumOptions.getDefaultInstance();
				onChanged();
			} else {
				optionsBuilder_.clear();
			}
			bitField0_ = (bitField0_ & ~0x00000004);
			return this;
		}

		/**
		 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
		 */
		public com.google.protobuf.EnumOptions.Builder getOptionsBuilder() {
			bitField0_ |= 0x00000004;
			onChanged();
			return getOptionsFieldBuilder().getBuilder();
		}

		/**
		 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
		 */
		public com.google.protobuf.EnumOptionsOrBuilder getOptionsOrBuilder() {
			if (optionsBuilder_ != null) {
				return optionsBuilder_.getMessageOrBuilder();
			} else {
				return options_;
			}
		}

		/**
		 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
		 */
		private com.google.protobuf.SingleFieldBuilder<com.google.protobuf.EnumOptions, com.google.protobuf.EnumOptions.Builder, com.google.protobuf.EnumOptionsOrBuilder> getOptionsFieldBuilder() {
			if (optionsBuilder_ == null) {
				optionsBuilder_ = new com.google.protobuf.SingleFieldBuilder<com.google.protobuf.EnumOptions, com.google.protobuf.EnumOptions.Builder, com.google.protobuf.EnumOptionsOrBuilder>(
						options_, getParentForChildren(), isClean());
				options_ = null;
			}
			return optionsBuilder_;
		}

		// @@protoc_insertion_point(builder_scope:google.protobuf.EnumDescriptorProto)
	}

	static {
		defaultInstance = new EnumDescriptorProto(true);
		defaultInstance.initFields();
	}

	// @@protoc_insertion_point(class_scope:google.protobuf.EnumDescriptorProto)
}
