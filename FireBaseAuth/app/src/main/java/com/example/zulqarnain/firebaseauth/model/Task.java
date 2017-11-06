package com.example.zulqarnain.firebaseauth.model;

/**
 * Created by Zul Qarnain on 9/26/2017.
 */

public class Task {
   private String mTask,key,imageUrl;

    public Task(){

    }

 /*   public Task(String mTask,String key) {
        this.mTask =mTask;
        this.key= key;
    }*/

    public Task(String mTask,String key,String imageUrl) {
        this.mTask =mTask;
        this.key= key;
        this.imageUrl=imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getmTask() {
        return mTask;
    }

    public void setmTask(String mTask) {
        this.mTask =mTask;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "name "+mTask+" key "+key;
    }
}
