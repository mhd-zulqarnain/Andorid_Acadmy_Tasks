package com.example.zulqarnain.reteroappcontact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Zul Qarnain on 9/4/2017.
 */

public interface ApiInterface {
//@GET("bins/1diocx")

    @POST("ReadContacts.php")
    Call<List<Contact>> getContects();
}
