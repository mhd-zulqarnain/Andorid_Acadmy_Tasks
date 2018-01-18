package com.example.zulqarnain.sqlitetask;

import android.content.Context;
import android.util.Log;

import com.example.zulqarnain.sqlitetask.Database.SqliteHelper;
import com.example.zulqarnain.sqlitetask.Network.ApiClint;
import com.example.zulqarnain.sqlitetask.Network.ApiInterface;
import com.example.zulqarnain.sqlitetask.model.Student;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Zul Qarnain on 10/7/2017.
 */

public class DataLab {

    private ArrayList<Student> record;
    SqliteHelper dbh;
    ApiInterface apiInteface;
    public static DataLab dataLab;
    Context context;

    public static DataLab getLab(Context context) {
        if (dataLab == null)
            dataLab = new DataLab(context);
        return dataLab;
    }

    private DataLab(Context context) {
        this.context=context;
        dbh = new SqliteHelper(context);
        record=new ArrayList<>();
        apiInteface = ApiClint.getApiClint().create(ApiInterface.class);
    }

    public ArrayList<Student> getRecordFromServer() {
        Call<ArrayList<Student>> call = apiInteface.getData();
        call.enqueue(new Callback<ArrayList<Student>>() {
            @Override
            public void onResponse(Call<ArrayList<Student>> call, Response<ArrayList<Student>> response) {
                ArrayList<Student> mList = response.body();
                record.addAll(mList);
                Messege.messege(context,"called by onrespones------ "+record.size());

            }

            @Override
            public void onFailure(Call<ArrayList<Student>> call, Throwable t) {
                Messege.messege(context,"called  "+t);

            }
        });
//        Messege.messege(context,"called by onrespones------ "+record.size());
        return record;
    }

    public ArrayList<Student> getRecordFromLocal() {
        record = dbh.getStudentData();
        return record;
    }

}
