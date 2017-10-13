package com.example.zulqarnain.todo.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.zulqarnain.todo.R;


public class MainActivity extends AppCompatActivity {

    final static String TAG = "log.tag.value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_holder);

        if (fragment == null) {
            fragment = TaskFragent.newInstance();
            manager.beginTransaction()
                    .add(R.id.fragment_holder, fragment)
                    .commit();
        }
    }

}
