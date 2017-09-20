package com.example.zulqarnain.retropractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText stName;
    EditText stEmail;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stName = (EditText) findViewById(R.id.std_name);
        stEmail = (EditText) findViewById(R.id.std_email);
        mButton = (Button)findViewById(R.id.submit_button);
        mButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String name,email;
        name=stName.getText().toString();
        email=stEmail.getText().toString();

        ApiInterface apiInterface =ApiClint.getApiClint().create(ApiInterface.class);
        Call<Student> call = apiInterface.updateRecord(name,email);
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                Student student = response.body();
                Toast.makeText(MainActivity.this,"The Status is: "+ student.getResponse(),Toast.LENGTH_LONG).show();
                stEmail.setText("");
                stName.setText("");
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Toast.makeText(MainActivity.this,"The Status is:FAILED "+t,Toast.LENGTH_LONG).show();
            }
        });
    }
}

