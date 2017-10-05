package com.example.zulqarnain.multiselectdemo;

import android.app.Application;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Zul Qarnain on 10/4/2017.
 */

public class RecyclerViewDemoApp extends Application {

    private static ArrayList<Student> demoData;
    private static SparseArray<Student> demoMap;

    @Override
    public void onCreate() {
        super.onCreate();
        Random r = new Random();
        /*demoMap = new SparseArray<Student>();
        for (int i = 0; i < 20; i++) {
            Student model = new Student("Test Label No. " + i);
            demoData.add(model);
            demoMap.put(model.id, model);*/
//        }
    }

    public  ArrayList<Student> getDemoData() {
        demoMap = new SparseArray<Student>();
        demoData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Student model = new Student("Test Label No. " + i);
            demoData.add(model);
            demoMap.put(model.id, model);
        }
        return demoData;
    }

    public static final ArrayList<Student> addItemToList(Student model, int position) {
        demoData.add(position, model);
        demoMap.put(model.id, model);
        return new ArrayList<Student>(demoData);
    }

    public static final ArrayList<Student> removeItemFromList(int position) {
        demoData.remove(position);
        demoMap.remove(demoData.get(position).id);
        return new ArrayList<Student>(demoData);
    }

    public static Student findById(int id) {
        return demoMap.get(id);
    }

}