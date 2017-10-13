package com.example.zulqarnain.valutest.model;

/**
 * Created by Zul Qarnain on 10/12/2017.
 */

public class Demo {
    String name,key;

    public Demo() {
    }

    public Demo(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
