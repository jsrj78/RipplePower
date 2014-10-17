// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: descriptor.proto

package com.google.protobuf;

/**
 * Protobuf type {@code google.protobuf.MessageOptions}
 */
public final class MessageOptions extends
		com.google.protobuf.GeneratedMessage.ExtendableMessage<MessageOptions>
		implements MessageOptionsOrBuilder {
	// Use MessageOptions.newBuilder() to construct.
	private MessageOptions(
			com.google.protobuf.GeneratedMessage.ExtendableBuilder<com.google.protobuf.MessageOptions, ?> builder) {
		super(builder);
		this.unknownFields = builder.getUnknownFields();
	}

	private MessageOptions(boolean noInit) {
		this.unknownFields = com.google.protobuf.UnknownFieldSet
				.getDefaultInstance();
	}

	private static final MessageOptions defaultInstance;

	public static MessageOptions getDefaultInstance() {
		return defaultInstance;
	}

	public MessageOptions getDefaultInstanceForType() {
		return defaultInstance;
	}

	private final com.google.protobuf.UnknownFieldSet unknownFields;

	@java.lang.Override
	public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
		return this.unknownFields;
	}

	private MessageOptions(com.google.protobuf.CodedInputStream input,
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
				case 8: {
					bitField0_ |= 0x00000001;
					messageSetWireFormat_ = input.readBool();
					break;
				}
				case 16: {
					bitField0_ |= 0x00000002;
					noStandardDescriptorAccessor_ = input.readBool();
					break;
				}
				case 7994: {
					if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
						uninterpretedOption_ = new java.util.ArrayList<com.google.protobuf.UninterpretedOption>();
						mutable_bitField0_ |= 0x00000004;
					}
					uninterpretedOption_.add(input.readMessage(
							com.google.protobuf.UninterpretedOption.PARSER,
							extensionRegistry));
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
			if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
				uninterpretedOption_ = java.util.Collections
						.unmodifiableList(uninterpretedOption_);
			}
			this.unknownFields = unknownFields.build();
			makeExtensionsImmutable();
		}
	}

	public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
		return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
	}

	protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
		return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_MessageOptions_fieldAccessorTable
				.ensureFieldAccessorsInitialized(
						com.google.protobuf.MessageOptions.class,
						com.google.protobuf.MessageOptions.Builder.class);
	}

	public static com.google.protobuf.Parser<MessageOptions> PARSER = new com.google.protobuf.AbstractParser<MessageOptions>() {
		public MessageOptions parsePartialFrom(
				com.google.protobuf.CodedInputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return new MessageOptions(input, extensionRegistry);
		}
	};

	@java.lang.Override
	public com.google.protobuf.Parser<MessageOptions> getParserForType() {
		return PARSER;
	}

	private int bitField0_;
	// optional bool message_set_wire_format = 1 [default = false];
	public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
	private boolean messageSetWireFormat_;

	/**
	 * <code>optional bool message_set_wire_format = 1 [default = false];</code>
	 * 
	 * <pre>
	 * Set true to use the old proto1 MessageSet wire format for extensions.
	 * This is provided for backwards-compatibility with the MessageSet wire
	 * format.  You should not use this for any other reason:  It's less
	 * efficient, has fewer features, and is more complicated.
	 * 
	 * The message must be defined exactly as follows:
	 *   message Foo {
	 *     option message_set_wire_format = true;
	 *     extensions 4 to max;
	 *   }
	 * Note that the message cannot have any defined fields; MessageSets only
	 * have extensions.
	 * 
	 * All extensions of your type must be singular messages; e.g. they cannot
	 * be int32s, enums, or repeated messages.
	 * 
	 * Because this is an option, the above two restrictions are not enforced by
	 * the protocol compiler.
	 * </pre>
	 */
	public boolean hasMessageSetWireFormat() {
		return ((bitField0_ & 0x00000001) == 0x00000001);
	}

	/**
	 * <code>optional bool message_set_wire_format = 1 [default = false];</code>
	 * 
	 * <pre>
	 * Set true to use the old proto1 MessageSet wire format for extensions.
	 * This is provided for backwards-compatibility with the MessageSet wire
	 * format.  You should not use this for any other reason:  It's less
	 * efficient, has fewer features, and is more complicated.
	 * 
	 * The message must be defined exactly as follows:
	 *   message Foo {
	 *     option message_set_wire_format = true;
	 *     extensions 4 to max;
	 *   }
	 * Note that the message cannot have any defined fields; MessageSets only
	 * have extensions.
	 * 
	 * All extensions of your type must be singular messages; e.g. they cannot
	 * be int32s, enums, or repeated messages.
	 * 
	 * Because this is an option, the above two restrictions are not enforced by
	 * the protocol compiler.
	 * </pre>
	 */
	public boolean getMessageSetWireFormat() {
		return messageSetWireFormat_;
	}

	// optional bool no_standard_descriptor_accessor = 2 [default = false];
	public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
	private boolean noStandardDescriptorAccessor_;

	/**
	 * <code>optional bool no_standard_descriptor_accessor = 2 [default = false];</code>
	 * 
	 * <pre>
	 * Disables the generation of the standard "descriptor()" accessor, which can
	 * conflict with a field of the same name.  This is meant to make migration
	 * from proto1 easier; new code should avoid fields named "descriptor".
	 * </pre>
	 */
	public boolean hasNoStandardDescriptorAccessor() {
		return ((bitField0_ & 0x00000002) == 0x00000002);
	}

	/**
	 * <code>optional bool no_standard_descriptor_accessor = 2 [default = false];</code>
	 * 
	 * <pre>
	 * Disables the generation of the standard "descriptor()" accessor, which can
	 * conflict with a field of the same name.  This is meant to make migration
	 * from proto1 easier; new code should avoid fields named "descriptor".
	 * </pre>
	 */
	public boolean getNoStandardDescriptorAccessor() {
		return noStandardDescriptorAccessor_;
	}

	// repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;
	public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
	private java.util.List<com.google.protobuf.UninterpretedOption> uninterpretedOption_;

	/**
	 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
	 * 
	 * <pre>
	 * The parser stores options it doesn't recognize here. See above.
	 * </pre>
	 */
	public java.util.List<com.google.protobuf.UninterpretedOption> getUninterpretedOptionList() {
		return uninterpretedOption_;
	}

	/**
	 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
	 * 
	 * <pre>
	 * The parser stores options it doesn't recognize here. See above.
	 * </pre>
	 */
	public java.util.List<? extends com.google.protobuf.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
		return uninterpretedOption_;
	}

	/**
	 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
	 * 
	 * <pre>
	 * The parser stores options it doesn't recognize here. See above.
	 * </pre>
	 */
	public int getUninterpretedOptionCount() {
		return uninterpretedOption_.size();
	}

	/**
	 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
	 * 
	 * <pre>
	 * The parser stores options it doesn't recognize here. See above.
	 * </pre>
	 */
	public com.google.protobuf.UninterpretedOption getUninterpretedOption(
			int index) {
		return uninterpretedOption_.get(index);
	}

	/**
	 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
	 * 
	 * <pre>
	 * The parser stores options it doesn't recognize here. See above.
	 * </pre>
	 */
	public com.google.protobuf.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(
			int index) {
		return uninterpretedOption_.get(index);
	}

	private void initFields() {
		messageSetWireFormat_ = false;
		noStandardDescriptorAccessor_ = false;
		uninterpretedOption_ = java.util.Collections.emptyList();
	}

	private byte memoizedIsInitialized = -1;

	public final boolean isInitialized() {
		byte isInitialized = memoizedIsInitialized;
		if (isInitialized != -1)
			return isInitialized == 1;

		for (int i = 0; i < getUninterpretedOptionCount(); i++) {
			if (!getUninterpretedOption(i).isInitialized()) {
				memoizedIsInitialized = 0;
				return false;
			}
		}
		if (!extensionsAreInitialized()) {
			memoizedIsInitialized = 0;
			return false;
		}
		memoizedIsInitialized = 1;
		return true;
	}

	public void writeTo(com.google.protobuf.CodedOutputStream output)
			throws java.io.IOException {
		getSerializedSize();
		com.google.protobuf.GeneratedMessage.ExtendableMessage<com.google.protobuf.MessageOptions>.ExtensionWriter extensionWriter = newExtensionWriter();
		if (((bitField0_ & 0x00000001) == 0x00000001)) {
			output.writeBool(1, messageSetWireFormat_);
		}
		if (((bitField0_ & 0x00000002) == 0x00000002)) {
			output.writeBool(2, noStandardDescriptorAccessor_);
		}
		for (int i = 0; i < uninterpretedOption_.size(); i++) {
			output.writeMessage(999, uninterpretedOption_.get(i));
		}
		extensionWriter.writeUntil(536870912, output);
		getUnknownFields().writeTo(output);
	}

	private int memoizedSerializedSize = -1;

	public int getSerializedSize() {
		int size = memoizedSerializedSize;
		if (size != -1)
			return size;

		size = 0;
		if (((bitField0_ & 0x00000001) == 0x00000001)) {
			size += com.google.protobuf.CodedOutputStream.computeBoolSize(1,
					messageSetWireFormat_);
		}
		if (((bitField0_ & 0x00000002) == 0x00000002)) {
			size += com.google.protobuf.CodedOutputStream.computeBoolSize(2,
					noStandardDescriptorAccessor_);
		}
		for (int i = 0; i < uninterpretedOption_.size(); i++) {
			size += com.google.protobuf.CodedOutputStream.computeMessageSize(
					999, uninterpretedOption_.get(i));
		}
		size += extensionsSerializedSize();
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

	public static com.google.protobuf.MessageOptions parseFrom(
			com.google.protobuf.ByteString data)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data);
	}

	public static com.google.protobuf.MessageOptions parseFrom(
			com.google.protobuf.ByteString data,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data, extensionRegistry);
	}

	public static com.google.protobuf.MessageOptions parseFrom(byte[] data)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data);
	}

	public static com.google.protobuf.MessageOptions parseFrom(byte[] data,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws com.google.protobuf.InvalidProtocolBufferException {
		return PARSER.parseFrom(data, extensionRegistry);
	}

	public static com.google.protobuf.MessageOptions parseFrom(
			java.io.InputStream input) throws java.io.IOException {
		return PARSER.parseFrom(input);
	}

	public static com.google.protobuf.MessageOptions parseFrom(
			java.io.InputStream input,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws java.io.IOException {
		return PARSER.parseFrom(input, extensionRegistry);
	}

	public static com.google.protobuf.MessageOptions parseDelimitedFrom(
			java.io.InputStream input) throws java.io.IOException {
		return PARSER.parseDelimitedFrom(input);
	}

	public static com.google.protobuf.MessageOptions parseDelimitedFrom(
			java.io.InputStream input,
			com.google.protobuf.ExtensionRegistryLite extensionRegistry)
			throws java.io.IOException {
		return PARSER.parseDelimitedFrom(input, extensionRegistry);
	}

	public static com.google.protobuf.MessageOptions parseFrom(
			com.google.protobuf.CodedInputStream input)
			throws java.io.IOException {
		return PARSER.parseFrom(input);
	}

	public static com.google.protobuf.MessageOptions parseFrom(
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
			com.google.protobuf.MessageOptions prototype) {
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
	 * Protobuf type {@code google.protobuf.MessageOptions}
	 */
	public static final class Builder
			extends
			com.google.protobuf.GeneratedMessage.ExtendableBuilder<com.google.protobuf.MessageOptions, Builder>
			implements com.google.protobuf.MessageOptionsOrBuilder {
		public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
			return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
		}

		protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
			return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_MessageOptions_fieldAccessorTable
					.ensureFieldAccessorsInitialized(
							com.google.protobuf.MessageOptions.class,
							com.google.protobuf.MessageOptions.Builder.class);
		}

		// Construct using com.google.protobuf.MessageOptions.newBuilder()
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
				getUninterpretedOptionFieldBuilder();
			}
		}

		private static Builder create() {
			return new Builder();
		}

		public Builder clear() {
			super.clear();
			messageSetWireFormat_ = false;
			bitField0_ = (bitField0_ & ~0x00000001);
			noStandardDescriptorAccessor_ = false;
			bitField0_ = (bitField0_ & ~0x00000002);
			if (uninterpretedOptionBuilder_ == null) {
				uninterpretedOption_ = java.util.Collections.emptyList();
				bitField0_ = (bitField0_ & ~0x00000004);
			} else {
				uninterpretedOptionBuilder_.clear();
			}
			return this;
		}

		public Builder clone() {
			return create().mergeFrom(buildPartial());
		}

		public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
			return com.google.protobuf.DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
		}

		public com.google.protobuf.MessageOptions getDefaultInstanceForType() {
			return com.google.protobuf.MessageOptions.getDefaultInstance();
		}

		public com.google.protobuf.MessageOptions build() {
			com.google.protobuf.MessageOptions result = buildPartial();
			if (!result.isInitialized()) {
				throw newUninitializedMessageException(result);
			}
			return result;
		}

		public com.google.protobuf.MessageOptions buildPartial() {
			com.google.protobuf.MessageOptions result = new com.google.protobuf.MessageOptions(
					this);
			int from_bitField0_ = bitField0_;
			int to_bitField0_ = 0;
			if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
				to_bitField0_ |= 0x00000001;
			}
			result.messageSetWireFormat_ = messageSetWireFormat_;
			if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
				to_bitField0_ |= 0x00000002;
			}
			result.noStandardDescriptorAccessor_ = noStandardDescriptorAccessor_;
			if (uninterpretedOptionBuilder_ == null) {
				if (((bitField0_ & 0x00000004) == 0x00000004)) {
					uninterpretedOption_ = java.util.Collections
							.unmodifiableList(uninterpretedOption_);
					bitField0_ = (bitField0_ & ~0x00000004);
				}
				result.uninterpretedOption_ = uninterpretedOption_;
			} else {
				result.uninterpretedOption_ = uninterpretedOptionBuilder_
						.build();
			}
			result.bitField0_ = to_bitField0_;
			onBuilt();
			return result;
		}

		public Builder mergeFrom(com.google.protobuf.Message other) {
			if (other instanceof com.google.protobuf.MessageOptions) {
				return mergeFrom((com.google.protobuf.MessageOptions) other);
			} else {
				super.mergeFrom(other);
				return this;
			}
		}

		public Builder mergeFrom(com.google.protobuf.MessageOptions other) {
			if (other == com.google.protobuf.MessageOptions
					.getDefaultInstance())
				return this;
			if (other.hasMessageSetWireFormat()) {
				setMessageSetWireFormat(other.getMessageSetWireFormat());
			}
			if (other.hasNoStandardDescriptorAccessor()) {
				setNoStandardDescriptorAccessor(other
						.getNoStandardDescriptorAccessor());
			}
			if (uninterpretedOptionBuilder_ == null) {
				if (!other.uninterpretedOption_.isEmpty()) {
					if (uninterpretedOption_.isEmpty()) {
						uninterpretedOption_ = other.uninterpretedOption_;
						bitField0_ = (bitField0_ & ~0x00000004);
					} else {
						ensureUninterpretedOptionIsMutable();
						uninterpretedOption_.addAll(other.uninterpretedOption_);
					}
					onChanged();
				}
			} else {
				if (!other.uninterpretedOption_.isEmpty()) {
					if (uninterpretedOptionBuilder_.isEmpty()) {
						uninterpretedOptionBuilder_.dispose();
						uninterpretedOptionBuilder_ = null;
						uninterpretedOption_ = other.uninterpretedOption_;
						bitField0_ = (bitField0_ & ~0x00000004);
						uninterpretedOptionBuilder_ = com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder()
								: null;
					} else {
						uninterpretedOptionBuilder_
								.addAllMessages(other.uninterpretedOption_);
					}
				}
			}
			this.mergeExtensionFields(other);
			this.mergeUnknownFields(other.getUnknownFields());
			return this;
		}

		public final boolean isInitialized() {
			for (int i = 0; i < getUninterpretedOptionCount(); i++) {
				if (!getUninterpretedOption(i).isInitialized()) {

					return false;
				}
			}
			if (!extensionsAreInitialized()) {

				return false;
			}
			return true;
		}

		public Builder mergeFrom(com.google.protobuf.CodedInputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws java.io.IOException {
			com.google.protobuf.MessageOptions parsedMessage = null;
			try {
				parsedMessage = PARSER.parsePartialFrom(input,
						extensionRegistry);
			} catch (com.google.protobuf.InvalidProtocolBufferException e) {
				parsedMessage = (com.google.protobuf.MessageOptions) e
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

		// optional bool message_set_wire_format = 1 [default = false];
		private boolean messageSetWireFormat_;

		/**
		 * <code>optional bool message_set_wire_format = 1 [default = false];</code>
		 * 
		 * <pre>
		 * Set true to use the old proto1 MessageSet wire format for extensions.
		 * This is provided for backwards-compatibility with the MessageSet wire
		 * format.  You should not use this for any other reason:  It's less
		 * efficient, has fewer features, and is more complicated.
		 * 
		 * The message must be defined exactly as follows:
		 *   message Foo {
		 *     option message_set_wire_format = true;
		 *     extensions 4 to max;
		 *   }
		 * Note that the message cannot have any defined fields; MessageSets only
		 * have extensions.
		 * 
		 * All extensions of your type must be singular messages; e.g. they cannot
		 * be int32s, enums, or repeated messages.
		 * 
		 * Because this is an option, the above two restrictions are not enforced by
		 * the protocol compiler.
		 * </pre>
		 */
		public boolean hasMessageSetWireFormat() {
			return ((bitField0_ & 0x00000001) == 0x00000001);
		}

		/**
		 * <code>optional bool message_set_wire_format = 1 [default = false];</code>
		 * 
		 * <pre>
		 * Set true to use the old proto1 MessageSet wire format for extensions.
		 * This is provided for backwards-compatibility with the MessageSet wire
		 * format.  You should not use this for any other reason:  It's less
		 * efficient, has fewer features, and is more complicated.
		 * 
		 * The message must be defined exactly as follows:
		 *   message Foo {
		 *     option message_set_wire_format = true;
		 *     extensions 4 to max;
		 *   }
		 * Note that the message cannot have any defined fields; MessageSets only
		 * have extensions.
		 * 
		 * All extensions of your type must be singular messages; e.g. they cannot
		 * be int32s, enums, or repeated messages.
		 * 
		 * Because this is an option, the above two restrictions are not enforced by
		 * the protocol compiler.
		 * </pre>
		 */
		public boolean getMessageSetWireFormat() {
			return messageSetWireFormat_;
		}

		/**
		 * <code>optional bool message_set_wire_format = 1 [default = false];</code>
		 * 
		 * <pre>
		 * Set true to use the old proto1 MessageSet wire format for extensions.
		 * This is provided for backwards-compatibility with the MessageSet wire
		 * format.  You should not use this for any other reason:  It's less
		 * efficient, has fewer features, and is more complicated.
		 * 
		 * The message must be defined exactly as follows:
		 *   message Foo {
		 *     option message_set_wire_format = true;
		 *     extensions 4 to max;
		 *   }
		 * Note that the message cannot have any defined fields; MessageSets only
		 * have extensions.
		 * 
		 * All extensions of your type must be singular messages; e.g. they cannot
		 * be int32s, enums, or repeated messages.
		 * 
		 * Because this is an option, the above two restrictions are not enforced by
		 * the protocol compiler.
		 * </pre>
		 */
		public Builder setMessageSetWireFormat(boolean value) {
			bitField0_ |= 0x00000001;
			messageSetWireFormat_ = value;
			onChanged();
			return this;
		}

		/**
		 * <code>optional bool message_set_wire_format = 1 [default = false];</code>
		 * 
		 * <pre>
		 * Set true to use the old proto1 MessageSet wire format for extensions.
		 * This is provided for backwards-compatibility with the MessageSet wire
		 * format.  You should not use this for any other reason:  It's less
		 * efficient, has fewer features, and is more complicated.
		 * 
		 * The message must be defined exactly as follows:
		 *   message Foo {
		 *     option message_set_wire_format = true;
		 *     extensions 4 to max;
		 *   }
		 * Note that the message cannot have any defined fields; MessageSets only
		 * have extensions.
		 * 
		 * All extensions of your type must be singular messages; e.g. they cannot
		 * be int32s, enums, or repeated messages.
		 * 
		 * Because this is an option, the above two restrictions are not enforced by
		 * the protocol compiler.
		 * </pre>
		 */
		public Builder clearMessageSetWireFormat() {
			bitField0_ = (bitField0_ & ~0x00000001);
			messageSetWireFormat_ = false;
			onChanged();
			return this;
		}

		// optional bool no_standard_descriptor_accessor = 2 [default = false];
		private boolean noStandardDescriptorAccessor_;

		/**
		 * <code>optional bool no_standard_descriptor_accessor = 2 [default = false];</code>
		 * 
		 * <pre>
		 * Disables the generation of the standard "descriptor()" accessor, which can
		 * conflict with a field of the same name.  This is meant to make migration
		 * from proto1 easier; new code should avoid fields named "descriptor".
		 * </pre>
		 */
		public boolean hasNoStandardDescriptorAccessor() {
			return ((bitField0_ & 0x00000002) == 0x00000002);
		}

		/**
		 * <code>optional bool no_standard_descriptor_accessor = 2 [default = false];</code>
		 * 
		 * <pre>
		 * Disables the generation of the standard "descriptor()" accessor, which can
		 * conflict with a field of the same name.  This is meant to make migration
		 * from proto1 easier; new code should avoid fields named "descriptor".
		 * </pre>
		 */
		public boolean getNoStandardDescriptorAccessor() {
			return noStandardDescriptorAccessor_;
		}

		/**
		 * <code>optional bool no_standard_descriptor_accessor = 2 [default = false];</code>
		 * 
		 * <pre>
		 * Disables the generation of the standard "descriptor()" accessor, which can
		 * conflict with a field of the same name.  This is meant to make migration
		 * from proto1 easier; new code should avoid fields named "descriptor".
		 * </pre>
		 */
		public Builder setNoStandardDescriptorAccessor(boolean value) {
			bitField0_ |= 0x00000002;
			noStandardDescriptorAccessor_ = value;
			onChanged();
			return this;
		}

		/**
		 * <code>optional bool no_standard_descriptor_accessor = 2 [default = false];</code>
		 * 
		 * <pre>
		 * Disables the generation of the standard "descriptor()" accessor, which can
		 * conflict with a field of the same name.  This is meant to make migration
		 * from proto1 easier; new code should avoid fields named "descriptor".
		 * </pre>
		 */
		public Builder clearNoStandardDescriptorAccessor() {
			bitField0_ = (bitField0_ & ~0x00000002);
			noStandardDescriptorAccessor_ = false;
			onChanged();
			return this;
		}

		// repeated .google.protobuf.UninterpretedOption uninterpreted_option =
		// 999;
		private java.util.List<com.google.protobuf.UninterpretedOption> uninterpretedOption_ = java.util.Collections
				.emptyList();

		private void ensureUninterpretedOptionIsMutable() {
			if (!((bitField0_ & 0x00000004) == 0x00000004)) {
				uninterpretedOption_ = new java.util.ArrayList<com.google.protobuf.UninterpretedOption>(
						uninterpretedOption_);
				bitField0_ |= 0x00000004;
			}
		}

		private com.google.protobuf.RepeatedFieldBuilder<com.google.protobuf.UninterpretedOption, com.google.protobuf.UninterpretedOption.Builder, com.google.protobuf.UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public java.util.List<com.google.protobuf.UninterpretedOption> getUninterpretedOptionList() {
			if (uninterpretedOptionBuilder_ == null) {
				return java.util.Collections
						.unmodifiableList(uninterpretedOption_);
			} else {
				return uninterpretedOptionBuilder_.getMessageList();
			}
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public int getUninterpretedOptionCount() {
			if (uninterpretedOptionBuilder_ == null) {
				return uninterpretedOption_.size();
			} else {
				return uninterpretedOptionBuilder_.getCount();
			}
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public com.google.protobuf.UninterpretedOption getUninterpretedOption(
				int index) {
			if (uninterpretedOptionBuilder_ == null) {
				return uninterpretedOption_.get(index);
			} else {
				return uninterpretedOptionBuilder_.getMessage(index);
			}
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public Builder setUninterpretedOption(int index,
				com.google.protobuf.UninterpretedOption value) {
			if (uninterpretedOptionBuilder_ == null) {
				if (value == null) {
					throw new NullPointerException();
				}
				ensureUninterpretedOptionIsMutable();
				uninterpretedOption_.set(index, value);
				onChanged();
			} else {
				uninterpretedOptionBuilder_.setMessage(index, value);
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public Builder setUninterpretedOption(int index,
				com.google.protobuf.UninterpretedOption.Builder builderForValue) {
			if (uninterpretedOptionBuilder_ == null) {
				ensureUninterpretedOptionIsMutable();
				uninterpretedOption_.set(index, builderForValue.build());
				onChanged();
			} else {
				uninterpretedOptionBuilder_.setMessage(index,
						builderForValue.build());
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public Builder addUninterpretedOption(
				com.google.protobuf.UninterpretedOption value) {
			if (uninterpretedOptionBuilder_ == null) {
				if (value == null) {
					throw new NullPointerException();
				}
				ensureUninterpretedOptionIsMutable();
				uninterpretedOption_.add(value);
				onChanged();
			} else {
				uninterpretedOptionBuilder_.addMessage(value);
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public Builder addUninterpretedOption(int index,
				com.google.protobuf.UninterpretedOption value) {
			if (uninterpretedOptionBuilder_ == null) {
				if (value == null) {
					throw new NullPointerException();
				}
				ensureUninterpretedOptionIsMutable();
				uninterpretedOption_.add(index, value);
				onChanged();
			} else {
				uninterpretedOptionBuilder_.addMessage(index, value);
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public Builder addUninterpretedOption(
				com.google.protobuf.UninterpretedOption.Builder builderForValue) {
			if (uninterpretedOptionBuilder_ == null) {
				ensureUninterpretedOptionIsMutable();
				uninterpretedOption_.add(builderForValue.build());
				onChanged();
			} else {
				uninterpretedOptionBuilder_.addMessage(builderForValue.build());
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public Builder addUninterpretedOption(int index,
				com.google.protobuf.UninterpretedOption.Builder builderForValue) {
			if (uninterpretedOptionBuilder_ == null) {
				ensureUninterpretedOptionIsMutable();
				uninterpretedOption_.add(index, builderForValue.build());
				onChanged();
			} else {
				uninterpretedOptionBuilder_.addMessage(index,
						builderForValue.build());
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public Builder addAllUninterpretedOption(
				java.lang.Iterable<? extends com.google.protobuf.UninterpretedOption> values) {
			if (uninterpretedOptionBuilder_ == null) {
				ensureUninterpretedOptionIsMutable();
				super.addAll(values, uninterpretedOption_);
				onChanged();
			} else {
				uninterpretedOptionBuilder_.addAllMessages(values);
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public Builder clearUninterpretedOption() {
			if (uninterpretedOptionBuilder_ == null) {
				uninterpretedOption_ = java.util.Collections.emptyList();
				bitField0_ = (bitField0_ & ~0x00000004);
				onChanged();
			} else {
				uninterpretedOptionBuilder_.clear();
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public Builder removeUninterpretedOption(int index) {
			if (uninterpretedOptionBuilder_ == null) {
				ensureUninterpretedOptionIsMutable();
				uninterpretedOption_.remove(index);
				onChanged();
			} else {
				uninterpretedOptionBuilder_.remove(index);
			}
			return this;
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public com.google.protobuf.UninterpretedOption.Builder getUninterpretedOptionBuilder(
				int index) {
			return getUninterpretedOptionFieldBuilder().getBuilder(index);
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public com.google.protobuf.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(
				int index) {
			if (uninterpretedOptionBuilder_ == null) {
				return uninterpretedOption_.get(index);
			} else {
				return uninterpretedOptionBuilder_.getMessageOrBuilder(index);
			}
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public java.util.List<? extends com.google.protobuf.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
			if (uninterpretedOptionBuilder_ != null) {
				return uninterpretedOptionBuilder_.getMessageOrBuilderList();
			} else {
				return java.util.Collections
						.unmodifiableList(uninterpretedOption_);
			}
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public com.google.protobuf.UninterpretedOption.Builder addUninterpretedOptionBuilder() {
			return getUninterpretedOptionFieldBuilder().addBuilder(
					com.google.protobuf.UninterpretedOption
							.getDefaultInstance());
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public com.google.protobuf.UninterpretedOption.Builder addUninterpretedOptionBuilder(
				int index) {
			return getUninterpretedOptionFieldBuilder().addBuilder(
					index,
					com.google.protobuf.UninterpretedOption
							.getDefaultInstance());
		}

		/**
		 * <code>repeated .google.protobuf.UninterpretedOption uninterpreted_option = 999;</code>
		 * 
		 * <pre>
		 * The parser stores options it doesn't recognize here. See above.
		 * </pre>
		 */
		public java.util.List<com.google.protobuf.UninterpretedOption.Builder> getUninterpretedOptionBuilderList() {
			return getUninterpretedOptionFieldBuilder().getBuilderList();
		}

		private com.google.protobuf.RepeatedFieldBuilder<com.google.protobuf.UninterpretedOption, com.google.protobuf.UninterpretedOption.Builder, com.google.protobuf.UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
			if (uninterpretedOptionBuilder_ == null) {
				uninterpretedOptionBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<com.google.protobuf.UninterpretedOption, com.google.protobuf.UninterpretedOption.Builder, com.google.protobuf.UninterpretedOptionOrBuilder>(
						uninterpretedOption_,
						((bitField0_ & 0x00000004) == 0x00000004),
						getParentForChildren(), isClean());
				uninterpretedOption_ = null;
			}
			return uninterpretedOptionBuilder_;
		}

		// @@protoc_insertion_point(builder_scope:google.protobuf.MessageOptions)
	}

	static {
		defaultInstance = new MessageOptions(true);
		defaultInstance.initFields();
	}

	// @@protoc_insertion_point(class_scope:google.protobuf.MessageOptions)
}
