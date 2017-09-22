package com.example.zulqarnain.locationservice;

import android.content.Intent;
import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        mBtnService= (Button) findViewById(R.id.btnStart);


//        startService(new Intent(this, MyService.class));
        ApiInterface apiInterface= ApiClint.getApiClint().create(ApiInterface.class);
        Call<List<Person>> call = apiInterface.getInfo();
        call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                ArrayList<Person> info= (ArrayList<Person>) response.body();
                Person person = info.get(0);
                Log.d("log", "onResponse: "+person.uid);
                Toast.makeText(MainActivity.this,"the data is"+person.uid,Toast.LENGTH_LONG).show();
                textView.setText(info.get(0).latitude.toString());
                textView.setText(" "+info.get(1).latitude.toString());

            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"the data is"+t,Toast.LENGTH_LONG).show();

            }
        });
      /*  call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                ArrayList<Person> list= (ArrayList<ShopProduct>) response.body();
                ShopProduct prd =list.get(0);
                long id=helper.insert(prd.id,prd.name,prd.price);
//                Toast.makeText(MainActivity.this,"the data response is "+id,Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<List<ShopProduct>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"failed "+t,Toast.LENGTH_LONG).show();

            }
        });*/
    }
    public void startSevice(View v){
        Intent intent = new Intent(MainActivity.this, MyTestService.class);
        startActivity(intent);
    }
}
