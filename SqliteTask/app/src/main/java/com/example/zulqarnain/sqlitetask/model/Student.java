package com.example.zulqarnain.sqlitetask.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Zul Qarnain on 9/24/2017.
 */

public class Student {
    @SerializedName("id")
    public int id;

    @SerializedName("name")
    String mName;

    @SerializedName("class")
    String mClass;

    @SerializedName("version")
    String mVerison;

    @SerializedName("time")
    String mTime;

    public Student(int id, String mName, String mClass) {
        this.id = id;
        this.mName = mName;
        this.mClass = mClass;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }
}
