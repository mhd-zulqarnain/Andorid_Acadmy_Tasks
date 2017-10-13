package com.example.zulqarnain.todo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zulqarnain.todo.Messege;
import com.example.zulqarnain.todo.R;
import com.example.zulqarnain.todo.adapters.TaskAdapter;
import com.example.zulqarnain.todo.model.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Key;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Zul Qarnain on 10/11/2017.
 */

public class TaskFragent extends Fragment implements View.OnClickListener ,View.OnKeyListener{
    private DatabaseReference mDatabase;
    ArrayList<Task> mDetails;
    RecyclerView recyclerView;
    TaskAdapter adapter;
    EditText edName;
    Button btnPush;
    private final String TAG = "com.tab";

    public static Fragment newInstance() {
        return new TaskFragent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.task_fragment_view, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyler_view);
        edName = (EditText) view.findViewById(R.id.ed_std_name);
        btnPush = view.findViewById(R.id.btn_push);
        btnPush.setOnClickListener(this);
        mDetails = new ArrayList<>();
        edName.setOnKeyListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mDatabase = FirebaseDatabase.getInstance().getReference("Task");
        populateData();

        return view;
    }

    private void populateData() {
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Task model = dataSnapshot.getValue(Task.class);
                model.setKey(dataSnapshot.getKey());
                mDetails.add(model);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Task st = dataSnapshot.getValue(Task.class);
                int index = getItemIndex(dataSnapshot.getKey().toString());
                Log.d(TAG, "onChildChanged: " + index);
                mDetails.set(index, st);
                adapter.notifyItemChanged(index);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Task st = dataSnapshot.getValue(Task.class);
                int index = getItemIndex(dataSnapshot.getKey().toString());
                mDetails.remove(index);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        adapter = new TaskAdapter(getContext(), mDetails);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

        String name = edName.getText().toString();
        if(TextUtils.isEmpty(name)){
            Messege.messege(getContext(),"Fill the field");
            return;
        }
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Task");
        String key = String.valueOf(mDatabase.push().getKey());
        Task Task = new Task(name, key);
        mDatabase.child(key).setValue(Task);
        edName.setText("");
    }

    public int getItemIndex(String key) {
        int index = -1;
        for (int i = 0; i < mDetails.size(); i++) {
            if (mDetails.get(i).getKey().equals(key)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_ENTER &&(event.getAction() == KeyEvent.ACTION_DOWN) ){

            String name = edName.getText().toString();
            if(TextUtils.isEmpty(name)){
                Messege.messege(getContext(),"Fill the field");
                return false;
            }
            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Task");
            String key = String.valueOf(mDatabase.push().getKey());
            Task Task = new Task(name, key);
            mDatabase.child(key).setValue(Task);
            edName.setText("");
            return  true;
        }
        return false;
    }
}
