package com.example.zulqarnain.reteroappcontact;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Zul Qarnain on 9/4/2017.
 */

public class Contact {
   @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
