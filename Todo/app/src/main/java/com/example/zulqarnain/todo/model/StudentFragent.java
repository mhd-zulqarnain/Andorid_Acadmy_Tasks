package com.example.zulqarnain.todo.model;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zulqarnain.todo.MainActivity;
import com.example.zulqarnain.todo.R;
import com.example.zulqarnain.todo.adapters.StudentAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 10/11/2017.
 */

public class StudentFragent extends Fragment {
    private DatabaseReference mDatabase;
    ArrayList<Student> mDetails;
    RecyclerView recyclerView;
    StudentAdapter adapter;


    public static Fragment newInstance()
    {
        return new StudentFragent();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.student_fragment_view,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyler_view);
        mDetails = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mDatabase = FirebaseDatabase.getInstance().getReference();
        populateData();
        adapter = new StudentAdapter(getContext(),mDetails);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void populateData() {
        for(int i =1;i<4;i++){
            Student student = new Student(" tes "+i," sd "+i," key" +i);
            mDetails.add(student);
        }
        adapter = new StudentAdapter(getContext(),mDetails);
        recyclerView.setAdapter(adapter);
    }
}
