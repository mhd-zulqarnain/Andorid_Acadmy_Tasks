package com.example.zulqarnain.applanguage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.SpeechGrpc;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.StreamingRecognitionConfig;
import com.google.cloud.speech.v1.StreamingRecognitionResult;
import com.google.cloud.speech.v1.StreamingRecognizeRequest;
import com.google.cloud.speech.v1.StreamingRecognizeResponse;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.internal.DnsNameResolverProvider;
import io.grpc.okhttp.OkHttpChannelProvider;
import io.grpc.stub.StreamObserver;

import static android.content.ContentValues.TAG;

/**
 * Created by Zul Qarnain on 10/20/2017.
 */

public class SpeechAPI {

    /*
    * Observer contain the data i.e the speech
    * and to
    * */
    public static final List<String> SCOPE = Collections.singletonList("https://www.googleapis.com/auth/cloud-platform");
    private StreamObserver<StreamingRecognizeRequest> mRequestObserver;
    private SpeechGrpc.SpeechStub mApi;  //method that implements google api
    private Context mContext;
    private static final String PREFS = "SpeechService";
    private static final String PREF_ACCESS_TOKEN_VALUE = "accessToken";
    private static final String PREF_ACCESS_TOKEN_EXPIRATION_TIME = "access_token_expiration_time";
    private static final int ACCESS_TOKEN_EXPIRATION_TOLERANCE = 30 * 60 * 1000;
    private volatile AccessTokenTask mAccessTokenTask;
    private static final String HOSTNAME = "speech.googleapis.com";
    private static final int PORT = 443;
    private static Handler mHandler;
    private static final int ACCESS_TOKEN_FETCH_MARGIN = 60 * 1000;
    private final ArrayList<Listener> mListeners= new ArrayList<>();

    public SpeechAPI(Context mContext) {
        this.mContext = mContext;
        mHandler = new Handler();

    }

    //configuring Speech API
    private final StreamObserver<StreamingRecognizeResponse> mResponseObserver = new StreamObserver<StreamingRecognizeResponse>() {
        @Override
        public void onNext(StreamingRecognizeResponse response) {

            String text = null;
            boolean isFinal = false;
            if (response.getResultsCount() > 0) {
                final StreamingRecognitionResult result = response.getResults(0);
                isFinal = result.getIsFinal();
                if (result.getAlternativesCount() > 0) {
                    final SpeechRecognitionAlternative alternative = result.getAlternatives(0);
                    text = alternative.getTranscript();
                }
            }
            if (text != null) {
                for (Listener listener : mListeners) {
                    listener.onSpeechRecognized(text, isFinal);
                }
            }
        }

        @Override
        public void onError(Throwable t) {
            Log.d(TAG, "onError: Exception "+t);
        }

        @Override
        public void onCompleted() {
            Log.d(TAG, "onComplete: ");

        }
    };


    public void addListener(Listener listener){
        mListeners.add(listener);
    }
    public void removeListener(Listener listener){
        mListeners.remove(listener);
    }
    public void startRecognizing(int sample) {
        mRequestObserver = mApi.streamingRecognize(mResponseObserver);   //mRequestObserver is the streamobserver
//            RecognitionConfig.AudioEncoding
        StreamingRecognitionConfig streamingConfig = StreamingRecognitionConfig.newBuilder()
                .setConfig(RecognitionConfig.newBuilder()
                        .setLanguageCode("en-us")
                        .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                        .setSampleRateHertz(sample).build())
                .setInterimResults(true)
                .setSingleUtterance(true)
                .build();

        /*
        *  StreamingRecognizeRequest  is top level  message send by StreamingRecognize
        *  The first messege must contain resquest
        *  and the corresponding reqeust contain data
        *
        * */
        StreamingRecognizeRequest streamingRecognitionResult = StreamingRecognizeRequest.newBuilder().setStreamingConfig(streamingConfig).build();
        mRequestObserver.onNext(streamingRecognitionResult);

    }

    public void recognize(byte[] data,int size){
        if(mRequestObserver == null){
            return;
        }

    }

    private final Runnable mFetchAccessTokenRunnable = new Runnable() {
        @Override
        public void run() {
            fetchAccessToken();
        }
    };

    private void fetchAccessToken() {
        if (mAccessTokenTask != null)
            return;
        mAccessTokenTask = new AccessTokenTask();
        mAccessTokenTask.execute();
    }



    public interface Listener {
        void onSpeechRecognized(String text, boolean isFinal);
    }

    public class AccessTokenTask extends AsyncTask<Void, Void, AccessToken> {


        @Override
        protected AccessToken doInBackground(Void... voids) {
            final SharedPreferences prefs = mContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
            String tokenValue = prefs.getString(PREF_ACCESS_TOKEN_VALUE, null);
            long expirationTime = prefs.getLong(PREF_ACCESS_TOKEN_EXPIRATION_TIME, -1);

            if (tokenValue != null && expirationTime > 0) {
                if (expirationTime > System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION_TOLERANCE) {
                    return new AccessToken(tokenValue, new Date(expirationTime));
                }
            }

            final InputStream stream = mContext.getResources().openRawResource(R.raw.credential);
            try {
                final GoogleCredentials credentials = GoogleCredentials.fromStream(stream).createScoped(SCOPE);
                final AccessToken token = credentials.refreshAccessToken();
                prefs.edit()
                        .putString(PREF_ACCESS_TOKEN_VALUE, token.getTokenValue())
                        .putLong(PREF_ACCESS_TOKEN_EXPIRATION_TIME, token.getExpirationTime().getTime())
                        .apply();
                return token;

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onPostExecute(AccessToken accessToken) {
            mAccessTokenTask = null;

            final ManagedChannel channel = new OkHttpChannelProvider()
                    .builderForAddress(HOSTNAME, PORT)
                    .nameResolverFactory(new DnsNameResolverProvider())
                    .intercept((List<ClientInterceptor>) new GoogleCredentials(accessToken)    //can cause error
                            .createScoped(SCOPE))
                    .build();
            mApi = SpeechGrpc.newStub(channel);
            if (mHandler != null) {
                mHandler.postDelayed(mFetchAccessTokenRunnable,
                        Math.max(accessToken.getExpirationTime().getTime() - System.currentTimeMillis() - ACCESS_TOKEN_FETCH_MARGIN, ACCESS_TOKEN_EXPIRATION_TOLERANCE));
            }
        }
    }
    public void destroy(){
        mHandler.removeCallbacksAndMessages(mFetchAccessTokenRunnable);
        mHandler = null;
        if(mApi!=null){
            final ManagedChannel channel = (ManagedChannel) mApi.getChannel();
                if(channel!=null && !channel.isShutdown()){
                    try {
                        channel.shutdown().awaitTermination(5,TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
        mApi=null;
    }

    public void finishRecognizing() {
        if(mRequestObserver==null){
            return;
        }
        mRequestObserver.onCompleted();
        mRequestObserver=null;
    }
}
