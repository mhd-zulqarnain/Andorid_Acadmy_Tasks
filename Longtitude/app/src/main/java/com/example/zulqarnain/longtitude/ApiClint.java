package com.example.zulqarnain.longtitude;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zul Qarnain on 9/19/2017.
 */

public class ApiClint {
    public static Retrofit retrofit;
    public static String BASE_URL="http://10.0.3.2/Longtitude/";
    public static Retrofit getApiClint(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
