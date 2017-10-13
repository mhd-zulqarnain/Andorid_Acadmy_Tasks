package com.example.zulqarnain.valutest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.zulqarnain.valutest.R;
import com.example.zulqarnain.valutest.adapter.TestAdapter;
import com.example.zulqarnain.valutest.model.Demo;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Zul Qarnain on 10/12/2017.
 */

public class TestFragement extends Fragment implements View.OnClickListener{

    private DatabaseReference fdb;
    ArrayList<Demo> detailList;
    RecyclerView recyclerView;
    EditText edName;
    Button btnPush;
    TestAdapter adapter;

    private  final String TAG="tag";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_view,container,false);
        recyclerView = view.findViewById(R.id.recyler_view);
        edName = (EditText) view.findViewById(R.id.ed_std_name);
        btnPush =view.findViewById(R.id.btn_push);
        btnPush.setOnClickListener(this);
        fdb = FirebaseDatabase.getInstance().getReference("Task");
        populateData();
        detailList = new ArrayList<>();

        return view;
    }

    private void populateData() {
        fdb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d(TAG, "onDataChange: " + dataSnapshot);

                Demo model = dataSnapshot.getValue(Demo.class);
                model.setKey(dataSnapshot.getKey());
                detailList.add(model);

                adapter.notifyDataSetChanged();
                Log.d(TAG, "onChildAdded:called");

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
        });
        adapter = new TestAdapter(detailList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        UUID randkey=UUID.randomUUID();
        String key = randkey.toString();
        String name = edName.getText().toString();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Task");
        Demo demo = new Demo(name, key);
        mDatabase.child(key).setValue(demo);

        edName.setText("");

    }
    public int getItemIndex(Demo demo){
        int index=-1;
        for(int i =0 ;i<detailList.size();i++){
            if(detailList.get(i).getKey().equals(demo.getKey())){
                index = i;
                break;
            }
        }
        return index;
    }
}
