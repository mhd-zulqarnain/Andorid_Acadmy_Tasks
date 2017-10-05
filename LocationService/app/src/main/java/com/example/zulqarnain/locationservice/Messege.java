package com.example.zulqarnain.locationservice;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Zul Qarnain on 9/21/2017.
 */

public class Messege {
    public static void messege(Context context,String msg){
        Toast.makeText(context ,msg,Toast.LENGTH_SHORT).show();
    }
}
