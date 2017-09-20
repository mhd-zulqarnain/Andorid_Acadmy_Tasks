package com.example.zulqarnain.retropractise;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Zul Qarnain on 9/8/2017.
 */

public class Student {
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("response")
    private String response;

    public String getResponse() {
        return response;

    }
}
