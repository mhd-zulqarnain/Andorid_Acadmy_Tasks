package com.example.zulqarnain.locationservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Zul Qarnain on 9/18/2017.
 */

public interface ApiInterface {
    @GET("getdata.php")
    Call<List<Person>> getInfo();

    @FormUrlEncoded
    @POST("addlocation.php")
    Call<String> addLoc(@Field("lat")double lat,@Field("lon")double lon);

}
