package com.example.zulqarnain.photogallery;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends SingleFragementActivity{

    @Override
    public Fragment createFragement() {
        return  PhotoGalleryFragment.newInstance();
    }

}
