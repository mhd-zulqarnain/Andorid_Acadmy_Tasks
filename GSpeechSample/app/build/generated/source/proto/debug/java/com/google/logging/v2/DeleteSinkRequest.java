// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/logging/v2/logging_config.proto

package com.google.logging.v2;

/**
 * <pre>
 * The parameters to `DeleteSink`.
 * </pre>
 *
 * Protobuf type {@code google.logging.v2.DeleteSinkRequest}
 */
public  final class DeleteSinkRequest extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:google.logging.v2.DeleteSinkRequest)
    DeleteSinkRequestOrBuilder {
  // Use DeleteSinkRequest.newBuilder() to construct.
  private DeleteSinkRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private DeleteSinkRequest() {
    sinkName_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private DeleteSinkRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            sinkName_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.logging.v2.LoggingConfig.internal_static_google_logging_v2_DeleteSinkRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.logging.v2.LoggingConfig.internal_static_google_logging_v2_DeleteSinkRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.logging.v2.DeleteSinkRequest.class, com.google.logging.v2.DeleteSinkRequest.Builder.class);
  }

  public static final int SINK_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object sinkName_;
  /**
   * <pre>
   * The resource name of the sink to delete.
   * Example: `"projects/my-project-id/sinks/my-sink-id"`.
   * </pre>
   *
   * <code>optional string sink_name = 1;</code>
   */
  public java.lang.String getSinkName() {
    java.lang.Object ref = sinkName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      sinkName_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * The resource name of the sink to delete.
   * Example: `"projects/my-project-id/sinks/my-sink-id"`.
   * </pre>
   *
   * <code>optional string sink_name = 1;</code>
   */
  public com.google.protobuf.ByteString
      getSinkNameBytes() {
    java.lang.Object ref = sinkName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      sinkName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getSinkNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, sinkName_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getSinkNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, sinkName_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  public static com.google.logging.v2.DeleteSinkRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.logging.v2.DeleteSinkRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.logging.v2.DeleteSinkRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.logging.v2.DeleteSinkRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.logging.v2.DeleteSinkRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.google.logging.v2.DeleteSinkRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.logging.v2.DeleteSinkRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.logging.v2.DeleteSinkRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.logging.v2.DeleteSinkRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.google.logging.v2.DeleteSinkRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.logging.v2.DeleteSinkRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * The parameters to `DeleteSink`.
   * </pre>
   *
   * Protobuf type {@code google.logging.v2.DeleteSinkRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.logging.v2.DeleteSinkRequest)
      com.google.logging.v2.DeleteSinkRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.logging.v2.LoggingConfig.internal_static_google_logging_v2_DeleteSinkRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.logging.v2.LoggingConfig.internal_static_google_logging_v2_DeleteSinkRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.logging.v2.DeleteSinkRequest.class, com.google.logging.v2.DeleteSinkRequest.Builder.class);
    }

    // Construct using com.google.logging.v2.DeleteSinkRequest.newBuilder()
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
      }
    }
    public Builder clear() {
      super.clear();
      sinkName_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.logging.v2.LoggingConfig.internal_static_google_logging_v2_DeleteSinkRequest_descriptor;
    }

    public com.google.logging.v2.DeleteSinkRequest getDefaultInstanceForType() {
      return com.google.logging.v2.DeleteSinkRequest.getDefaultInstance();
    }

    public com.google.logging.v2.DeleteSinkRequest build() {
      com.google.logging.v2.DeleteSinkRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.google.logging.v2.DeleteSinkRequest buildPartial() {
      com.google.logging.v2.DeleteSinkRequest result = new com.google.logging.v2.DeleteSinkRequest(this);
      result.sinkName_ = sinkName_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.logging.v2.DeleteSinkRequest) {
        return mergeFrom((com.google.logging.v2.DeleteSinkRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.logging.v2.DeleteSinkRequest other) {
      if (other == com.google.logging.v2.DeleteSinkRequest.getDefaultInstance()) return this;
      if (!other.getSinkName().isEmpty()) {
        sinkName_ = other.sinkName_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.google.logging.v2.DeleteSinkRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.logging.v2.DeleteSinkRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object sinkName_ = "";
    /**
     * <pre>
     * The resource name of the sink to delete.
     * Example: `"projects/my-project-id/sinks/my-sink-id"`.
     * </pre>
     *
     * <code>optional string sink_name = 1;</code>
     */
    public java.lang.String getSinkName() {
      java.lang.Object ref = sinkName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        sinkName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * The resource name of the sink to delete.
     * Example: `"projects/my-project-id/sinks/my-sink-id"`.
     * </pre>
     *
     * <code>optional string sink_name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getSinkNameBytes() {
      java.lang.Object ref = sinkName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        sinkName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * The resource name of the sink to delete.
     * Example: `"projects/my-project-id/sinks/my-sink-id"`.
     * </pre>
     *
     * <code>optional string sink_name = 1;</code>
     */
    public Builder setSinkName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      sinkName_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The resource name of the sink to delete.
     * Example: `"projects/my-project-id/sinks/my-sink-id"`.
     * </pre>
     *
     * <code>optional string sink_name = 1;</code>
     */
    public Builder clearSinkName() {
      
      sinkName_ = getDefaultInstance().getSinkName();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The resource name of the sink to delete.
     * Example: `"projects/my-project-id/sinks/my-sink-id"`.
     * </pre>
     *
     * <code>optional string sink_name = 1;</code>
     */
    public Builder setSinkNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      sinkName_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:google.logging.v2.DeleteSinkRequest)
  }

  // @@protoc_insertion_point(class_scope:google.logging.v2.DeleteSinkRequest)
  private static final com.google.logging.v2.DeleteSinkRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.logging.v2.DeleteSinkRequest();
  }

  public static com.google.logging.v2.DeleteSinkRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DeleteSinkRequest>
      PARSER = new com.google.protobuf.AbstractParser<DeleteSinkRequest>() {
    public DeleteSinkRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new DeleteSinkRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DeleteSinkRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DeleteSinkRequest> getParserForType() {
    return PARSER;
  }

  public com.google.logging.v2.DeleteSinkRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

