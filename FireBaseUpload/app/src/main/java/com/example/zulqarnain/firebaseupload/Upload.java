package com.example.zulqarnain.firebaseupload;

/**
 * Created by Zul Qarnain on 10/21/2017.
 */

public class Upload {
    public String name;
    public String uri;

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }

    public Upload(String name, String uri) {

        this.name = name;
        this.uri = uri;
    }
}
