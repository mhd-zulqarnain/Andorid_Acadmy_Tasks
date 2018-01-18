package com.example.zulqarnain.firedemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.zulqarnain.firedemo.R;
import com.example.zulqarnain.firedemo.model.Student;
import com.example.zulqarnain.firedemo.model.StudentItemListener;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 10/29/2017.
 */

public class CustomAdapter extends ArrayAdapter<Student> {

    StudentItemListener editStudent,delStudent;
    ArrayList<Student> students;

    public CustomAdapter(Context context, ArrayList<Student> students, StudentItemListener editStudent, StudentItemListener delStudent) {
        super(context,0,students);
        this.students=students;
        this.editStudent=editStudent;
        this.delStudent=delStudent;
    }

    @Override
    public View getView(int position, @Nullable View itemView, @NonNull ViewGroup parent) {
        if(itemView==null){
            itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.student_view,parent,false);
        }
        TextView tvName = (TextView) itemView.findViewById(R.id.tvName);
        TextView tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
        TextView tvPhone = (TextView) itemView.findViewById(R.id.tvPhone);
        TextView tvAge = (TextView) itemView.findViewById(R.id.tvAge);
        Button btnDel = (Button) itemView.findViewById(R.id.btnDel);
        final Button edit = (Button) itemView.findViewById(R.id.btnEdit);

        final Student  student = students.get(position);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delStudent.onData(student);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editStudent.onData(student);
            }
        });
        return itemView;
    }
}
