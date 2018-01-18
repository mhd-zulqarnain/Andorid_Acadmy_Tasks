package com.example.zulqarnain.sqlitetask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zulqarnain.sqlitetask.Database.SqliteHelper;
import com.example.zulqarnain.sqlitetask.adapter.DataAdapter;
import com.example.zulqarnain.sqlitetask.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText mName;
    EditText mClass;
    EditText mDelText;
    EditText mUptNameText;
    Button mButton;
    Button mUpdate;
    Button mUpdRecord;
    Button mDel;
    TextView mShowData;

    SqliteHelper helper;
    ArrayList<Student> list;
    RecyclerView recyclerView;
    DataAdapter adapter;
    DataLab lab;

    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new SqliteHelper(this);
        mName = (EditText) findViewById(R.id.edit_name);
        mClass = (EditText) findViewById(R.id.edit_class);
        mDelText = (EditText) findViewById(R.id.edit_del);
        mUptNameText = (EditText) findViewById(R.id.edit_uptName);

        list = new ArrayList<>();
        mButton = (Button) findViewById(R.id.btn_insert);
        mUpdate = (Button) findViewById(R.id.btn_update);
        mDel = (Button) findViewById(R.id.btn_del);
        mUpdRecord = (Button) findViewById(R.id.btn_upt);

        recyclerView = (RecyclerView) findViewById(R.id.recyler_view);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        lab=DataLab.getLab(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.insetData(mName.getText().toString(), mClass.getText().toString());
                update();
            }
        });

        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
            }
        });

        mDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = mDelText.getText().toString();
                if (!id.equals("")) {
                    helper.delData(id);
                    update();
                }
            }
        });

        mUpdRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mUptNameText.getText().toString();
                String id = mDelText.getText().toString();
                if (!name.equals("") && !id.equals("")) {
                    helper.updateRecord(name, id);
                    update();
                }
            }
        });
    }

    public void update() {
        int size = lab.getRecordFromServer().size();
        if (size != 0) {
            list = lab.getRecordFromServer();
            adapter = new DataAdapter(MainActivity.this, list);
            recyclerView.setAdapter(adapter);
            int position = layoutManager.findFirstCompletelyVisibleItemPosition();
            Messege.messege(MainActivity.this, "data " + position);
            mName.setText("");
            mClass.setText("");
            mDelText.setText("");
            mUptNameText.setText("");
        } else
            Messege.messege(MainActivity.this, "no data to show" + size);
    }
}
