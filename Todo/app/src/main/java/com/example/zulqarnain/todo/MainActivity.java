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
    ArrayList<Student> mDetails;
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
        /*recyclerView = (RecyclerView) findViewById(R.id.recyler_view);
        mDetails = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDatabase = FirebaseDatabase.getInstance().getReference();
        populateData();
        adapter = new StudentAdapter(MainActivity.this,mDetails);
        recyclerView.setAdapter(adapter);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("", "onDataChange: ");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
/*        mDatabase.addChildEventListener(new ChildEventListener(){
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Student model =snapshot.getValue(Student.class);
                    model.setKey(snapshot.getKey());
                    mDetails.add(model);
                    adapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
    }

    private void populateData() {
        for(int i =1;i<4;i++){
            Student student = new Student(" tes "+i," sd "+i," key" +i);
            mDetails.add(student);
        }
        adapter = new StudentAdapter(MainActivity.this,mDetails);
        recyclerView.setAdapter(adapter);
    }

    public void pushData(View v){
        Log.d("tad", "pushData: ");
        for(Student model:mDetails){
            mDatabase.child("student").push().setValue(model);
        }
    }

    @Override
    public void methodcallback(String args) {
        Log.d("", "methodcallback: "+args);
    }
}
