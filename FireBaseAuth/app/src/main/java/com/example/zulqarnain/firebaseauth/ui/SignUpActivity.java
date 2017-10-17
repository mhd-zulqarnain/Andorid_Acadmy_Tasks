package com.example.zulqarnain.firebaseauth.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.zulqarnain.firebaseauth.Messege;
import com.example.zulqarnain.firebaseauth.R;
import com.example.zulqarnain.firebaseauth.Validation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText edEmail;
    private EditText edPassword;
    private Button btnSignup;
    private ProgressBar barProgress;
    private FirebaseAuth firebase;
    private  final static  String TAG="com.tag.auth";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edEmail = (EditText) findViewById(R.id.email);
        edPassword = (EditText) findViewById(R.id.password);
        btnSignup = (Button) findViewById(R.id.email_sign_up_button);
        barProgress = (ProgressBar) findViewById(R.id.signup_progress);

        firebase = FirebaseAuth.getInstance();
    }

    public void SignUp(View view) {
        String email = edEmail.getText().toString();
        String pass = edPassword.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
            Messege.messege(SignUpActivity.this, "Enter your email and password");
            return;
        }
        if(!Validation.emailValidate(email)){
            Messege.messege(SignUpActivity.this, "invalid email!!");
            return;
        }
        if(pass.length()<6){
            Messege.messege(SignUpActivity.this, "Password should contain 6 characters");
            return;
        }
        barProgress.setVisibility(View.VISIBLE);

        firebase.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        barProgress.setVisibility(View.GONE);

                        if (!task.isSuccessful()) {
                            Messege.messege(SignUpActivity.this,"Failed"+task.getException());
                            Log.d(TAG, "createUserWithEmail:onComplete:" + task.getException());
                        }
                        else {
                            Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }

                    }
                });

    }
    public void SignIn(View v){
        startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
    }

    @Override
    public void onResume() {
        super.onResume();
        if(firebase.getCurrentUser()!=null){
            startActivity(new Intent(SignUpActivity.this,MainActivity.class));
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if(firebase.getCurrentUser()!=null){
            startActivity(new Intent(SignUpActivity.this,MainActivity.class));

        }
    }
}
