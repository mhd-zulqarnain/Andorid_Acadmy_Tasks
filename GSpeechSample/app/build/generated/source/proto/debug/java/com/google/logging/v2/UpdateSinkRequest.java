// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/logging/v2/logging_config.proto

package com.google.logging.v2;

/**
 * <pre>
 * The parameters to `UpdateSink`.
 * </pre>
 *
 * Protobuf type {@code google.logging.v2.UpdateSinkRequest}
 */
public  final class UpdateSinkRequest extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:google.logging.v2.UpdateSinkRequest)
    UpdateSinkRequestOrBuilder {
  // Use UpdateSinkRequest.newBuilder() to construct.
  private UpdateSinkRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private UpdateSinkRequest() {
    sinkName_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private UpdateSinkRequest(
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
          case 18: {
            com.google.logging.v2.LogSink.Builder subBuilder = null;
            if (sink_ != null) {
              subBuilder = sink_.toBuilder();
            }
            sink_ = input.readMessage(com.google.logging.v2.LogSink.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(sink_);
              sink_ = subBuilder.buildPartial();
            }

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
    return com.google.logging.v2.LoggingConfig.internal_static_google_logging_v2_UpdateSinkRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.logging.v2.LoggingConfig.internal_static_google_logging_v2_UpdateSinkRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.logging.v2.UpdateSinkRequest.class, com.google.logging.v2.UpdateSinkRequest.Builder.class);
  }

  public static final int SINK_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object sinkName_;
  /**
   * <pre>
   * The resource name of the sink to update.
   * Example: `"projects/my-project-id/sinks/my-sink-id"`.
   * The updated sink must be provided in the request and have the
   * same name that is specified in `sinkName`.  If the sink does not
   * exist, it is created.
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
   * The resource name of the sink to update.
   * Example: `"projects/my-project-id/sinks/my-sink-id"`.
   * The updated sink must be provided in the request and have the
   * same name that is specified in `sinkName`.  If the sink does not
   * exist, it is created.
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

  public static final int SINK_FIELD_NUMBER = 2;
  private com.google.logging.v2.LogSink sink_;
  /**
   * <pre>
   * The updated sink, whose name must be the same as the sink
   * identifier in `sinkName`.  If `sinkName` does not exist, then
   * this method creates a new sink.
   * </pre>
   *
   * <code>optional .google.logging.v2.LogSink sink = 2;</code>
   */
  public boolean hasSink() {
    return sink_ != null;
  }
  /**
   * <pre>
   * The updated sink, whose name must be the same as the sink
   * identifier in `sinkName`.  If `sinkName` does not exist, then
   * this method creates a new sink.
   * </pre>
   *
   * <code>optional .google.logging.v2.LogSink sink = 2;</code>
   */
  public com.google.logging.v2.LogSink getSink() {
    return sink_ == null ? com.google.logging.v2.LogSink.getDefaultInstance() : sink_;
  }
  /**
   * <pre>
   * The updated sink, whose name must be the same as the sink
   * identifier in `sinkName`.  If `sinkName` does not exist, then
   * this method creates a new sink.
   * </pre>
   *
   * <code>optional .google.logging.v2.LogSink sink = 2;</code>
   */
  public com.google.logging.v2.LogSinkOrBuilder getSinkOrBuilder() {
    return getSink();
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
    if (sink_ != null) {
      output.writeMessage(2, getSink());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getSinkNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, sinkName_);
    }
    if (sink_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getSink());
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  public static com.google.logging.v2.UpdateSinkRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.logging.v2.UpdateSinkRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.logging.v2.UpdateSinkRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.logging.v2.UpdateSinkRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.logging.v2.UpdateSinkRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.google.logging.v2.UpdateSinkRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.logging.v2.UpdateSinkRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.logging.v2.UpdateSinkRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.logging.v2.UpdateSinkRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.google.logging.v2.UpdateSinkRequest parseFrom(
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
  public static Builder newBuilder(com.google.logging.v2.UpdateSinkRequest prototype) {
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
   * The parameters to `UpdateSink`.
   * </pre>
   *
   * Protobuf type {@code google.logging.v2.UpdateSinkRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.logging.v2.UpdateSinkRequest)
      com.google.logging.v2.UpdateSinkRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.logging.v2.LoggingConfig.internal_static_google_logging_v2_UpdateSinkRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.logging.v2.LoggingConfig.internal_static_google_logging_v2_UpdateSinkRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.logging.v2.UpdateSinkRequest.class, com.google.logging.v2.UpdateSinkRequest.Builder.class);
    }

    // Construct using com.google.logging.v2.UpdateSinkRequest.newBuilder()
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

      if (sinkBuilder_ == null) {
        sink_ = null;
      } else {
        sink_ = null;
        sinkBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.logging.v2.LoggingConfig.internal_static_google_logging_v2_UpdateSinkRequest_descriptor;
    }

    public com.google.logging.v2.UpdateSinkRequest getDefaultInstanceForType() {
      return com.google.logging.v2.UpdateSinkRequest.getDefaultInstance();
    }

    public com.google.logging.v2.UpdateSinkRequest build() {
      com.google.logging.v2.UpdateSinkRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.google.logging.v2.UpdateSinkRequest buildPartial() {
      com.google.logging.v2.UpdateSinkRequest result = new com.google.logging.v2.UpdateSinkRequest(this);
      result.sinkName_ = sinkName_;
      if (sinkBuilder_ == null) {
        result.sink_ = sink_;
      } else {
        result.sink_ = sinkBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.logging.v2.UpdateSinkRequest) {
        return mergeFrom((com.google.logging.v2.UpdateSinkRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.logging.v2.UpdateSinkRequest other) {
      if (other == com.google.logging.v2.UpdateSinkRequest.getDefaultInstance()) return this;
      if (!other.getSinkName().isEmpty()) {
        sinkName_ = other.sinkName_;
        onChanged();
      }
      if (other.hasSink()) {
        mergeSink(other.getSink());
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
      com.google.logging.v2.UpdateSinkRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.logging.v2.UpdateSinkRequest) e.getUnfinishedMessage();
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
     * The resource name of the sink to update.
     * Example: `"projects/my-project-id/sinks/my-sink-id"`.
     * The updated sink must be provided in the request and have the
     * same name that is specified in `sinkName`.  If the sink does not
     * exist, it is created.
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
     * The resource name of the sink to update.
     * Example: `"projects/my-project-id/sinks/my-sink-id"`.
     * The updated sink must be provided in the request and have the
     * same name that is specified in `sinkName`.  If the sink does not
     * exist, it is created.
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
     * The resource name of the sink to update.
     * Example: `"projects/my-project-id/sinks/my-sink-id"`.
     * The updated sink must be provided in the request and have the
     * same name that is specified in `sinkName`.  If the sink does not
     * exist, it is created.
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
     * The resource name of the sink to update.
     * Example: `"projects/my-project-id/sinks/my-sink-id"`.
     * The updated sink must be provided in the request and have the
     * same name that is specified in `sinkName`.  If the sink does not
     * exist, it is created.
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
     * The resource name of the sink to update.
     * Example: `"projects/my-project-id/sinks/my-sink-id"`.
     * The updated sink must be provided in the request and have the
     * same name that is specified in `sinkName`.  If the sink does not
     * exist, it is created.
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

    private com.google.logging.v2.LogSink sink_ = null;
    private com.google.protobuf.SingleFieldBuilder<
        com.google.logging.v2.LogSink, com.google.logging.v2.LogSink.Builder, com.google.logging.v2.LogSinkOrBuilder> sinkBuilder_;
    /**
     * <pre>
     * The updated sink, whose name must be the same as the sink
     * identifier in `sinkName`.  If `sinkName` does not exist, then
     * this method creates a new sink.
     * </pre>
     *
     * <code>optional .google.logging.v2.LogSink sink = 2;</code>
     */
    public boolean hasSink() {
      return sinkBuilder_ != null || sink_ != null;
    }
    /**
     * <pre>
     * The updated sink, whose name must be the same as the sink
     * identifier in `sinkName`.  If `sinkName` does not exist, then
     * this method creates a new sink.
     * </pre>
     *
     * <code>optional .google.logging.v2.LogSink sink = 2;</code>
     */
    public com.google.logging.v2.LogSink getSink() {
      if (sinkBuilder_ == null) {
        return sink_ == null ? com.google.logging.v2.LogSink.getDefaultInstance() : sink_;
      } else {
        return sinkBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * The updated sink, whose name must be the same as the sink
     * identifier in `sinkName`.  If `sinkName` does not exist, then
     * this method creates a new sink.
     * </pre>
     *
     * <code>optional .google.logging.v2.LogSink sink = 2;</code>
     */
    public Builder setSink(com.google.logging.v2.LogSink value) {
      if (sinkBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        sink_ = value;
        onChanged();
      } else {
        sinkBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * The updated sink, whose name must be the same as the sink
     * identifier in `sinkName`.  If `sinkName` does not exist, then
     * this method creates a new sink.
     * </pre>
     *
     * <code>optional .google.logging.v2.LogSink sink = 2;</code>
     */
    public Builder setSink(
        com.google.logging.v2.LogSink.Builder builderForValue) {
      if (sinkBuilder_ == null) {
        sink_ = builderForValue.build();
        onChanged();
      } else {
        sinkBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * The updated sink, whose name must be the same as the sink
     * identifier in `sinkName`.  If `sinkName` does not exist, then
     * this method creates a new sink.
     * </pre>
     *
     * <code>optional .google.logging.v2.LogSink sink = 2;</code>
     */
    public Builder mergeSink(com.google.logging.v2.LogSink value) {
      if (sinkBuilder_ == null) {
        if (sink_ != null) {
          sink_ =
            com.google.logging.v2.LogSink.newBuilder(sink_).mergeFrom(value).buildPartial();
        } else {
          sink_ = value;
        }
        onChanged();
      } else {
        sinkBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * The updated sink, whose name must be the same as the sink
     * identifier in `sinkName`.  If `sinkName` does not exist, then
     * this method creates a new sink.
     * </pre>
     *
     * <code>optional .google.logging.v2.LogSink sink = 2;</code>
     */
    public Builder clearSink() {
      if (sinkBuilder_ == null) {
        sink_ = null;
        onChanged();
      } else {
        sink_ = null;
        sinkBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * The updated sink, whose name must be the same as the sink
     * identifier in `sinkName`.  If `sinkName` does not exist, then
     * this method creates a new sink.
     * </pre>
     *
     * <code>optional .google.logging.v2.LogSink sink = 2;</code>
     */
    public com.google.logging.v2.LogSink.Builder getSinkBuilder() {
      
      onChanged();
      return getSinkFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * The updated sink, whose name must be the same as the sink
     * identifier in `sinkName`.  If `sinkName` does not exist, then
     * this method creates a new sink.
     * </pre>
     *
     * <code>optional .google.logging.v2.LogSink sink = 2;</code>
     */
    public com.google.logging.v2.LogSinkOrBuilder getSinkOrBuilder() {
      if (sinkBuilder_ != null) {
        return sinkBuilder_.getMessageOrBuilder();
      } else {
        return sink_ == null ?
            com.google.logging.v2.LogSink.getDefaultInstance() : sink_;
      }
    }
    /**
     * <pre>
     * The updated sink, whose name must be the same as the sink
     * identifier in `sinkName`.  If `sinkName` does not exist, then
     * this method creates a new sink.
     * </pre>
     *
     * <code>optional .google.logging.v2.LogSink sink = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        com.google.logging.v2.LogSink, com.google.logging.v2.LogSink.Builder, com.google.logging.v2.LogSinkOrBuilder> 
        getSinkFieldBuilder() {
      if (sinkBuilder_ == null) {
        sinkBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            com.google.logging.v2.LogSink, com.google.logging.v2.LogSink.Builder, com.google.logging.v2.LogSinkOrBuilder>(
                getSink(),
                getParentForChildren(),
                isClean());
        sink_ = null;
      }
      return sinkBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:google.logging.v2.UpdateSinkRequest)
  }

  // @@protoc_insertion_point(class_scope:google.logging.v2.UpdateSinkRequest)
  private static final com.google.logging.v2.UpdateSinkRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.logging.v2.UpdateSinkRequest();
  }

  public static com.google.logging.v2.UpdateSinkRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateSinkRequest>
      PARSER = new com.google.protobuf.AbstractParser<UpdateSinkRequest>() {
    public UpdateSinkRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new UpdateSinkRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateSinkRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateSinkRequest> getParserForType() {
    return PARSER;
  }

  public com.google.logging.v2.UpdateSinkRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

