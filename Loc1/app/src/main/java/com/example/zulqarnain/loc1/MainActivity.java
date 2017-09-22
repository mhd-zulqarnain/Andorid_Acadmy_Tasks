package com.example.zulqarnain.loc1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button mBtnService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent("com.sample.service.serviceClass");
        this.startService(intent);
        textView = (TextView) findViewById(R.id.text);
        mBtnService= (Button) findViewById(R.id.btnStart);
    }
    public void startSevice(View v){
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
        Log.d("called", "start"+intent);

    }

}
