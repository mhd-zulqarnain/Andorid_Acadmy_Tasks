package com.example.zulqarnain.todo;

import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.zulqarnain.todo.adapters.AdapterCallBack;
import com.example.zulqarnain.todo.adapters.StudentAdapter;
import com.example.zulqarnain.todo.model.Student;
import com.example.zulqarnain.todo.model.StudentFragent;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterCallBack {
    private DatabaseReference mDatabase;
    RecyclerView recyclerView;
    StudentAdapter adapter;

    final static String TAG="tag.value";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager= getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_holder);

        if(fragment == null){
            fragment = StudentFragent.newInstance();
            manager.beginTransaction().add(R.id.fragment_holder,fragment).commit();
        }
    }

    public void pushData(View v){
        ArrayList<Student> mDataforFireBase=new ArrayList<>();
        mDatabase=FirebaseDatabase.getInstance().getReference();
        for(int i =1;i<4;i++){
            Student student = new Student(" tes "+i," sd "+i," key" +i);
            mDataforFireBase.add(student);
        }
        Log.d("tad", "pushData: ");
        for(Student model: mDataforFireBase){
            mDatabase.child("student").push().setValue(model);
        }
    }

    @Override
    public void methodcallback(String key) {


    }
}
