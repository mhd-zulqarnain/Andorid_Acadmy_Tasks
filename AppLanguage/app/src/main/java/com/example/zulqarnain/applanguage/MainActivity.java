package com.example.zulqarnain.applanguage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private final int RECORD_REQUEST_CODE = 101;

    TextView textMessage;
    private List<String> stringList;
    private ArrayAdapter adapter;
    private SpeechAPI speechAPI;
    private VoiceRecoder mVoiceRecoder;
    private final VoiceRecoder.CallBack mVoiceCallBack = new VoiceRecoder.CallBack() {
        @Override
        public void onVoiceStart() {
            if(speechAPI!=null){
                speechAPI.startRecognizing(mVoiceRecoder.getSampleRate());
            }
        }

        @Override
        public void onVoice(byte[] data, int size) {
            if(speechAPI!=null){
                speechAPI.recognize(data,size);
            }
        }

        @Override
        public void onVoicEnd() {
            speechAPI.finishRecognizing();
        }
    };


    private final SpeechAPI.Listener mSpeechServiceListener= new SpeechAPI.Listener() {
        @Override
        public void onSpeechRecognized(final String text, final boolean isFinal) {
            if (isFinal)
                mVoiceRecoder.dismiss();
            if(textMessage!=null && !TextUtils.isEmpty(text)){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(isFinal){
                            textMessage.setText(null);
                            stringList.add(0,text);
                            adapter.notifyDataSetChanged();
                        }
                        else
                            textMessage.setText(text);
                    }
                });
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textMessage = (TextView) findViewById(R.id.messege);
        listView = (ListView) findViewById(R.id.list_item);
        speechAPI = new SpeechAPI(MainActivity.this);

        stringList=new ArrayList<>();
        adapter= new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,stringList);
        listView.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isGrantedPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
            startVoiceRecorder();
        } else
            makeRequest(Manifest.permission.RECORD_AUDIO);

        speechAPI.addListener(mSpeechServiceListener);
    }

    @Override
    protected void onStop() {
        stopVoiceRecorder();
        speechAPI.removeListener(mSpeechServiceListener);
        speechAPI.destroy();
        speechAPI=null;
        super.onStop();

    }

    public void stopVoiceRecorder(){
        if (mVoiceRecoder != null) {
            mVoiceRecoder.stop();
            mVoiceRecoder = null;
        }
    }
    public void startVoiceRecorder() {
        if (mVoiceRecoder != null)
            mVoiceRecoder.stop();
        mVoiceRecoder = new VoiceRecoder(mVoiceCallBack);
        mVoiceRecoder.start();

    }

    private int isGrantedPermission(String permission) {
        return ContextCompat.checkSelfPermission(this, permission);
    }

    private void makeRequest(String permission) {
        ActivityCompat.requestPermissions(this, new String[]{permission}, RECORD_REQUEST_CODE);
    }
}
