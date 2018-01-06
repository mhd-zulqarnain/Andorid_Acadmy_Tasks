package qee.zee.com.firestoredemo1.model;

/**
 * Created by Zul Qarnain on 1/3/2018.
 */

public class Users extends UserId{
    private String name;
    private String semister;

    public Users() {
    }

    public Users(String name, String semister) {
        this.name = name;
        this.semister = semister;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemister() {
        return semister;
    }

    public void setSemister(String semister) {
        this.semister = semister;
    }
}
