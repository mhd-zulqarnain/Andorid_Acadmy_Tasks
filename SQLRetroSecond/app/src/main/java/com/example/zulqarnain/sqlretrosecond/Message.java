package com.example.zulqarnain.sqlretrosecond;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Zul Qarnain on 8/14/2017.
 */

public class Message {
    public static void message(Context context,String message){
        Toast.makeText(context , message,Toast.LENGTH_SHORT).show();
    }
}
