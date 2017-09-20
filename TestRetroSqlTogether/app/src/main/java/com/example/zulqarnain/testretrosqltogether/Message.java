package com.example.zulqarnain.testretrosqltogether;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Zul Qarnain on 9/20/2017.
 */

public class Message {
    public static void message(Context context , String messege){
        Toast.makeText(context,messege,Toast.LENGTH_LONG).show();
    }
}
