package com.example.zulqarnain.photogallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by Zul Qarnain on 12/20/2017.
 */

public abstract class SingleFragementActivity extends FragmentActivity {
    public abstract  Fragment createFragement();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment!=null){
            fragment = createFragement();
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();

        }

    }
}
