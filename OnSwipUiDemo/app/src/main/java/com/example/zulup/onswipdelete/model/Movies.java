package com.example.zulup.onswipdelete.model;

/**
 * Created by zulup on 1/27/2018.
 * https://api.androidhive.info/json/menu.json
 */

public class Movies {
    private String id;
    private String name;
    private String description;
    private String price;
    private String thumbnail;

    public Movies(String name) {
        this.name = name;
    }

    public Movies() {
    }

    public Movies(String id, String name, String description, String price, String thumbnail) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setName(String name) {
        this.name = name;
    }
}
