package com.example.zulqarnain.todo.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.zulqarnain.todo.R;
import com.example.zulqarnain.todo.adapters.AdapterCallBack;
import com.example.zulqarnain.todo.adapters.StudentAdapter;
import com.example.zulqarnain.todo.model.Student;
import com.example.zulqarnain.todo.ui.StudentFragent;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "tag.value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_holder);

        if (fragment == null) {
            fragment = StudentFragent.newInstance();
            manager.beginTransaction().add(R.id.fragment_holder, fragment).commit();
        }
    }

   /* public void pushData(View v) {
        String name = edName.getText().toString();

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        Student student = new Student(name, " key");
        mDatabase.child("student").push().setValue(student);
//        Log.d("tad", "pushData: ");

    }*/


}
