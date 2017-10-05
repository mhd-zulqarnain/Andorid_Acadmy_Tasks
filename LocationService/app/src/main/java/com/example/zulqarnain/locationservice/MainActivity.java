package com.example.zulqarnain.locationservice;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button mBtnService;
    private static final int MY_PERMISSIONS_LOCATION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        mBtnService = (Button) findViewById(R.id.btnStart);
        askPermisssion(Manifest.permission.ACCESS_FINE_LOCATION ,MY_PERMISSIONS_LOCATION);

       ApiInterface apiInterface = ApiClint.getApiClint().create(ApiInterface.class);
        Call<List<Person>> call = apiInterface.getInfo();
         call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                /*ArrayList<Person> info = (ArrayList<Person>) response.body();
                Person person = info.get(0);
                Log.d("log", "onResponse: " + person.uid);
                Toast.makeText(MainActivity.this, "the data is" + person.uid, Toast.LENGTH_LONG).show();
                textView.setText(info.get(0).latitude.toString());
                textView.setText(" " + info.get(1).latitude.toString());*/

            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "the data is" + t, Toast.LENGTH_LONG).show();

            }
        });
    }

    public void startSevice(View v) {
        Intent intent = new Intent(this, MyTestService.class);
        startService(intent);
    }

    public void askPermisssion(String permission ,int requestCode){
        if(ContextCompat.checkSelfPermission(this,permission)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{permission},requestCode);
        }
        else {

            Log.d("TAG", "askPermisssion:permission denied ");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case MY_PERMISSIONS_LOCATION:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                    Messege.messege(MainActivity.this,"Permission granted");
            default:
                Messege.messege(MainActivity.this,"Application would not work properly");
        }
    }
}
