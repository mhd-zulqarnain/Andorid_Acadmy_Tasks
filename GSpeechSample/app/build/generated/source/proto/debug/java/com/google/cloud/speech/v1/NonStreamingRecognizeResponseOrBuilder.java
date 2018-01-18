// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/speech/v1/cloud-speech.proto

package com.google.cloud.speech.v1;

public interface NonStreamingRecognizeResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.speech.v1.NonStreamingRecognizeResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * [Output-only] Sequential list of messages returned by the recognizer.
   * </pre>
   *
   * <code>repeated .google.cloud.speech.v1.RecognizeResponse responses = 1;</code>
   */
  java.util.List<com.google.cloud.speech.v1.RecognizeResponse> 
      getResponsesList();
  /**
   * <pre>
   * [Output-only] Sequential list of messages returned by the recognizer.
   * </pre>
   *
   * <code>repeated .google.cloud.speech.v1.RecognizeResponse responses = 1;</code>
   */
  com.google.cloud.speech.v1.RecognizeResponse getResponses(int index);
  /**
   * <pre>
   * [Output-only] Sequential list of messages returned by the recognizer.
   * </pre>
   *
   * <code>repeated .google.cloud.speech.v1.RecognizeResponse responses = 1;</code>
   */
  int getResponsesCount();
  /**
   * <pre>
   * [Output-only] Sequential list of messages returned by the recognizer.
   * </pre>
   *
   * <code>repeated .google.cloud.speech.v1.RecognizeResponse responses = 1;</code>
   */
  java.util.List<? extends com.google.cloud.speech.v1.RecognizeResponseOrBuilder> 
      getResponsesOrBuilderList();
  /**
   * <pre>
   * [Output-only] Sequential list of messages returned by the recognizer.
   * </pre>
   *
   * <code>repeated .google.cloud.speech.v1.RecognizeResponse responses = 1;</code>
   */
  com.google.cloud.speech.v1.RecognizeResponseOrBuilder getResponsesOrBuilder(
      int index);
}
