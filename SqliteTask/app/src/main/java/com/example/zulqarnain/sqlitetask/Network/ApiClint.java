package com.example.zulqarnain.sqlitetask.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zul Qarnain on 10/5/2017.
 */

public class ApiClint {
    private static final String BASE_URL="http://10.0.3.2/crudapp/";
    public static Retrofit retrofit;
    public static Retrofit getApiClint(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
