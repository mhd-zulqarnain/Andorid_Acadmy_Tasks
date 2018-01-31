package com.example.zulup.onswipdelete;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zulup.onswipdelete.adapter.StudentAdapter;
import com.example.zulup.onswipdelete.model.Student;

import java.util.ArrayList;

public class DaimajiaActivity extends AppCompatActivity {

    private ArrayList<Student> stdList;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_custom_swip);
        mRecyclerView  = findViewById(R.id.recycler_view);
        stdList =new ArrayList<>();
        updateUi();
    }

    private void updateUi() {
        stdList.add(new Student("test1"));
        stdList.add(new Student("test2"));
        stdList.add(new Student("test3"));
        stdList.add(new Student("test4"));
        stdList.add(new Student("test5"));

        DividerItemDecoration itemDecorator = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider));

        mRecyclerView.addItemDecoration(itemDecorator);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        StudentAdapter adapter = new StudentAdapter(stdList,this);
        mRecyclerView.setAdapter(adapter);
    }
}
