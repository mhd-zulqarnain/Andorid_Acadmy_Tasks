package com.example.zulqarnain.valutest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zulqarnain.valutest.R;
import com.example.zulqarnain.valutest.model.Demo;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 10/12/2017.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.testHolder> {

    private CallBack callback;
    private ArrayList<Demo> list;

    public TestAdapter(ArrayList<Demo> detailList) {
        this.list=detailList;

    }


    @Override
    public testHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.single_row_view,parent,false);
        testHolder holder = new testHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(testHolder holder, int position) {
        Demo demo = list.get(position);
        holder.bindView(demo);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class testHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView name;
        private ImageButton rButton;
        private View itemView;
        private Demo mDemo;

        public testHolder(View itemView) {

            super(itemView);
            name = itemView.findViewById(R.id.std_name);
            rButton = itemView.findViewById(R.id.btn_dlt);
            rButton.setOnClickListener(this);
        }

        public void bindView(Demo mDemo) {
            this.mDemo = mDemo;
            name.setText(mDemo.getKey());
        }

        @Override
        public void onClick(View view) {
            String key = mDemo.getKey();
              callback.methodcallback(key);
        }
    }
}
