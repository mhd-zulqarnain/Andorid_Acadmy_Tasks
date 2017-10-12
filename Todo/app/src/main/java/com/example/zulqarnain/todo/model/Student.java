package com.example.zulqarnain.todo.model;

/**
 * Created by Zul Qarnain on 9/26/2017.
 */

public class Student {
   private String st_name,key;

    public Student(){

    }

    public Student(String st_name,String key) {
        this.st_name = st_name;
        this.key= key;
    }

    public String getStdname() {
        return st_name;
    }

    public void setStdname(String st_name) {
        this.st_name = st_name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "name "+st_name+" key "+key;
    }
}
