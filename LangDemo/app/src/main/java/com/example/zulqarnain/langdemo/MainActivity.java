package com.example.zulqarnain.langdemo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.util.Base64;
import com.google.api.services.speech.v1beta1.Speech;
import com.google.api.services.speech.v1beta1.SpeechRequestInitializer;
import com.google.api.services.speech.v1beta1.model.RecognitionAudio;
import com.google.api.services.speech.v1beta1.model.RecognitionConfig;
import com.google.api.services.speech.v1beta1.model.SpeechRecognitionResult;
import com.google.api.services.speech.v1beta1.model.SyncRecognizeRequest;
import com.google.api.services.speech.v1beta1.model.SyncRecognizeResponse;

import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class MainActivity extends AppCompatActivity {


    private final String CLOUD_API_KEY = "AIzaSyAVMEYWaz8k_LR2aCKh60fNHaNc6qq8_Mc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button browseButton = (Button) findViewById(R.id.browse_button);

        browseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent file = new Intent(Intent.ACTION_GET_CONTENT);
                file.setType("audio/flac");
                startActivityForResult(file, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            final Uri soundUri = data.getData();
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    InputStream stream = null;
                    try {
                        stream = getContentResolver()
                                .openInputStream(soundUri);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    byte[] audioData = new byte[0];

                    try {
                        audioData = IOUtils.toByteArray(stream);
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    String base64EncodedData =
                            Base64.encodeBase64String(audioData);
                    MediaPlayer player = new MediaPlayer();
                    try {

                        player.setDataSource(MainActivity.this, soundUri);
                        player.prepare();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    player.start();

// Release the player
                    player.setOnCompletionListener(
                            new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    mediaPlayer.release();
                                }
                            });

                    Speech speechService = new Speech.Builder(
                            AndroidHttp.newCompatibleTransport(),
                            new AndroidJsonFactory(),
                            null
                    ).setSpeechRequestInitializer(
                            new SpeechRequestInitializer(CLOUD_API_KEY))
                            .build();

                    //Set the language english
                    RecognitionConfig recognitionConfig = new RecognitionConfig();
                    recognitionConfig.setLanguageCode("en-US");

                    RecognitionAudio recognitionAudio = new RecognitionAudio();
                    recognitionAudio.setContent(base64EncodedData);

                    // Create request
                    SyncRecognizeRequest request = new SyncRecognizeRequest();
                    request.setConfig(recognitionConfig);
                    request.setAudio(recognitionAudio);

// Generate response
                    SyncRecognizeResponse response = null;
                    try {
                        response = speechService.speech()
                                .syncrecognize(request)
                                .execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

// Extract transcript
                    SpeechRecognitionResult result = response.getResults().get(0);
                    final String transcript = result.getAlternatives().get(0)
                            .getTranscript();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TextView speechToTextResult =
                                    (TextView)findViewById(R.id.speech_result);
                            speechToTextResult.setText(transcript);
                        }
                    });
                }

            });
        }

    }
}
