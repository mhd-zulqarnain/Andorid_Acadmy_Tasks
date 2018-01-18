// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/logging/v2/logging_metrics.proto

package com.google.logging.v2;

public interface ListLogMetricsRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.logging.v2.ListLogMetricsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. The resource name of the project containing the metrics.
   * Example: `"projects/my-project-id"`.
   * </pre>
   *
   * <code>optional string project_name = 1;</code>
   */
  java.lang.String getProjectName();
  /**
   * <pre>
   * Required. The resource name of the project containing the metrics.
   * Example: `"projects/my-project-id"`.
   * </pre>
   *
   * <code>optional string project_name = 1;</code>
   */
  com.google.protobuf.ByteString
      getProjectNameBytes();

  /**
   * <pre>
   * Optional. If the `pageToken` request parameter is supplied, then the next
   * page of results in the set are retrieved.  The `pageToken` parameter must
   * be set with the value of the `nextPageToken` result parameter from the
   * previous request.  The value of `projectName` must
   * be the same as in the previous request.
   * </pre>
   *
   * <code>optional string page_token = 2;</code>
   */
  java.lang.String getPageToken();
  /**
   * <pre>
   * Optional. If the `pageToken` request parameter is supplied, then the next
   * page of results in the set are retrieved.  The `pageToken` parameter must
   * be set with the value of the `nextPageToken` result parameter from the
   * previous request.  The value of `projectName` must
   * be the same as in the previous request.
   * </pre>
   *
   * <code>optional string page_token = 2;</code>
   */
  com.google.protobuf.ByteString
      getPageTokenBytes();

  /**
   * <pre>
   * Optional. The maximum number of results to return from this request.  Fewer
   * results might be returned. You must check for the `nextPageToken` result to
   * determine if additional results are available, which you can retrieve by
   * passing the `nextPageToken` value in the `pageToken` parameter to the next
   * request.
   * </pre>
   *
   * <code>optional int32 page_size = 3;</code>
   */
  int getPageSize();
}
