package com.example.zulqarnain.loc1;


import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Zul Qarnain on 9/21/2017.
 */

    public class MyService extends IntentService {
    Handler mHandler;

    public MyService() {
        super("test service");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        Log.d("called", "Service Started");
        mHandler = new android.os.Handler();
        ping();
        Toast.makeText(this, "on command Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("called", "Service Destroyed");

    }
    private void ping() {
        try {
            Log.e("Mycode", "In onStartCommand");
        } catch (Exception e) {
            Log.e("Error", "In onStartCommand");
            e.printStackTrace();
        }
        scheduleNext();
    }

    private void scheduleNext() {
        mHandler.postDelayed(new Runnable() {
            public void run() { ping(); }
        }, 100);
    }
}