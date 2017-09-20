package com.example.zulqarnain.reteroappcontact;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zul Qarnain on 9/4/2017.
 */

public class ApiClint {

    public static String BASE_URL="http://10.0.3.2/ContactApp/";
//    public static String BASE_URL="https://api.myjson.com/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClint(){
        if(retrofit == null){

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
