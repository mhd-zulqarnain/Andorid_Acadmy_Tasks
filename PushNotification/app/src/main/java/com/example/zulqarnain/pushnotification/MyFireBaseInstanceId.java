package com.example.zulqarnain.pushnotification;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Zul Qarnain on 11/20/2017.
 */

public class MyFireBaseInstanceId extends FirebaseInstanceIdService {
    private static final String REG_TOKEN="REG_TOKEN";
    @Override
    public void onTokenRefresh() {
        String recentToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(REG_TOKEN,recentToken);
    }
}
