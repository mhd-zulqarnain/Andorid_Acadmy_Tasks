package com.example.zulqarnain.multiselectdemo;

import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 10/3/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyHolder> {
    ArrayList<Student> list;
    private SparseBooleanArray selectedItems;
    private static ClickListener clickListener;
    public StudentAdapter(ArrayList<Student> list){
        this.list=list;
        if (list == null) {
            throw new IllegalArgumentException("modelData must not be null");
        }
        selectedItems = new SparseBooleanArray();
    }

    public void addData(Student model,int position){
        list.add(position,model);
        notifyItemChanged(position);
    }
    public void removeData(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public int getSelectedItemCount() {
        return selectedItems.size();
    }
    public Student getItem(int position) {
        return list.get(position);
    }

//---------------Selection of items----------------
    public void toggleSelection(int pos){
        if(selectedItems.get(pos,false)){
            selectedItems.delete(pos);
        }
        else
            selectedItems.put(pos,true);
        notifyItemChanged(pos);
    }
    public void clearSelections() {
        selectedItems.clear();
        notifyDataSetChanged();
    }
    public ArrayList<Integer> getSelectedItem(){
        ArrayList<Integer> item= new ArrayList<>(selectedItems.size());
        for(int i=0 ;i<selectedItems.size();i++){
            item.add(selectedItems.keyAt(i));
        }
        return item;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_expandable_list_item_1,parent,false);
        MyHolder holder =new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.textView.setText(list.get(position).name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            textView = (TextView) itemView;
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        StudentAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }
}
