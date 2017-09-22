package com.example.zulqarnain.sqlretrosecond.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Zul Qarnain on 9/20/2017.
 */

public class ShopProducts {
    @SerializedName("pid")
    public int product_id;

    @SerializedName("p_name")
    public String product_name;

    @SerializedName("price")
    public int product_price;

    public ShopProducts(int product_id, String product_name, int product_price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
    }
}
