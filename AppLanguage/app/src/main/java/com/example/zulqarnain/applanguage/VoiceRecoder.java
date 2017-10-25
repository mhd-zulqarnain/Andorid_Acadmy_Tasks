package com.example.zulqarnain.applanguage;

import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Zul Qarnain on 10/19/2017.
 */

public class VoiceRecoder {


    private static final int[] SAMPLE_RATE_CANDIDATES = new int[]{16000, 11025, 22050, 44100};

    private static final int CHANNEL = AudioFormat.CHANNEL_IN_MONO;
    private static final int ENCODING = AudioFormat.ENCODING_PCM_16BIT;

    private static final int AMPLITUDE_THRESHOLD = 1500;

    private static final int SPEECH_TIMEOUT_MILLIS = 2000;
    private static final int MAX_SPEECH_LENGTH_MILLIS = 30 * 1000;
    private long mLastVoiceHeardMillis = Long.MAX_VALUE;
    private long mVoiceStartedMillis;



    public static abstract class CallBack {

        public void onVoiceStart() {
        }

        public void onVoice(byte[] data, int size) {
        }

        public void onVoicEnd() {
        }
    }

    private AudioRecord mAudioRecord;
    private Thread mThread;
    private byte[] mBuffer;
    private CallBack mCallBack;
    private final Object mLock = new Object();


    public VoiceRecoder(CallBack callBack) {

        mCallBack = callBack;
    }


    public void start() {
        stop();

        mAudioRecord=createAudioRecord();

        if (mAudioRecord==null){
            throw  new RuntimeException("Cannot instantiate VoiceRecorder");
        }
        mAudioRecord.startRecording();
        mThread = new Thread(new ProcessVoice());
        mThread.start();
    }

    private AudioRecord createAudioRecord() {
        for(int sample :SAMPLE_RATE_CANDIDATES){
            final int sizeInBytes = AudioRecord.getMinBufferSize(sample,CHANNEL,ENCODING);

            if(sizeInBytes == AudioRecord.ERROR_BAD_VALUE){
                continue;
            }
            final AudioRecord audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC, sample,CHANNEL,ENCODING,sizeInBytes);
            if(audioRecord.getState() == AudioRecord.STATE_INITIALIZED){
                mBuffer= new byte[sizeInBytes];
                return audioRecord;
            }
            else
                audioRecord.release();
        }

        return  null;
    }




    public void stop() {
        synchronized (mLock){
            dismiss();
            if(mThread!=null){
                mThread.interrupt();

                mThread=null;
            }
            if(mAudioRecord!=null){
                mAudioRecord.stop();
                mAudioRecord.release();
                mAudioRecord=null;
            }
        }
        mBuffer=null;

    }

    public void dismiss(){
        if(mLastVoiceHeardMillis!=Long.MAX_VALUE){
            mLastVoiceHeardMillis=Long.MAX_VALUE;
            mCallBack.onVoicEnd();
        }
    }

    private class ProcessVoice implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (mLock){
                    if(Thread.currentThread().isInterrupted()){
                        break;
                    }
                    final int size =mAudioRecord.read(mBuffer,0,mBuffer.length);
                    final long now=System.currentTimeMillis();

                    if (isHearingVoice(mBuffer,size)){
                        if(mLastVoiceHeardMillis==Long.MAX_VALUE){
                            mVoiceStartedMillis=now;
                            mCallBack.onVoiceStart();   //starting recongnizing
                        }

                        mCallBack.onVoice(mBuffer,size);
                        mLastVoiceHeardMillis=now;
                        if (now - mVoiceStartedMillis > MAX_SPEECH_LENGTH_MILLIS) {
                            end();
                        }
                    } else if (mLastVoiceHeardMillis != Long.MAX_VALUE) {
                        mCallBack.onVoice(mBuffer, size);
                        if (now - mLastVoiceHeardMillis > SPEECH_TIMEOUT_MILLIS) {
                            end();
                        }
                    }
                }
            }
        }
    }

    public void end(){
        mLastVoiceHeardMillis= Long.MAX_VALUE;
        mCallBack.onVoicEnd();
    }

    private boolean isHearingVoice(byte[] buffer,int size){
        for(int i=0; i<size-1;i+=2){
            int s =buffer[i+1];
            if(s<0) s*=-1;
            s<<=8;
            s+=Math.abs(buffer[i]);
            if(s>AMPLITUDE_THRESHOLD)
                return true;

        }
        return false;
    }

    public int getSampleRate() {
        if(mAudioRecord!=null){
            return mAudioRecord.getSampleRate();
        }
        return 0;
    }
}


