package com.example.zulqarnain.sqlretrosecond.Utilities;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zul Qarnain on 9/18/2017.
 */

public class ApiClint {
    static Retrofit retrofit;
    static final String BASE_URL="http://10.0.3.2/trade/";
    public static Retrofit getApiClint(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
