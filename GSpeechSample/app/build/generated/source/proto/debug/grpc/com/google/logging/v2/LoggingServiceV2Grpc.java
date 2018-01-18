package com.google.logging.v2;

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
 * Service for ingesting and querying logs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 0.15.0)",
    comments = "Source: google/logging/v2/logging.proto")
public class LoggingServiceV2Grpc {

  private LoggingServiceV2Grpc() {}

  public static final String SERVICE_NAME = "google.logging.v2.LoggingServiceV2";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.DeleteLogRequest,
      com.google.protobuf.Empty> METHOD_DELETE_LOG =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.LoggingServiceV2", "DeleteLog"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.DeleteLogRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.WriteLogEntriesRequest,
      com.google.logging.v2.WriteLogEntriesResponse> METHOD_WRITE_LOG_ENTRIES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.LoggingServiceV2", "WriteLogEntries"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.WriteLogEntriesRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.WriteLogEntriesResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.ListLogEntriesRequest,
      com.google.logging.v2.ListLogEntriesResponse> METHOD_LIST_LOG_ENTRIES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.LoggingServiceV2", "ListLogEntries"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.ListLogEntriesRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.ListLogEntriesResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.logging.v2.ListMonitoredResourceDescriptorsRequest,
      com.google.logging.v2.ListMonitoredResourceDescriptorsResponse> METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "google.logging.v2.LoggingServiceV2", "ListMonitoredResourceDescriptors"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.ListMonitoredResourceDescriptorsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.logging.v2.ListMonitoredResourceDescriptorsResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LoggingServiceV2Stub newStub(io.grpc.Channel channel) {
    return new LoggingServiceV2Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LoggingServiceV2BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LoggingServiceV2BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static LoggingServiceV2FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LoggingServiceV2FutureStub(channel);
  }

  /**
   * <pre>
   * Service for ingesting and querying logs.
   * </pre>
   */
  @java.lang.Deprecated public static interface LoggingServiceV2 {

    /**
     * <pre>
     * Deletes a log and all its log entries.
     * The log will reappear if it receives new entries.
     * </pre>
     */
    public void deleteLog(com.google.logging.v2.DeleteLogRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver);

    /**
     * <pre>
     * Writes log entries to Cloud Logging.
     * All log entries in Cloud Logging are written by this method.
     * </pre>
     */
    public void writeLogEntries(com.google.logging.v2.WriteLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.WriteLogEntriesResponse> responseObserver);

    /**
     * <pre>
     * Lists log entries.  Use this method to retrieve log entries from Cloud
     * Logging.  For ways to export log entries, see
     * [Exporting Logs](/logging/docs/export).
     * </pre>
     */
    public void listLogEntries(com.google.logging.v2.ListLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogEntriesResponse> responseObserver);

    /**
     * <pre>
     * Lists monitored resource descriptors that are used by Cloud Logging.
     * </pre>
     */
    public void listMonitoredResourceDescriptors(com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListMonitoredResourceDescriptorsResponse> responseObserver);
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1469")
  public static abstract class LoggingServiceV2ImplBase implements LoggingServiceV2, io.grpc.BindableService {

    @java.lang.Override
    public void deleteLog(com.google.logging.v2.DeleteLogRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_LOG, responseObserver);
    }

    @java.lang.Override
    public void writeLogEntries(com.google.logging.v2.WriteLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.WriteLogEntriesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_WRITE_LOG_ENTRIES, responseObserver);
    }

    @java.lang.Override
    public void listLogEntries(com.google.logging.v2.ListLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogEntriesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_LOG_ENTRIES, responseObserver);
    }

    @java.lang.Override
    public void listMonitoredResourceDescriptors(com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListMonitoredResourceDescriptorsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return LoggingServiceV2Grpc.bindService(this);
    }
  }

  /**
   * <pre>
   * Service for ingesting and querying logs.
   * </pre>
   */
  @java.lang.Deprecated public static interface LoggingServiceV2BlockingClient {

    /**
     * <pre>
     * Deletes a log and all its log entries.
     * The log will reappear if it receives new entries.
     * </pre>
     */
    public com.google.protobuf.Empty deleteLog(com.google.logging.v2.DeleteLogRequest request);

    /**
     * <pre>
     * Writes log entries to Cloud Logging.
     * All log entries in Cloud Logging are written by this method.
     * </pre>
     */
    public com.google.logging.v2.WriteLogEntriesResponse writeLogEntries(com.google.logging.v2.WriteLogEntriesRequest request);

    /**
     * <pre>
     * Lists log entries.  Use this method to retrieve log entries from Cloud
     * Logging.  For ways to export log entries, see
     * [Exporting Logs](/logging/docs/export).
     * </pre>
     */
    public com.google.logging.v2.ListLogEntriesResponse listLogEntries(com.google.logging.v2.ListLogEntriesRequest request);

    /**
     * <pre>
     * Lists monitored resource descriptors that are used by Cloud Logging.
     * </pre>
     */
    public com.google.logging.v2.ListMonitoredResourceDescriptorsResponse listMonitoredResourceDescriptors(com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request);
  }

  /**
   * <pre>
   * Service for ingesting and querying logs.
   * </pre>
   */
  @java.lang.Deprecated public static interface LoggingServiceV2FutureClient {

    /**
     * <pre>
     * Deletes a log and all its log entries.
     * The log will reappear if it receives new entries.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteLog(
        com.google.logging.v2.DeleteLogRequest request);

    /**
     * <pre>
     * Writes log entries to Cloud Logging.
     * All log entries in Cloud Logging are written by this method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.WriteLogEntriesResponse> writeLogEntries(
        com.google.logging.v2.WriteLogEntriesRequest request);

    /**
     * <pre>
     * Lists log entries.  Use this method to retrieve log entries from Cloud
     * Logging.  For ways to export log entries, see
     * [Exporting Logs](/logging/docs/export).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.ListLogEntriesResponse> listLogEntries(
        com.google.logging.v2.ListLogEntriesRequest request);

    /**
     * <pre>
     * Lists monitored resource descriptors that are used by Cloud Logging.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.ListMonitoredResourceDescriptorsResponse> listMonitoredResourceDescriptors(
        com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request);
  }

  public static class LoggingServiceV2Stub extends io.grpc.stub.AbstractStub<LoggingServiceV2Stub>
      implements LoggingServiceV2 {
    private LoggingServiceV2Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoggingServiceV2Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoggingServiceV2Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoggingServiceV2Stub(channel, callOptions);
    }

    @java.lang.Override
    public void deleteLog(com.google.logging.v2.DeleteLogRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_LOG, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void writeLogEntries(com.google.logging.v2.WriteLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.WriteLogEntriesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_WRITE_LOG_ENTRIES, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void listLogEntries(com.google.logging.v2.ListLogEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogEntriesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_LOG_ENTRIES, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void listMonitoredResourceDescriptors(com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request,
        io.grpc.stub.StreamObserver<com.google.logging.v2.ListMonitoredResourceDescriptorsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS, getCallOptions()), request, responseObserver);
    }
  }

  public static class LoggingServiceV2BlockingStub extends io.grpc.stub.AbstractStub<LoggingServiceV2BlockingStub>
      implements LoggingServiceV2BlockingClient {
    private LoggingServiceV2BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoggingServiceV2BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoggingServiceV2BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoggingServiceV2BlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.protobuf.Empty deleteLog(com.google.logging.v2.DeleteLogRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_LOG, getCallOptions(), request);
    }

    @java.lang.Override
    public com.google.logging.v2.WriteLogEntriesResponse writeLogEntries(com.google.logging.v2.WriteLogEntriesRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_WRITE_LOG_ENTRIES, getCallOptions(), request);
    }

    @java.lang.Override
    public com.google.logging.v2.ListLogEntriesResponse listLogEntries(com.google.logging.v2.ListLogEntriesRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_LOG_ENTRIES, getCallOptions(), request);
    }

    @java.lang.Override
    public com.google.logging.v2.ListMonitoredResourceDescriptorsResponse listMonitoredResourceDescriptors(com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS, getCallOptions(), request);
    }
  }

  public static class LoggingServiceV2FutureStub extends io.grpc.stub.AbstractStub<LoggingServiceV2FutureStub>
      implements LoggingServiceV2FutureClient {
    private LoggingServiceV2FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoggingServiceV2FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoggingServiceV2FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoggingServiceV2FutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteLog(
        com.google.logging.v2.DeleteLogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_LOG, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.WriteLogEntriesResponse> writeLogEntries(
        com.google.logging.v2.WriteLogEntriesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_WRITE_LOG_ENTRIES, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.ListLogEntriesResponse> listLogEntries(
        com.google.logging.v2.ListLogEntriesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_LOG_ENTRIES, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.logging.v2.ListMonitoredResourceDescriptorsResponse> listMonitoredResourceDescriptors(
        com.google.logging.v2.ListMonitoredResourceDescriptorsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS, getCallOptions()), request);
    }
  }

  @java.lang.Deprecated public static abstract class AbstractLoggingServiceV2 extends LoggingServiceV2ImplBase {}

  private static final int METHODID_DELETE_LOG = 0;
  private static final int METHODID_WRITE_LOG_ENTRIES = 1;
  private static final int METHODID_LIST_LOG_ENTRIES = 2;
  private static final int METHODID_LIST_MONITORED_RESOURCE_DESCRIPTORS = 3;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LoggingServiceV2 serviceImpl;
    private final int methodId;

    public MethodHandlers(LoggingServiceV2 serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DELETE_LOG:
          serviceImpl.deleteLog((com.google.logging.v2.DeleteLogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_WRITE_LOG_ENTRIES:
          serviceImpl.writeLogEntries((com.google.logging.v2.WriteLogEntriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.WriteLogEntriesResponse>) responseObserver);
          break;
        case METHODID_LIST_LOG_ENTRIES:
          serviceImpl.listLogEntries((com.google.logging.v2.ListLogEntriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.ListLogEntriesResponse>) responseObserver);
          break;
        case METHODID_LIST_MONITORED_RESOURCE_DESCRIPTORS:
          serviceImpl.listMonitoredResourceDescriptors((com.google.logging.v2.ListMonitoredResourceDescriptorsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.logging.v2.ListMonitoredResourceDescriptorsResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_DELETE_LOG,
        METHOD_WRITE_LOG_ENTRIES,
        METHOD_LIST_LOG_ENTRIES,
        METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS);
  }

  @java.lang.Deprecated public static io.grpc.ServerServiceDefinition bindService(
      final LoggingServiceV2 serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          METHOD_DELETE_LOG,
          asyncUnaryCall(
            new MethodHandlers<
              com.google.logging.v2.DeleteLogRequest,
              com.google.protobuf.Empty>(
                serviceImpl, METHODID_DELETE_LOG)))
        .addMethod(
          METHOD_WRITE_LOG_ENTRIES,
          asyncUnaryCall(
            new MethodHandlers<
              com.google.logging.v2.WriteLogEntriesRequest,
              com.google.logging.v2.WriteLogEntriesResponse>(
                serviceImpl, METHODID_WRITE_LOG_ENTRIES)))
        .addMethod(
          METHOD_LIST_LOG_ENTRIES,
          asyncUnaryCall(
            new MethodHandlers<
              com.google.logging.v2.ListLogEntriesRequest,
              com.google.logging.v2.ListLogEntriesResponse>(
                serviceImpl, METHODID_LIST_LOG_ENTRIES)))
        .addMethod(
          METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS,
          asyncUnaryCall(
            new MethodHandlers<
              com.google.logging.v2.ListMonitoredResourceDescriptorsRequest,
              com.google.logging.v2.ListMonitoredResourceDescriptorsResponse>(
                serviceImpl, METHODID_LIST_MONITORED_RESOURCE_DESCRIPTORS)))
        .build();
  }
}
