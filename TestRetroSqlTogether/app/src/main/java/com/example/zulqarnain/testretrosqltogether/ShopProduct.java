package com.example.zulqarnain.testretrosqltogether;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Zul Qarnain on 9/18/2017.
 */

public class ShopProduct {
    @SerializedName("pid")
    String id;

    @SerializedName("p_name")
    String name;

    @SerializedName("price")
    String price;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
