// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/speech/v1beta1/cloud_speech.proto

package com.google.cloud.speech.v1beta1;

/**
 * <pre>
 * `SyncRecognizeRequest` is the top-level message sent by the client for
 * the `SyncRecognize` method.
 * </pre>
 *
 * Protobuf type {@code google.cloud.speech.v1beta1.SyncRecognizeRequest}
 */
public  final class SyncRecognizeRequest extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:google.cloud.speech.v1beta1.SyncRecognizeRequest)
    SyncRecognizeRequestOrBuilder {
  // Use SyncRecognizeRequest.newBuilder() to construct.
  private SyncRecognizeRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private SyncRecognizeRequest() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private SyncRecognizeRequest(
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
            com.google.cloud.speech.v1beta1.RecognitionConfig.Builder subBuilder = null;
            if (config_ != null) {
              subBuilder = config_.toBuilder();
            }
            config_ = input.readMessage(com.google.cloud.speech.v1beta1.RecognitionConfig.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(config_);
              config_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            com.google.cloud.speech.v1beta1.RecognitionAudio.Builder subBuilder = null;
            if (audio_ != null) {
              subBuilder = audio_.toBuilder();
            }
            audio_ = input.readMessage(com.google.cloud.speech.v1beta1.RecognitionAudio.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(audio_);
              audio_ = subBuilder.buildPartial();
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
    return com.google.cloud.speech.v1beta1.SpeechProto.internal_static_google_cloud_speech_v1beta1_SyncRecognizeRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.cloud.speech.v1beta1.SpeechProto.internal_static_google_cloud_speech_v1beta1_SyncRecognizeRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.cloud.speech.v1beta1.SyncRecognizeRequest.class, com.google.cloud.speech.v1beta1.SyncRecognizeRequest.Builder.class);
  }

  public static final int CONFIG_FIELD_NUMBER = 1;
  private com.google.cloud.speech.v1beta1.RecognitionConfig config_;
  /**
   * <pre>
   * [Required] The `config` message provides information to the recognizer
   * that specifies how to process the request.
   * </pre>
   *
   * <code>optional .google.cloud.speech.v1beta1.RecognitionConfig config = 1;</code>
   */
  public boolean hasConfig() {
    return config_ != null;
  }
  /**
   * <pre>
   * [Required] The `config` message provides information to the recognizer
   * that specifies how to process the request.
   * </pre>
   *
   * <code>optional .google.cloud.speech.v1beta1.RecognitionConfig config = 1;</code>
   */
  public com.google.cloud.speech.v1beta1.RecognitionConfig getConfig() {
    return config_ == null ? com.google.cloud.speech.v1beta1.RecognitionConfig.getDefaultInstance() : config_;
  }
  /**
   * <pre>
   * [Required] The `config` message provides information to the recognizer
   * that specifies how to process the request.
   * </pre>
   *
   * <code>optional .google.cloud.speech.v1beta1.RecognitionConfig config = 1;</code>
   */
  public com.google.cloud.speech.v1beta1.RecognitionConfigOrBuilder getConfigOrBuilder() {
    return getConfig();
  }

  public static final int AUDIO_FIELD_NUMBER = 2;
  private com.google.cloud.speech.v1beta1.RecognitionAudio audio_;
  /**
   * <pre>
   * [Required] The audio data to be recognized.
   * </pre>
   *
   * <code>optional .google.cloud.speech.v1beta1.RecognitionAudio audio = 2;</code>
   */
  public boolean hasAudio() {
    return audio_ != null;
  }
  /**
   * <pre>
   * [Required] The audio data to be recognized.
   * </pre>
   *
   * <code>optional .google.cloud.speech.v1beta1.RecognitionAudio audio = 2;</code>
   */
  public com.google.cloud.speech.v1beta1.RecognitionAudio getAudio() {
    return audio_ == null ? com.google.cloud.speech.v1beta1.RecognitionAudio.getDefaultInstance() : audio_;
  }
  /**
   * <pre>
   * [Required] The audio data to be recognized.
   * </pre>
   *
   * <code>optional .google.cloud.speech.v1beta1.RecognitionAudio audio = 2;</code>
   */
  public com.google.cloud.speech.v1beta1.RecognitionAudioOrBuilder getAudioOrBuilder() {
    return getAudio();
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
    if (config_ != null) {
      output.writeMessage(1, getConfig());
    }
    if (audio_ != null) {
      output.writeMessage(2, getAudio());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (config_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getConfig());
    }
    if (audio_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getAudio());
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  public static com.google.cloud.speech.v1beta1.SyncRecognizeRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.cloud.speech.v1beta1.SyncRecognizeRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.cloud.speech.v1beta1.SyncRecognizeRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.cloud.speech.v1beta1.SyncRecognizeRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.cloud.speech.v1beta1.SyncRecognizeRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.google.cloud.speech.v1beta1.SyncRecognizeRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.cloud.speech.v1beta1.SyncRecognizeRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.cloud.speech.v1beta1.SyncRecognizeRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.cloud.speech.v1beta1.SyncRecognizeRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.google.cloud.speech.v1beta1.SyncRecognizeRequest parseFrom(
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
  public static Builder newBuilder(com.google.cloud.speech.v1beta1.SyncRecognizeRequest prototype) {
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
   * `SyncRecognizeRequest` is the top-level message sent by the client for
   * the `SyncRecognize` method.
   * </pre>
   *
   * Protobuf type {@code google.cloud.speech.v1beta1.SyncRecognizeRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.cloud.speech.v1beta1.SyncRecognizeRequest)
      com.google.cloud.speech.v1beta1.SyncRecognizeRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.cloud.speech.v1beta1.SpeechProto.internal_static_google_cloud_speech_v1beta1_SyncRecognizeRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.cloud.speech.v1beta1.SpeechProto.internal_static_google_cloud_speech_v1beta1_SyncRecognizeRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.cloud.speech.v1beta1.SyncRecognizeRequest.class, com.google.cloud.speech.v1beta1.SyncRecognizeRequest.Builder.class);
    }

    // Construct using com.google.cloud.speech.v1beta1.SyncRecognizeRequest.newBuilder()
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
      if (configBuilder_ == null) {
        config_ = null;
      } else {
        config_ = null;
        configBuilder_ = null;
      }
      if (audioBuilder_ == null) {
        audio_ = null;
      } else {
        audio_ = null;
        audioBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.cloud.speech.v1beta1.SpeechProto.internal_static_google_cloud_speech_v1beta1_SyncRecognizeRequest_descriptor;
    }

    public com.google.cloud.speech.v1beta1.SyncRecognizeRequest getDefaultInstanceForType() {
      return com.google.cloud.speech.v1beta1.SyncRecognizeRequest.getDefaultInstance();
    }

    public com.google.cloud.speech.v1beta1.SyncRecognizeRequest build() {
      com.google.cloud.speech.v1beta1.SyncRecognizeRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.google.cloud.speech.v1beta1.SyncRecognizeRequest buildPartial() {
      com.google.cloud.speech.v1beta1.SyncRecognizeRequest result = new com.google.cloud.speech.v1beta1.SyncRecognizeRequest(this);
      if (configBuilder_ == null) {
        result.config_ = config_;
      } else {
        result.config_ = configBuilder_.build();
      }
      if (audioBuilder_ == null) {
        result.audio_ = audio_;
      } else {
        result.audio_ = audioBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.cloud.speech.v1beta1.SyncRecognizeRequest) {
        return mergeFrom((com.google.cloud.speech.v1beta1.SyncRecognizeRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.cloud.speech.v1beta1.SyncRecognizeRequest other) {
      if (other == com.google.cloud.speech.v1beta1.SyncRecognizeRequest.getDefaultInstance()) return this;
      if (other.hasConfig()) {
        mergeConfig(other.getConfig());
      }
      if (other.hasAudio()) {
        mergeAudio(other.getAudio());
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
      com.google.cloud.speech.v1beta1.SyncRecognizeRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.cloud.speech.v1beta1.SyncRecognizeRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.cloud.speech.v1beta1.RecognitionConfig config_ = null;
    private com.google.protobuf.SingleFieldBuilder<
        com.google.cloud.speech.v1beta1.RecognitionConfig, com.google.cloud.speech.v1beta1.RecognitionConfig.Builder, com.google.cloud.speech.v1beta1.RecognitionConfigOrBuilder> configBuilder_;
    /**
     * <pre>
     * [Required] The `config` message provides information to the recognizer
     * that specifies how to process the request.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionConfig config = 1;</code>
     */
    public boolean hasConfig() {
      return configBuilder_ != null || config_ != null;
    }
    /**
     * <pre>
     * [Required] The `config` message provides information to the recognizer
     * that specifies how to process the request.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionConfig config = 1;</code>
     */
    public com.google.cloud.speech.v1beta1.RecognitionConfig getConfig() {
      if (configBuilder_ == null) {
        return config_ == null ? com.google.cloud.speech.v1beta1.RecognitionConfig.getDefaultInstance() : config_;
      } else {
        return configBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * [Required] The `config` message provides information to the recognizer
     * that specifies how to process the request.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionConfig config = 1;</code>
     */
    public Builder setConfig(com.google.cloud.speech.v1beta1.RecognitionConfig value) {
      if (configBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        config_ = value;
        onChanged();
      } else {
        configBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * [Required] The `config` message provides information to the recognizer
     * that specifies how to process the request.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionConfig config = 1;</code>
     */
    public Builder setConfig(
        com.google.cloud.speech.v1beta1.RecognitionConfig.Builder builderForValue) {
      if (configBuilder_ == null) {
        config_ = builderForValue.build();
        onChanged();
      } else {
        configBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * [Required] The `config` message provides information to the recognizer
     * that specifies how to process the request.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionConfig config = 1;</code>
     */
    public Builder mergeConfig(com.google.cloud.speech.v1beta1.RecognitionConfig value) {
      if (configBuilder_ == null) {
        if (config_ != null) {
          config_ =
            com.google.cloud.speech.v1beta1.RecognitionConfig.newBuilder(config_).mergeFrom(value).buildPartial();
        } else {
          config_ = value;
        }
        onChanged();
      } else {
        configBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * [Required] The `config` message provides information to the recognizer
     * that specifies how to process the request.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionConfig config = 1;</code>
     */
    public Builder clearConfig() {
      if (configBuilder_ == null) {
        config_ = null;
        onChanged();
      } else {
        config_ = null;
        configBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * [Required] The `config` message provides information to the recognizer
     * that specifies how to process the request.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionConfig config = 1;</code>
     */
    public com.google.cloud.speech.v1beta1.RecognitionConfig.Builder getConfigBuilder() {
      
      onChanged();
      return getConfigFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * [Required] The `config` message provides information to the recognizer
     * that specifies how to process the request.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionConfig config = 1;</code>
     */
    public com.google.cloud.speech.v1beta1.RecognitionConfigOrBuilder getConfigOrBuilder() {
      if (configBuilder_ != null) {
        return configBuilder_.getMessageOrBuilder();
      } else {
        return config_ == null ?
            com.google.cloud.speech.v1beta1.RecognitionConfig.getDefaultInstance() : config_;
      }
    }
    /**
     * <pre>
     * [Required] The `config` message provides information to the recognizer
     * that specifies how to process the request.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionConfig config = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        com.google.cloud.speech.v1beta1.RecognitionConfig, com.google.cloud.speech.v1beta1.RecognitionConfig.Builder, com.google.cloud.speech.v1beta1.RecognitionConfigOrBuilder> 
        getConfigFieldBuilder() {
      if (configBuilder_ == null) {
        configBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            com.google.cloud.speech.v1beta1.RecognitionConfig, com.google.cloud.speech.v1beta1.RecognitionConfig.Builder, com.google.cloud.speech.v1beta1.RecognitionConfigOrBuilder>(
                getConfig(),
                getParentForChildren(),
                isClean());
        config_ = null;
      }
      return configBuilder_;
    }

    private com.google.cloud.speech.v1beta1.RecognitionAudio audio_ = null;
    private com.google.protobuf.SingleFieldBuilder<
        com.google.cloud.speech.v1beta1.RecognitionAudio, com.google.cloud.speech.v1beta1.RecognitionAudio.Builder, com.google.cloud.speech.v1beta1.RecognitionAudioOrBuilder> audioBuilder_;
    /**
     * <pre>
     * [Required] The audio data to be recognized.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionAudio audio = 2;</code>
     */
    public boolean hasAudio() {
      return audioBuilder_ != null || audio_ != null;
    }
    /**
     * <pre>
     * [Required] The audio data to be recognized.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionAudio audio = 2;</code>
     */
    public com.google.cloud.speech.v1beta1.RecognitionAudio getAudio() {
      if (audioBuilder_ == null) {
        return audio_ == null ? com.google.cloud.speech.v1beta1.RecognitionAudio.getDefaultInstance() : audio_;
      } else {
        return audioBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * [Required] The audio data to be recognized.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionAudio audio = 2;</code>
     */
    public Builder setAudio(com.google.cloud.speech.v1beta1.RecognitionAudio value) {
      if (audioBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        audio_ = value;
        onChanged();
      } else {
        audioBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * [Required] The audio data to be recognized.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionAudio audio = 2;</code>
     */
    public Builder setAudio(
        com.google.cloud.speech.v1beta1.RecognitionAudio.Builder builderForValue) {
      if (audioBuilder_ == null) {
        audio_ = builderForValue.build();
        onChanged();
      } else {
        audioBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * [Required] The audio data to be recognized.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionAudio audio = 2;</code>
     */
    public Builder mergeAudio(com.google.cloud.speech.v1beta1.RecognitionAudio value) {
      if (audioBuilder_ == null) {
        if (audio_ != null) {
          audio_ =
            com.google.cloud.speech.v1beta1.RecognitionAudio.newBuilder(audio_).mergeFrom(value).buildPartial();
        } else {
          audio_ = value;
        }
        onChanged();
      } else {
        audioBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * [Required] The audio data to be recognized.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionAudio audio = 2;</code>
     */
    public Builder clearAudio() {
      if (audioBuilder_ == null) {
        audio_ = null;
        onChanged();
      } else {
        audio_ = null;
        audioBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * [Required] The audio data to be recognized.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionAudio audio = 2;</code>
     */
    public com.google.cloud.speech.v1beta1.RecognitionAudio.Builder getAudioBuilder() {
      
      onChanged();
      return getAudioFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * [Required] The audio data to be recognized.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionAudio audio = 2;</code>
     */
    public com.google.cloud.speech.v1beta1.RecognitionAudioOrBuilder getAudioOrBuilder() {
      if (audioBuilder_ != null) {
        return audioBuilder_.getMessageOrBuilder();
      } else {
        return audio_ == null ?
            com.google.cloud.speech.v1beta1.RecognitionAudio.getDefaultInstance() : audio_;
      }
    }
    /**
     * <pre>
     * [Required] The audio data to be recognized.
     * </pre>
     *
     * <code>optional .google.cloud.speech.v1beta1.RecognitionAudio audio = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        com.google.cloud.speech.v1beta1.RecognitionAudio, com.google.cloud.speech.v1beta1.RecognitionAudio.Builder, com.google.cloud.speech.v1beta1.RecognitionAudioOrBuilder> 
        getAudioFieldBuilder() {
      if (audioBuilder_ == null) {
        audioBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            com.google.cloud.speech.v1beta1.RecognitionAudio, com.google.cloud.speech.v1beta1.RecognitionAudio.Builder, com.google.cloud.speech.v1beta1.RecognitionAudioOrBuilder>(
                getAudio(),
                getParentForChildren(),
                isClean());
        audio_ = null;
      }
      return audioBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:google.cloud.speech.v1beta1.SyncRecognizeRequest)
  }

  // @@protoc_insertion_point(class_scope:google.cloud.speech.v1beta1.SyncRecognizeRequest)
  private static final com.google.cloud.speech.v1beta1.SyncRecognizeRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.cloud.speech.v1beta1.SyncRecognizeRequest();
  }

  public static com.google.cloud.speech.v1beta1.SyncRecognizeRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SyncRecognizeRequest>
      PARSER = new com.google.protobuf.AbstractParser<SyncRecognizeRequest>() {
    public SyncRecognizeRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new SyncRecognizeRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SyncRecognizeRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SyncRecognizeRequest> getParserForType() {
    return PARSER;
  }

  public com.google.cloud.speech.v1beta1.SyncRecognizeRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

