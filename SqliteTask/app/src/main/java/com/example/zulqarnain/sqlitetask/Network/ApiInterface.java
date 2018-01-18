package com.example.zulqarnain.sqlitetask.Network;

import com.example.zulqarnain.sqlitetask.model.Student;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Zul Qarnain on 10/5/2017.
 */

public interface ApiInterface {
@GET("getdata.php")
Call<ArrayList<Student>> getData();
}
