package com.example.zulqarnain.todo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.zulqarnain.todo.R;
import com.example.zulqarnain.todo.adapters.AdapterCallBack;
import com.example.zulqarnain.todo.adapters.StudentAdapter;
import com.example.zulqarnain.todo.model.Student;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Zul Qarnain on 10/11/2017.
 */

public class StudentFragent extends Fragment implements AdapterCallBack,View.OnClickListener {
    private DatabaseReference mDatabase;
    ArrayList<Student> mDetails;
    RecyclerView recyclerView;
    StudentAdapter adapter;
    EditText edName;
    Button btnPush;
    private final  String TAG ="com.tab";
    public static Fragment newInstance()
    {
        return new StudentFragent();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.student_fragment_view,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyler_view);
        edName = (EditText) view.findViewById(R.id.ed_std_name);
        btnPush =view.findViewById(R.id.btn_push);
        btnPush.setOnClickListener(this);

        mDetails = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mDatabase = FirebaseDatabase.getInstance().getReference();
        populateData();

        adapter.setAdapterCallback(StudentFragent.this);
        return view;
    }

    private void populateData() {
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d(TAG, "onDataChange: "+dataSnapshot.toString());
                for(DataSnapshot snap:dataSnapshot.getChildren()){
                    Student model = snap.getValue(Student.class);
                    model.setKey(snap.getKey());
                    Log.d(TAG, "onChildAdded: "+model);
                    mDetails.add(model);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        adapter = new StudentAdapter(getContext(),mDetails);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void methodcallback(String key) {
        Log.d("", "methodcallback: "+key);
        DatabaseReference db=FirebaseDatabase.getInstance().getReference("student");
        for(int i=0;i<mDetails.size();i++){
            Student model = mDetails.get(i);
            if(model.getKey().equals(key)){
                db.child(key).removeValue();
                mDetails.remove(i);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onClick(View view) {
        UUID randkey=UUID.randomUUID();
        String key = randkey.toString();

        String name = edName.getText().toString();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("student");
        Student student = new Student(name, key);

        mDatabase.child(key).setValue(student);
        mDetails.add(student);
        adapter.notifyDataSetChanged();
    }
}
