package com.example.zulqarnain.sqlretrosecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zulqarnain.sqlretrosecond.Model.ShopProducts;
import com.example.zulqarnain.sqlretrosecond.Utilities.ApiClint;
import com.example.zulqarnain.sqlretrosecond.Utilities.ApiInterface;
import com.example.zulqarnain.sqlretrosecond.database.ShopDbHelper;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ShopDbHelper shopDbHelper;
    private TextView textView;
    private Button mInsert;
    private Button mShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.product_view);
        mShow = (Button) findViewById(R.id.get_product);
        mInsert = (Button) findViewById(R.id.insert_product);

        shopDbHelper = new ShopDbHelper(this);

        mShow.setOnClickListener(this);
        mInsert.setOnClickListener(this);
        synData();

    }

    public boolean isDuplicate(ShopProducts shopProducts) {
        ArrayList<ShopProducts> p_list = shopDbHelper.getAllProducts();
        for (ShopProducts model : p_list) {
            if (model.product_id == shopProducts.product_id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.insert_product){
            ShopProducts shopProducts =new ShopProducts(21, "proudct 2", 12);
            if(!isDuplicate(shopProducts))
            {
            long i = shopDbHelper.insert(shopProducts);
            Message.message(this, "the response " + i);
            }
            Message.message(this, "duplicated " );
            synData();

        }else {
            ArrayList<ShopProducts> shopProducts =shopDbHelper.getAllProducts();
            for(ShopProducts list:shopProducts){
                textView.setText(textView.getText().toString()+list.product_name+" \n");
            }

        }
    }

    private void synData() {

                ApiInterface apiClint = ApiClint.getApiClint().create(ApiInterface.class);
                Call<ArrayList<ShopProducts>> call= apiClint.getProduts();
                call.enqueue(new Callback<ArrayList<ShopProducts>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ShopProducts>> call, Response<ArrayList<ShopProducts>> response) {
                        ArrayList<ShopProducts> list= response.body();
                        for(ShopProducts model:list){
                            if(!isDuplicate(model)){
                                shopDbHelper.insert(model);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<ShopProducts>> call, Throwable t) {
                        Message.message(MainActivity.this,"Caught error"+t);
                    }
                });
            }
}
