package com.example.zulqarnain.functiondemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().subscribeToTopic("android");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        updateUi();
        final EditText titleEditText = (EditText) findViewById(R.id.et_title);
        final EditText authorEditText = (EditText) findViewById(R.id.et_author);
        Button submitButton = (Button) findViewById(R.id.btn_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference myRef = database.getReference("articles").push();
                Article article = new Article(titleEditText.getText().toString(),
                        authorEditText.getText().toString());
                myRef.setValue(article);
            }
        });
    }

    public void updateUi() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword("a@g.com", "111111")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
                            String key = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users").child(key).child("token");
                            ref.setValue(refreshedToken);

                        } else {
                            Toast.makeText(getBaseContext(), "failed to login", Toast.LENGTH_LONG).show();
                        }

                    }
                });

        FirebaseInstanceId.getInstance().getToken();


    }


}
