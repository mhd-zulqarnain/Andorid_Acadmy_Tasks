package com.example.zulqarnain.suuetrecycler;

/**
 * Created by Zul Qarnain on 8/3/2017.
 */

public class Student {
    private String name;
    private String subject;

    public Student(String name, String subject) {
        this.subject = subject;
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public String getSubject(){
        return subject;
    }
}
