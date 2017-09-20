package com.example.zulqarnain.sqlretrosecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zulqarnain.sqlretrosecond.Model.ShopProducts;
import com.example.zulqarnain.sqlretrosecond.database.ShopDbHelper;

import java.util.ArrayList;

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


        }else {
            ArrayList<ShopProducts> shopProducts =shopDbHelper.getAllProducts();
            for(ShopProducts list:shopProducts){
                textView.setText(textView.getText().toString()+list.product_name+" \n");
            }

        }
    }
}
