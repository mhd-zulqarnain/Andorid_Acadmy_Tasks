package com.example.zulqarnain.testretrosqltogether;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Zul Qarnain on 9/18/2017.
 */

public interface ApiInterface {
    @GET("getproducts.php")
    Call<List<ShopProduct>> getProduts();


}
