// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/speech/v1beta1/cloud_speech.proto

package com.google.cloud.speech.v1beta1;

public interface SpeechContextOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.speech.v1beta1.SpeechContext)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * [Optional] A list of up to 50 phrases of up to 100 characters each to
   * provide words and phrases "hints" to the speech recognition so that it is
   * more likely to recognize them.
   * </pre>
   *
   * <code>repeated string phrases = 1;</code>
   */
  com.google.protobuf.ProtocolStringList
      getPhrasesList();
  /**
   * <pre>
   * [Optional] A list of up to 50 phrases of up to 100 characters each to
   * provide words and phrases "hints" to the speech recognition so that it is
   * more likely to recognize them.
   * </pre>
   *
   * <code>repeated string phrases = 1;</code>
   */
  int getPhrasesCount();
  /**
   * <pre>
   * [Optional] A list of up to 50 phrases of up to 100 characters each to
   * provide words and phrases "hints" to the speech recognition so that it is
   * more likely to recognize them.
   * </pre>
   *
   * <code>repeated string phrases = 1;</code>
   */
  java.lang.String getPhrases(int index);
  /**
   * <pre>
   * [Optional] A list of up to 50 phrases of up to 100 characters each to
   * provide words and phrases "hints" to the speech recognition so that it is
   * more likely to recognize them.
   * </pre>
   *
   * <code>repeated string phrases = 1;</code>
   */
  com.google.protobuf.ByteString
      getPhrasesBytes(int index);
}
