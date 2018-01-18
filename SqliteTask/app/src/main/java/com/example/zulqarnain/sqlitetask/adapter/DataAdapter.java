package com.example.zulqarnain.sqlitetask.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.zulqarnain.sqlitetask.model.Student;
import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataHolder> {
    ArrayList<Student> list;
    Context context;
    public DataAdapter(Context context,ArrayList<Student> list){
        this.list=list;
        this.context=context;
    }
    @Override
    public DataAdapter.DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_expandable_list_item_1,parent,false);
        DataHolder holder = new DataHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DataAdapter.DataHolder holder, int position) {
        Student model= list.get(position);
        holder.textView.setText( model.id + ":" + " Name: " + model.getmName() + " CLass: " + model.getmClass() );
        Log.d("data", "onBindViewHolder: "+model.id + ":" + " Name: " + model.getmName() + " CLass: " + model.getmClass());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class DataHolder extends RecyclerView.ViewHolder{
        TextView textView ;
        public DataHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}
