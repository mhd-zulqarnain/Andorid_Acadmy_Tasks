package com.example.zulqarnain.todo.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.zulqarnain.todo.Messege;
import com.example.zulqarnain.todo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    FirebaseAuth auth;
    private EditText edEmail;
    private EditText edPass;
    private ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        auth  = FirebaseAuth.getInstance();
        edEmail= (EditText) findViewById(R.id.ed_email);
        edPass= (EditText) findViewById(R.id.ed_password);
        bar= (ProgressBar) findViewById(R.id.progress_bar);

        if(auth.getCurrentUser()!=null){
            startActivity(new Intent(SignupActivity.this, MainActivity.class));
        }
    }

    public void signUp(View view){
        String email = edEmail.getText().toString();
        String pass = edPass.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
            Messege.messege(SignupActivity.this, "Enter your email and password");
            return;
        }
        if(pass.length()<6){
            Messege.messege(SignupActivity.this, "Password should contain 6 characters");
            return;
        }
        bar.setVisibility(View.VISIBLE);
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(
                SignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        bar.setVisibility(View.GONE);

                        if (!task.isSuccessful()) {
                            Messege.messege(SignupActivity.this, "Record not found");
                        } else {
                            Messege.messege(SignupActivity.this, "Successfully login ");
                            startActivity(new Intent(SignupActivity.this, MainActivity.class));
                        }
                    }
                }
    );
    }
    public void signin(View v){
        startActivity(new Intent(SignupActivity.this,LoginActivity.class));
    }

}
