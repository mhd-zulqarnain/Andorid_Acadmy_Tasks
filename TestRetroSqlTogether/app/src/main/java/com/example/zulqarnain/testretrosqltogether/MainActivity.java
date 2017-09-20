package com.example.zulqarnain.testretrosqltogether;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.zulqarnain.testretrosqltogether.database.DbHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    DbHelper helper;
    private ArrayList<ShopProduct> mProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        helper = new DbHelper(this);
        getData();
        ApiInterface apiInterface = ApiClint.getApiClint().create(ApiInterface.class);
        Call<List<ShopProduct>> call = apiInterface.getProduts();
        call.enqueue(new Callback<List<ShopProduct>>() {
            @Override
            public void onResponse(Call<List<ShopProduct>> call, Response<List<ShopProduct>> response) {
                ArrayList<ShopProduct> list = (ArrayList<ShopProduct>) response.body();
                ShopProduct shopProduct = list.get(0);
                Long id = helper.insert(shopProduct.id,shopProduct.getName(),shopProduct.price);
            }

            @Override
            public void onFailure(Call<List<ShopProduct>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed " + t, Toast.LENGTH_LONG).show();

            }
        });
    }


    public void getData() {
        mProducts = helper.getProducts();
        Message.message(MainActivity.this,"the size is "+mProducts.size());
        /*if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                ShopProduct prd = list.get(i);
                mProducts.add(list.get(i));
                long id = helper.insert(prd.id, prd.name, prd.price);
            }
        }*/

    }
}
