package zee.example.com.socialapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import zee.example.com.socialapp.R;
import zee.example.com.socialapp.ui.util.Messege;
import zee.example.com.socialapp.ui.util.Validation;


public class LoginActivity extends AppCompatActivity {

    private EditText edPss;
    private EditText edEm;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        edEm= findViewById(R.id.ed_email);
        edPss= findViewById(R.id.ed_pas);
        auth = FirebaseAuth.getInstance();

    }

    public void signup(View view){
        Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
        startActivity(intent);
    }
    public void login(View v){
        String email= edEm.getText().toString();
        String pass= edPss.getText().toString();



        if (TextUtils.isEmpty(email) || !Validation.isEmailValid(email)) {
            Messege.messege(getBaseContext(), "Invalid email");
            return;
        }
        if (TextUtils.isEmpty(pass) || TextUtils.getTrimmedLength(pass) < 6) {
            Messege.messege(getBaseContext(), "invalid password");
            return;
        }
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Messege.messege(getApplicationContext(),"Success");
            }
        });


    }
}
