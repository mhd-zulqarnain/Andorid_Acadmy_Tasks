package com.example.zulqarnain.dynamicview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    LinearLayout dParent;
    LayoutInflater inflater;
    EditText count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dParent = (LinearLayout) findViewById(R.id.dynamic_view_holder);
        inflater = LayoutInflater.from(this);
        count= (EditText) findViewById(R.id.ed_value_count);
    }

    public void populateView(View v){

        int index = Integer.valueOf(count.getText().toString());
        if(index==0)
            return;
        for(int i=0;i<index;i++){
           View view=inflater.inflate(R.layout.single_view,null);
            TextView tv =view.findViewById(R.id.text_view);
            tv.setText("twxr"+i);
            dParent.addView(view);
        }
    }
}
