// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/speech/v1beta1/cloud_speech.proto

package com.google.cloud.speech.v1beta1;

public interface AsyncRecognizeResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.speech.v1beta1.AsyncRecognizeResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * [Output-only] Sequential list of transcription results corresponding to
   * sequential portions of audio.
   * </pre>
   *
   * <code>repeated .google.cloud.speech.v1beta1.SpeechRecognitionResult results = 2;</code>
   */
  java.util.List<com.google.cloud.speech.v1beta1.SpeechRecognitionResult> 
      getResultsList();
  /**
   * <pre>
   * [Output-only] Sequential list of transcription results corresponding to
   * sequential portions of audio.
   * </pre>
   *
   * <code>repeated .google.cloud.speech.v1beta1.SpeechRecognitionResult results = 2;</code>
   */
  com.google.cloud.speech.v1beta1.SpeechRecognitionResult getResults(int index);
  /**
   * <pre>
   * [Output-only] Sequential list of transcription results corresponding to
   * sequential portions of audio.
   * </pre>
   *
   * <code>repeated .google.cloud.speech.v1beta1.SpeechRecognitionResult results = 2;</code>
   */
  int getResultsCount();
  /**
   * <pre>
   * [Output-only] Sequential list of transcription results corresponding to
   * sequential portions of audio.
   * </pre>
   *
   * <code>repeated .google.cloud.speech.v1beta1.SpeechRecognitionResult results = 2;</code>
   */
  java.util.List<? extends com.google.cloud.speech.v1beta1.SpeechRecognitionResultOrBuilder> 
      getResultsOrBuilderList();
  /**
   * <pre>
   * [Output-only] Sequential list of transcription results corresponding to
   * sequential portions of audio.
   * </pre>
   *
   * <code>repeated .google.cloud.speech.v1beta1.SpeechRecognitionResult results = 2;</code>
   */
  com.google.cloud.speech.v1beta1.SpeechRecognitionResultOrBuilder getResultsOrBuilder(
      int index);
}
