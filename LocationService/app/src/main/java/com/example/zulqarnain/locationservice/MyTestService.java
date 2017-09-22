package com.example.zulqarnain.locationservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Zul Qarnain on 9/21/2017.
 */

public class MyTestService extends Service {
    Context context;
    MyTestService(Context context){
        this.context = context;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    Messege.messege(context,"onCreated called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Messege.messege(context,"onStartCommand called");

        return super.onStartCommand(intent, flags, startId);
    }
}
