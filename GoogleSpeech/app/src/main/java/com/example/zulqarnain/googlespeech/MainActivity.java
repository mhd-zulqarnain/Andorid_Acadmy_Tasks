package com.example.zulqarnain.googlespeech;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
   /* @BindView(R.id.textMessage)
    TextView textMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        textMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"clicked",Toast.LENGTH_SHORT).show();
            }
        });

    }*/


    public static final String TAG = "MainActivity";

    private static final int RECORD_REQUEST_CODE = 101;
   /* @BindView(R.id.status)
    TextView status;
    @BindView(R.id.textMessage)
    TextView textMessage;

    @BindView(R.id.listview)
    ListView listView;*/

    private List<String> stringList;
    private SpeechAPI speechAPI;
    private VoiceRecorder mVoiceRecorder;
    /* private final VoiceRecorder.Callback mVoiceCallback = new VoiceRecorder.Callback() {

         @Override
         public void onVoiceStart() {
             if (speechAPI != null) {
                 speechAPI.startRecognizing(mVoiceRecorder.getSampleRate());
             }
         }

         @Override
         public void onVoice(byte[] data, int size) {
             if (speechAPI != null) {
                 speechAPI.recognize(data, size);
             }
         }

         @Override
         public void onVoiceEnd() {
             if (speechAPI != null) {
                 speechAPI.finishRecognizing();
             }
         }

     };*/
    private ArrayAdapter adapter;
   /* private final SpeechAPI.Listener mSpeechServiceListener =
            new SpeechAPI.Listener() {
                @Override
                public void onSpeechRecognized(final String text, final boolean isFinal) {
                    if (isFinal) {
                        mVoiceRecorder.dismiss();
                    }
                    if (textMessage != null && !TextUtils.isEmpty(text)) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (isFinal) {
                                    textMessage.setText(null);
                                    stringList.add(0, text);
                                    adapter.notifyDataSetChanged();
                                } else {
                                    textMessage.setText(text);
                                }
                            }
                        });
                    }
                }
            };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
        Log.d(TAG, "onCreate: called");
        /*speechAPI = new SpeechAPI(MainActivity.this);*/
      /*  stringList = new ArrayList<>();
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, stringList);
        listView.setAdapter(adapter);*/
    }

    @Override
    protected void onStop() {
        stopVoiceRecorder();
        Log.d(TAG, "onStop: called");
        // Stop Cloud Speech API
       /* speechAPI.removeListener(mSpeechServiceListener);
        speechAPI.destroy();*/
        speechAPI = null;

        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: called");

    }

    @Override
    protected void onStart() {

        Log.d(TAG, "onStart: called");
       /* askPersmission(Manifest.permission.RECORD_AUDIO,RECORD_REQUEST_CODE);*/

        /*
        if (isGrantedPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
            startVoiceRecorder();
        } else {
            makeRequest(Manifest.permission.RECORD_AUDIO);
        }
        speechAPI.addListener(mSpeechServiceListener);*/
        super.onStart();

    }

    private int isGrantedPermission(String permission) {
        return ContextCompat.checkSelfPermission(this, permission);
    }

    private void makeRequest(String permission) {
        ActivityCompat.requestPermissions(this, new String[]{permission}, RECORD_REQUEST_CODE);
    }

    private void startVoiceRecorder() {
        if (mVoiceRecorder != null) {
            mVoiceRecorder.stop();
        }
//        mVoiceRecorder = new VoiceRecorder(mVoiceCallback);
//        mVoiceRecorder.start();
    }

    private void stopVoiceRecorder() {
        if (mVoiceRecorder != null) {
            mVoiceRecorder.stop();
            mVoiceRecorder = null;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == RECORD_REQUEST_CODE) {
            if (grantResults.length == 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startVoiceRecorder();

            } else {
                finish();

            }
        }
    }

    public void askPersmission(String permission,int requestCode){
        if(ContextCompat.checkSelfPermission(this,permission)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{permission},requestCode);
        }else
            Log.d(TAG, "askPersmission: Permission denied");

    }

}
