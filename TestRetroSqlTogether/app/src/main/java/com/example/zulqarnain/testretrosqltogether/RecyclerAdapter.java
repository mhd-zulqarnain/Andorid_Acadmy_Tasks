package com.example.zulqarnain.testretrosqltogether;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 9/19/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder> {

    ArrayList<ShopProduct> mList;
    RecyclerAdapter(ArrayList<ShopProduct> list){

        mList=list;
    }
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        viewHolder holder = new viewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        ShopProduct shopProduct = (ShopProduct) mList.get(position);
        holder.textView.setText(  shopProduct.getName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class viewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public viewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}
