package com.example.zulqarnain.sqlretrosecond.Utilities;

import com.example.zulqarnain.sqlretrosecond.Model.ShopProducts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Zul Qarnain on 9/18/2017.
 */

public interface ApiInterface {
    @GET("getproducts.php")
    Call<ArrayList<ShopProducts>> getProduts();


}
