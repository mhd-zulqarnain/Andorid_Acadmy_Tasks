package com.example.zulqarnain.suuetrecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zul Qarnain on 8/3/2017.
 */

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.StudentViewHolder> {

    List<Student> studentList;
    CustomRecyclerAdapter(List<Student> list){
        this.studentList = list;
    }

    @Override
    public CustomRecyclerAdapter.StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        StudentViewHolder studentViewHolder= new StudentViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false));

        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomRecyclerAdapter.StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.mTitleTextView.setText(student.getName());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }



    public class StudentViewHolder extends RecyclerView.ViewHolder{

        TextView mTitleTextView;
        StudentViewHolder(View itemView){
            super(itemView);
            mTitleTextView = (TextView)itemView;

        }
    }
}
