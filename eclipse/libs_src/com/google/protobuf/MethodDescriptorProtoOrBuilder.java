// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: descriptor.proto

package com.google.protobuf;

public interface MethodDescriptorProtoOrBuilder extends
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

	// optional string input_type = 2;
	/**
	 * <code>optional string input_type = 2;</code>
	 * 
	 * <pre>
	 * Input and output type names.  These are resolved in the same way as
	 * FieldDescriptorProto.type_name, but must refer to a message type.
	 * </pre>
	 */
	boolean hasInputType();

	/**
	 * <code>optional string input_type = 2;</code>
	 * 
	 * <pre>
	 * Input and output type names.  These are resolved in the same way as
	 * FieldDescriptorProto.type_name, but must refer to a message type.
	 * </pre>
	 */
	java.lang.String getInputType();

	/**
	 * <code>optional string input_type = 2;</code>
	 * 
	 * <pre>
	 * Input and output type names.  These are resolved in the same way as
	 * FieldDescriptorProto.type_name, but must refer to a message type.
	 * </pre>
	 */
	com.google.protobuf.ByteString getInputTypeBytes();

	// optional string output_type = 3;
	/**
	 * <code>optional string output_type = 3;</code>
	 */
	boolean hasOutputType();

	/**
	 * <code>optional string output_type = 3;</code>
	 */
	java.lang.String getOutputType();

	/**
	 * <code>optional string output_type = 3;</code>
	 */
	com.google.protobuf.ByteString getOutputTypeBytes();

	// optional .google.protobuf.MethodOptions options = 4;
	/**
	 * <code>optional .google.protobuf.MethodOptions options = 4;</code>
	 */
	boolean hasOptions();

	/**
	 * <code>optional .google.protobuf.MethodOptions options = 4;</code>
	 */
	com.google.protobuf.MethodOptions getOptions();

	/**
	 * <code>optional .google.protobuf.MethodOptions options = 4;</code>
	 */
	com.google.protobuf.MethodOptionsOrBuilder getOptionsOrBuilder();
}
