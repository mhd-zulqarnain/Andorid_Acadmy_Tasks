// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/speech/v1beta1/cloud_speech.proto

package com.google.cloud.speech.v1beta1;

public final class SpeechProto {
  private SpeechProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_speech_v1beta1_SyncRecognizeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_google_cloud_speech_v1beta1_SyncRecognizeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_speech_v1beta1_AsyncRecognizeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_google_cloud_speech_v1beta1_AsyncRecognizeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_speech_v1beta1_StreamingRecognizeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_google_cloud_speech_v1beta1_StreamingRecognizeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_speech_v1beta1_StreamingRecognitionConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_google_cloud_speech_v1beta1_StreamingRecognitionConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_speech_v1beta1_RecognitionConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_google_cloud_speech_v1beta1_RecognitionConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_speech_v1beta1_SpeechContext_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_google_cloud_speech_v1beta1_SpeechContext_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_speech_v1beta1_RecognitionAudio_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_google_cloud_speech_v1beta1_RecognitionAudio_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_speech_v1beta1_SyncRecognizeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_google_cloud_speech_v1beta1_SyncRecognizeResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_speech_v1beta1_AsyncRecognizeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_google_cloud_speech_v1beta1_AsyncRecognizeResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_speech_v1beta1_StreamingRecognizeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_google_cloud_speech_v1beta1_StreamingRecognizeResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_speech_v1beta1_StreamingRecognitionResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_google_cloud_speech_v1beta1_StreamingRecognitionResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_speech_v1beta1_SpeechRecognitionResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_google_cloud_speech_v1beta1_SpeechRecognitionResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_speech_v1beta1_SpeechRecognitionAlternative_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_google_cloud_speech_v1beta1_SpeechRecognitionAlternative_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n(google/speech/v1beta1/cloud_speech.pro" +
      "to\022\033google.cloud.speech.v1beta1\032\034google/" +
      "api/annotations.proto\032#google/longrunnin" +
      "g/operations.proto\032\027google/rpc/status.pr" +
      "oto\"\224\001\n\024SyncRecognizeRequest\022>\n\006config\030\001" +
      " \001(\0132..google.cloud.speech.v1beta1.Recog" +
      "nitionConfig\022<\n\005audio\030\002 \001(\0132-.google.clo" +
      "ud.speech.v1beta1.RecognitionAudio\"\225\001\n\025A" +
      "syncRecognizeRequest\022>\n\006config\030\001 \001(\0132..g" +
      "oogle.cloud.speech.v1beta1.RecognitionCo",
      "nfig\022<\n\005audio\030\002 \001(\0132-.google.cloud.speec" +
      "h.v1beta1.RecognitionAudio\"\242\001\n\031Streaming" +
      "RecognizeRequest\022S\n\020streaming_config\030\001 \001" +
      "(\01327.google.cloud.speech.v1beta1.Streami" +
      "ngRecognitionConfigH\000\022\033\n\raudio_content\030\002" +
      " \001(\014B\002\010\001H\000B\023\n\021streaming_request\"\217\001\n\032Stre" +
      "amingRecognitionConfig\022>\n\006config\030\001 \001(\0132." +
      ".google.cloud.speech.v1beta1.Recognition" +
      "Config\022\030\n\020single_utterance\030\002 \001(\010\022\027\n\017inte" +
      "rim_results\030\003 \001(\010\"\352\002\n\021RecognitionConfig\022",
      "N\n\010encoding\030\001 \001(\0162<.google.cloud.speech." +
      "v1beta1.RecognitionConfig.AudioEncoding\022" +
      "\023\n\013sample_rate\030\002 \001(\005\022\025\n\rlanguage_code\030\003 " +
      "\001(\t\022\030\n\020max_alternatives\030\004 \001(\005\022\030\n\020profani" +
      "ty_filter\030\005 \001(\010\022B\n\016speech_context\030\006 \001(\0132" +
      "*.google.cloud.speech.v1beta1.SpeechCont" +
      "ext\"a\n\rAudioEncoding\022\030\n\024ENCODING_UNSPECI" +
      "FIED\020\000\022\014\n\010LINEAR16\020\001\022\010\n\004FLAC\020\002\022\t\n\005MULAW\020" +
      "\003\022\007\n\003AMR\020\004\022\n\n\006AMR_WB\020\005\" \n\rSpeechContext\022" +
      "\017\n\007phrases\030\001 \003(\t\"H\n\020RecognitionAudio\022\025\n\007",
      "content\030\001 \001(\014B\002\010\001H\000\022\r\n\003uri\030\002 \001(\tH\000B\016\n\014au" +
      "dio_source\"^\n\025SyncRecognizeResponse\022E\n\007r" +
      "esults\030\002 \003(\01324.google.cloud.speech.v1bet" +
      "a1.SpeechRecognitionResult\"_\n\026AsyncRecog" +
      "nizeResponse\022E\n\007results\030\002 \003(\01324.google.c" +
      "loud.speech.v1beta1.SpeechRecognitionRes" +
      "ult\"\205\003\n\032StreamingRecognizeResponse\022!\n\005er" +
      "ror\030\001 \001(\0132\022.google.rpc.Status\022H\n\007results" +
      "\030\002 \003(\01327.google.cloud.speech.v1beta1.Str" +
      "eamingRecognitionResult\022\024\n\014result_index\030",
      "\003 \001(\005\022_\n\017endpointer_type\030\004 \001(\0162F.google." +
      "cloud.speech.v1beta1.StreamingRecognizeR" +
      "esponse.EndpointerType\"\202\001\n\016EndpointerTyp" +
      "e\022 \n\034ENDPOINTER_EVENT_UNSPECIFIED\020\000\022\023\n\017S" +
      "TART_OF_SPEECH\020\001\022\021\n\rEND_OF_SPEECH\020\002\022\020\n\014E" +
      "ND_OF_AUDIO\020\003\022\024\n\020END_OF_UTTERANCE\020\004\"\222\001\n\032" +
      "StreamingRecognitionResult\022O\n\014alternativ" +
      "es\030\001 \003(\01329.google.cloud.speech.v1beta1.S" +
      "peechRecognitionAlternative\022\020\n\010is_final\030" +
      "\002 \001(\010\022\021\n\tstability\030\003 \001(\002\"j\n\027SpeechRecogn",
      "itionResult\022O\n\014alternatives\030\001 \003(\01329.goog" +
      "le.cloud.speech.v1beta1.SpeechRecognitio" +
      "nAlternative\"F\n\034SpeechRecognitionAlterna" +
      "tive\022\022\n\ntranscript\030\001 \001(\t\022\022\n\nconfidence\030\002" +
      " \001(\0022\310\003\n\006Speech\022\240\001\n\rSyncRecognize\0221.goog" +
      "le.cloud.speech.v1beta1.SyncRecognizeReq" +
      "uest\0322.google.cloud.speech.v1beta1.SyncR" +
      "ecognizeResponse\"(\202\323\344\223\002\"\"\035/v1beta1/speec" +
      "h:syncrecognize:\001*\022\216\001\n\016AsyncRecognize\0222." +
      "google.cloud.speech.v1beta1.AsyncRecogni",
      "zeRequest\032\035.google.longrunning.Operation" +
      "\")\202\323\344\223\002#\"\036/v1beta1/speech:asyncrecognize" +
      ":\001*\022\211\001\n\022StreamingRecognize\0226.google.clou" +
      "d.speech.v1beta1.StreamingRecognizeReque" +
      "st\0327.google.cloud.speech.v1beta1.Streami" +
      "ngRecognizeResponse(\0010\001B0\n\037com.google.cl" +
      "oud.speech.v1beta1B\013SpeechProtoP\001b\006proto" +
      "3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.AnnotationsProto.getDescriptor(),
          com.google.longrunning.OperationsProto.getDescriptor(),
          com.google.rpc.StatusProto.getDescriptor(),
        }, assigner);
    internal_static_google_cloud_speech_v1beta1_SyncRecognizeRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_speech_v1beta1_SyncRecognizeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_google_cloud_speech_v1beta1_SyncRecognizeRequest_descriptor,
        new java.lang.String[] { "Config", "Audio", });
    internal_static_google_cloud_speech_v1beta1_AsyncRecognizeRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_speech_v1beta1_AsyncRecognizeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_google_cloud_speech_v1beta1_AsyncRecognizeRequest_descriptor,
        new java.lang.String[] { "Config", "Audio", });
    internal_static_google_cloud_speech_v1beta1_StreamingRecognizeRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_speech_v1beta1_StreamingRecognizeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_google_cloud_speech_v1beta1_StreamingRecognizeRequest_descriptor,
        new java.lang.String[] { "StreamingConfig", "AudioContent", "StreamingRequest", });
    internal_static_google_cloud_speech_v1beta1_StreamingRecognitionConfig_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_speech_v1beta1_StreamingRecognitionConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_google_cloud_speech_v1beta1_StreamingRecognitionConfig_descriptor,
        new java.lang.String[] { "Config", "SingleUtterance", "InterimResults", });
    internal_static_google_cloud_speech_v1beta1_RecognitionConfig_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_speech_v1beta1_RecognitionConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_google_cloud_speech_v1beta1_RecognitionConfig_descriptor,
        new java.lang.String[] { "Encoding", "SampleRate", "LanguageCode", "MaxAlternatives", "ProfanityFilter", "SpeechContext", });
    internal_static_google_cloud_speech_v1beta1_SpeechContext_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_speech_v1beta1_SpeechContext_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_google_cloud_speech_v1beta1_SpeechContext_descriptor,
        new java.lang.String[] { "Phrases", });
    internal_static_google_cloud_speech_v1beta1_RecognitionAudio_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_google_cloud_speech_v1beta1_RecognitionAudio_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_google_cloud_speech_v1beta1_RecognitionAudio_descriptor,
        new java.lang.String[] { "Content", "Uri", "AudioSource", });
    internal_static_google_cloud_speech_v1beta1_SyncRecognizeResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_google_cloud_speech_v1beta1_SyncRecognizeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_google_cloud_speech_v1beta1_SyncRecognizeResponse_descriptor,
        new java.lang.String[] { "Results", });
    internal_static_google_cloud_speech_v1beta1_AsyncRecognizeResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_google_cloud_speech_v1beta1_AsyncRecognizeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_google_cloud_speech_v1beta1_AsyncRecognizeResponse_descriptor,
        new java.lang.String[] { "Results", });
    internal_static_google_cloud_speech_v1beta1_StreamingRecognizeResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_google_cloud_speech_v1beta1_StreamingRecognizeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_google_cloud_speech_v1beta1_StreamingRecognizeResponse_descriptor,
        new java.lang.String[] { "Error", "Results", "ResultIndex", "EndpointerType", });
    internal_static_google_cloud_speech_v1beta1_StreamingRecognitionResult_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_google_cloud_speech_v1beta1_StreamingRecognitionResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_google_cloud_speech_v1beta1_StreamingRecognitionResult_descriptor,
        new java.lang.String[] { "Alternatives", "IsFinal", "Stability", });
    internal_static_google_cloud_speech_v1beta1_SpeechRecognitionResult_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_google_cloud_speech_v1beta1_SpeechRecognitionResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_google_cloud_speech_v1beta1_SpeechRecognitionResult_descriptor,
        new java.lang.String[] { "Alternatives", });
    internal_static_google_cloud_speech_v1beta1_SpeechRecognitionAlternative_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_google_cloud_speech_v1beta1_SpeechRecognitionAlternative_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_google_cloud_speech_v1beta1_SpeechRecognitionAlternative_descriptor,
        new java.lang.String[] { "Transcript", "Confidence", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.AnnotationsProto.http);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.longrunning.OperationsProto.getDescriptor();
    com.google.rpc.StatusProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
