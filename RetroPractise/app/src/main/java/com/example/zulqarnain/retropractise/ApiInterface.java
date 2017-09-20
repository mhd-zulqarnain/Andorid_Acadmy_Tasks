package com.example.zulqarnain.retropractise;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Zul Qarnain on 9/8/2017.
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST("WriteContact.php")
    Call<Student> updateRecord(@Field("name") String name,@Field("email") String email);

}
