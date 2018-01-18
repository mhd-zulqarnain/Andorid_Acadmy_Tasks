package com.google.cloud.speech.v1beta1;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * Service that implements Google Cloud Speech API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 0.15.0)",
    comments = "Source: google/speech/v1beta1/cloud_speech.proto")
public class SpeechGrpc {

  private SpeechGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.speech.v1beta1.Speech";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.cloud.speech.v1beta1.SyncRecognizeRequest,
      com.google.cloud.speech.v1beta1.SyncRecognizeResponse> METHOD_SYNC_RECOGNIZE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.cloud.speech.v1beta1.Speech", "SyncRecognize"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.cloud.speech.v1beta1.SyncRecognizeRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.cloud.speech.v1beta1.SyncRecognizeResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.cloud.speech.v1beta1.AsyncRecognizeRequest,
      com.google.longrunning.Operation> METHOD_ASYNC_RECOGNIZE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.cloud.speech.v1beta1.Speech", "AsyncRecognize"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.cloud.speech.v1beta1.AsyncRecognizeRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.longrunning.Operation.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.cloud.speech.v1beta1.StreamingRecognizeRequest,
      com.google.cloud.speech.v1beta1.StreamingRecognizeResponse> METHOD_STREAMING_RECOGNIZE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "google.cloud.speech.v1beta1.Speech", "StreamingRecognize"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.cloud.speech.v1beta1.StreamingRecognizeRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.cloud.speech.v1beta1.StreamingRecognizeResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SpeechStub newStub(io.grpc.Channel channel) {
    return new SpeechStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SpeechBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SpeechBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static SpeechFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SpeechFutureStub(channel);
  }

  /**
   * <pre>
   * Service that implements Google Cloud Speech API.
   * </pre>
   */
  @java.lang.Deprecated public static interface Speech {

    /**
     * <pre>
     * Perform synchronous speech-recognition: receive results after all audio
     * has been sent and processed.
     * </pre>
     */
    public void syncRecognize(com.google.cloud.speech.v1beta1.SyncRecognizeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.SyncRecognizeResponse> responseObserver);

    /**
     * <pre>
     * Perform asynchronous speech-recognition: receive results via the
     * google.longrunning.Operations interface. `Operation.response` returns
     * `AsyncRecognizeResponse`.
     * </pre>
     */
    public void asyncRecognize(com.google.cloud.speech.v1beta1.AsyncRecognizeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver);

    /**
     * <pre>
     * Perform bidirectional streaming speech-recognition: receive results while
     * sending audio. This method is only available via the gRPC API (not REST).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.StreamingRecognizeRequest> streamingRecognize(
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.StreamingRecognizeResponse> responseObserver);
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1469")
  public static abstract class SpeechImplBase implements Speech, io.grpc.BindableService {

    @java.lang.Override
    public void syncRecognize(com.google.cloud.speech.v1beta1.SyncRecognizeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.SyncRecognizeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SYNC_RECOGNIZE, responseObserver);
    }

    @java.lang.Override
    public void asyncRecognize(com.google.cloud.speech.v1beta1.AsyncRecognizeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ASYNC_RECOGNIZE, responseObserver);
    }

    @java.lang.Override
    public io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.StreamingRecognizeRequest> streamingRecognize(
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.StreamingRecognizeResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_STREAMING_RECOGNIZE, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return SpeechGrpc.bindService(this);
    }
  }

  /**
   * <pre>
   * Service that implements Google Cloud Speech API.
   * </pre>
   */
  @java.lang.Deprecated public static interface SpeechBlockingClient {

    /**
     * <pre>
     * Perform synchronous speech-recognition: receive results after all audio
     * has been sent and processed.
     * </pre>
     */
    public com.google.cloud.speech.v1beta1.SyncRecognizeResponse syncRecognize(com.google.cloud.speech.v1beta1.SyncRecognizeRequest request);

    /**
     * <pre>
     * Perform asynchronous speech-recognition: receive results via the
     * google.longrunning.Operations interface. `Operation.response` returns
     * `AsyncRecognizeResponse`.
     * </pre>
     */
    public com.google.longrunning.Operation asyncRecognize(com.google.cloud.speech.v1beta1.AsyncRecognizeRequest request);
  }

  /**
   * <pre>
   * Service that implements Google Cloud Speech API.
   * </pre>
   */
  @java.lang.Deprecated public static interface SpeechFutureClient {

    /**
     * <pre>
     * Perform synchronous speech-recognition: receive results after all audio
     * has been sent and processed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.speech.v1beta1.SyncRecognizeResponse> syncRecognize(
        com.google.cloud.speech.v1beta1.SyncRecognizeRequest request);

    /**
     * <pre>
     * Perform asynchronous speech-recognition: receive results via the
     * google.longrunning.Operations interface. `Operation.response` returns
     * `AsyncRecognizeResponse`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> asyncRecognize(
        com.google.cloud.speech.v1beta1.AsyncRecognizeRequest request);
  }

  public static class SpeechStub extends io.grpc.stub.AbstractStub<SpeechStub>
      implements Speech {
    private SpeechStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpeechStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeechStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpeechStub(channel, callOptions);
    }

    @java.lang.Override
    public void syncRecognize(com.google.cloud.speech.v1beta1.SyncRecognizeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.SyncRecognizeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SYNC_RECOGNIZE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void asyncRecognize(com.google.cloud.speech.v1beta1.AsyncRecognizeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ASYNC_RECOGNIZE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.StreamingRecognizeRequest> streamingRecognize(
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.StreamingRecognizeResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_STREAMING_RECOGNIZE, getCallOptions()), responseObserver);
    }
  }

  public static class SpeechBlockingStub extends io.grpc.stub.AbstractStub<SpeechBlockingStub>
      implements SpeechBlockingClient {
    private SpeechBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpeechBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeechBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpeechBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.cloud.speech.v1beta1.SyncRecognizeResponse syncRecognize(com.google.cloud.speech.v1beta1.SyncRecognizeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SYNC_RECOGNIZE, getCallOptions(), request);
    }

    @java.lang.Override
    public com.google.longrunning.Operation asyncRecognize(com.google.cloud.speech.v1beta1.AsyncRecognizeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ASYNC_RECOGNIZE, getCallOptions(), request);
    }
  }

  public static class SpeechFutureStub extends io.grpc.stub.AbstractStub<SpeechFutureStub>
      implements SpeechFutureClient {
    private SpeechFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpeechFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeechFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpeechFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.speech.v1beta1.SyncRecognizeResponse> syncRecognize(
        com.google.cloud.speech.v1beta1.SyncRecognizeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SYNC_RECOGNIZE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> asyncRecognize(
        com.google.cloud.speech.v1beta1.AsyncRecognizeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ASYNC_RECOGNIZE, getCallOptions()), request);
    }
  }

  @java.lang.Deprecated public static abstract class AbstractSpeech extends SpeechImplBase {}

  private static final int METHODID_SYNC_RECOGNIZE = 0;
  private static final int METHODID_ASYNC_RECOGNIZE = 1;
  private static final int METHODID_STREAMING_RECOGNIZE = 2;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Speech serviceImpl;
    private final int methodId;

    public MethodHandlers(Speech serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SYNC_RECOGNIZE:
          serviceImpl.syncRecognize((com.google.cloud.speech.v1beta1.SyncRecognizeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.SyncRecognizeResponse>) responseObserver);
          break;
        case METHODID_ASYNC_RECOGNIZE:
          serviceImpl.asyncRecognize((com.google.cloud.speech.v1beta1.AsyncRecognizeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAMING_RECOGNIZE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamingRecognize(
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v1beta1.StreamingRecognizeResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_SYNC_RECOGNIZE,
        METHOD_ASYNC_RECOGNIZE,
        METHOD_STREAMING_RECOGNIZE);
  }

  @java.lang.Deprecated public static io.grpc.ServerServiceDefinition bindService(
      final Speech serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          METHOD_SYNC_RECOGNIZE,
          asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.speech.v1beta1.SyncRecognizeRequest,
              com.google.cloud.speech.v1beta1.SyncRecognizeResponse>(
                serviceImpl, METHODID_SYNC_RECOGNIZE)))
        .addMethod(
          METHOD_ASYNC_RECOGNIZE,
          asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.speech.v1beta1.AsyncRecognizeRequest,
              com.google.longrunning.Operation>(
                serviceImpl, METHODID_ASYNC_RECOGNIZE)))
        .addMethod(
          METHOD_STREAMING_RECOGNIZE,
          asyncBidiStreamingCall(
            new MethodHandlers<
              com.google.cloud.speech.v1beta1.StreamingRecognizeRequest,
              com.google.cloud.speech.v1beta1.StreamingRecognizeResponse>(
                serviceImpl, METHODID_STREAMING_RECOGNIZE)))
        .build();
  }
}
