package com.example.zulqarnain.longtitude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);

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
}
