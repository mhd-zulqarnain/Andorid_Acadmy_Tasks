package com.example.zulqarnain.testcrimintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by Zul Qarnain on 8/3/2017.
 */

public  abstract class SingleFragmentActivity extends FragmentActivity {

    public abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager manager =getSupportFragmentManager();
        Fragment fragment =manager.findFragmentById(R.id.fragrment_container);
        if(fragment==null){
            fragment = createFragment();
            manager.beginTransaction().add(R.id.fragrment_container,fragment).commit();
        }


    }
}
