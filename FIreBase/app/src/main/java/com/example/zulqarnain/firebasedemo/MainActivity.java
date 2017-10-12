package com.example.zulqarnain.firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private ListView mList;
    EditText edName;

    ArrayList<String> mDetails;
    ArrayList<String> mKeys;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mList = findViewById(R.id.list_details);
        edName = findViewById(R.id.edName);
        mDetails = new ArrayList<>();
        mKeys= new ArrayList<>();

        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,mDetails);

        mList.setAdapter(adapter);
        mDatabase.addChildEventListener(new ChildEventListener(){
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value=dataSnapshot.getValue(String.class);
                mDetails.add(value);
                String key= dataSnapshot.getKey();
                mKeys.add(key);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String val=dataSnapshot.getValue(String.class);
                String key=dataSnapshot.getKey();
                int index=  mKeys.indexOf(key);
                mDetails.set(index,val);
                    adapter.notifyDataSetChanged();
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

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String key = mKeys.get(i).toString();
                mDatabase.child(key).removeValue();
                mDetails.remove(i);
                mKeys.remove(i);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void putData(View v) {

        String task = edName.getText().toString();
        mDatabase.push().setValue(task);
    }

}

