package zee.example.com.socialapp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.HashMap;

import zee.example.com.socialapp.R;
import zee.example.com.socialapp.ui.util.Messege;
import zee.example.com.socialapp.ui.util.Validation;


public class SignupActivity extends AppCompatActivity {

    private EditText edPass;
    private EditText conPass;
    private EditText edEmail;
    ProgressBar progressBar;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        auth  = FirebaseAuth.getInstance();
        edEmail= findViewById(R.id.ed_email);
        edPass= findViewById(R.id.ed_pas);
        conPass= findViewById(R.id.ed_confrm_pass);
        progressBar =new ProgressBar(this);
    }
    public void signUp(View v) {
        String email = edEmail.getText().toString();
        String pass = edPass.getText().toString();
        String confass = conPass.getText().toString();
        if (TextUtils.isEmpty(email) || !Validation.isEmailValid(email)) {
            Messege.messege(getBaseContext(), "Invalid email");
            return;
        }
        if (TextUtils.isEmpty(pass) || TextUtils.getTrimmedLength(pass) < 6 && pass.equals(confass)) {
            Messege.messege(getBaseContext(), "invalid password or password not same");
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.GONE);
                           // mKey = auth.getCurrentUser().getUid().toString();
                            HashMap<String, String> user = new HashMap<String, String>();
                            /*user.put("uid", mKey);
                            user.put("type", uType);
                            user.put("disabled","false");
                            mDatabase.child(mKey).setValue(user);*/
                            //inserting name
                            /*UserProfileChangeRequest profileName = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(name).build();
                            auth.getCurrentUser().updateProfile(profileName);*/
                            Messege.messege(getBaseContext(), "Successfully signed up");


                        } else {
                            progressBar.setVisibility(View.GONE);
                            Messege.messege(getBaseContext(), "Failed");
                        }

                        // ...
                    }
                });
    }

}
