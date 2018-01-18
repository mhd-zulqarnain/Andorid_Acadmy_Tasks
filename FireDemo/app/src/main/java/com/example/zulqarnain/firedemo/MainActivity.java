package com.example.zulqarnain.firedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.zulqarnain.firedemo.adapter.CustomAdapter;
import com.example.zulqarnain.firedemo.model.Student;
import com.example.zulqarnain.firedemo.model.StudentItemListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etEmail ;
    private EditText etPhone;
    private EditText etAge;
    private String editId;

    DatabaseReference ref;
    ArrayList<Student> students;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ref = FirebaseDatabase.getInstance().getReference("students");
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAge = (EditText) findViewById(R.id.etAge);

        listView = (ListView) findViewById(R.id.myStudentsList);
        students = new ArrayList<>();
        upDateUi();
    }

    private void upDateUi() {
        final CustomAdapter adapter = new CustomAdapter(this, students, new StudentItemListener() {
            @Override
            public void onData(Student s) {

            }

        }, new StudentItemListener() {
            @Override
            public void onData(Student student) {
                etName.setText(student.getName());
                etEmail.setText(student.getEmail());
                etPhone.setText(student.getPhone());
                etAge.setText(String.valueOf(student.getAge()));
                editId = student.getKey();
            }
        });

        listView.setAdapter(adapter);
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("", "onChildAdded: "+dataSnapshot);
                Student st= dataSnapshot.getValue(Student.class);
                students.add(st);
                adapter.notifyDataSetChanged();
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

    }

    public void addStudent(View v) {

        Student st = new Student(etName.getText().toString(), etEmail.getText().toString(), etPhone.getText().toString(), Integer.valueOf(etAge.getText().toString()));

        if (TextUtils.isEmpty(editId)) {
            String key = ref.push().getKey();
            st.setKey(key);
            ref.child(key).setValue(st);
            Log.d("", "addStudent: "+key);
        } else {
            st.setKey(editId);
            ref.child(editId).setValue(st);
            editId = null;
        }
        etName.setText("");
        etEmail.setText("");
        etPhone.setText("");
        etAge.setText("");
    }
}
