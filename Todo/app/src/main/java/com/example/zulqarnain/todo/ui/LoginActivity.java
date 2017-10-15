package com.example.zulqarnain.todo.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.zulqarnain.todo.Messege;
import com.example.zulqarnain.todo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText edEmail;
    private EditText edPassword;
    private ProgressBar barProgress;
    private FirebaseAuth firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edEmail = (EditText) findViewById(R.id.ed_email);
        edPassword = (EditText) findViewById(R.id.ed_password);
        barProgress = (ProgressBar) findViewById(R.id.progress_bar);

        firebase= FirebaseAuth.getInstance();

        if(firebase.getCurrentUser()!=null){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }
    }


    public void signin(View view){
        String email= edEmail.getText().toString();
        String pass= edPassword.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
            Messege.messege(LoginActivity.this, "Enter your email and password");
            return;
        }
        if(pass.length()<6){
            Messege.messege(LoginActivity.this, "Password should contain 6 characters");
            return;
        }

        barProgress.setVisibility(View.VISIBLE);

        firebase.signInWithEmailAndPassword(email,pass).addOnCompleteListener(
                LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        barProgress.setVisibility(View.GONE);

                        if(!task.isSuccessful()){
                            Messege.messege(LoginActivity.this,"Record not found");
                        }
                        else{
                            Messege.messege(LoginActivity.this,"Successfully login ");
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));}
                    }
                }
        );
    }
    public void signup(View view){
        startActivity(new Intent(LoginActivity.this,SignupActivity.class));

    }
}
