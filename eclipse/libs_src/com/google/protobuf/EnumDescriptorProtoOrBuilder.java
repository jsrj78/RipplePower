// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: descriptor.proto

package com.google.protobuf;

public interface EnumDescriptorProtoOrBuilder extends
		com.google.protobuf.MessageOrBuilder {

	// optional string name = 1;
	/**
	 * <code>optional string name = 1;</code>
	 */
	boolean hasName();

	/**
	 * <code>optional string name = 1;</code>
	 */
	java.lang.String getName();

	/**
	 * <code>optional string name = 1;</code>
	 */
	com.google.protobuf.ByteString getNameBytes();

	// repeated .google.protobuf.EnumValueDescriptorProto value = 2;
	/**
	 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
	 */
	java.util.List<com.google.protobuf.EnumValueDescriptorProto> getValueList();

	/**
	 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
	 */
	com.google.protobuf.EnumValueDescriptorProto getValue(int index);

	/**
	 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
	 */
	int getValueCount();

	/**
	 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
	 */
	java.util.List<? extends com.google.protobuf.EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList();

	/**
	 * <code>repeated .google.protobuf.EnumValueDescriptorProto value = 2;</code>
	 */
	com.google.protobuf.EnumValueDescriptorProtoOrBuilder getValueOrBuilder(
			int index);

	// optional .google.protobuf.EnumOptions options = 3;
	/**
	 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
	 */
	boolean hasOptions();

	/**
	 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
	 */
	com.google.protobuf.EnumOptions getOptions();

	/**
	 * <code>optional .google.protobuf.EnumOptions options = 3;</code>
	 */
	com.google.protobuf.EnumOptionsOrBuilder getOptionsOrBuilder();
}
