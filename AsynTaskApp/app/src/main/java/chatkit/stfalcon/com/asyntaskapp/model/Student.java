package chatkit.stfalcon.com.asyntaskapp.model;

/**
 * Created by Zul Qarnain on 12/26/2017.
 */

public class Student {
    private String stName;
    private String stUrl;

    public Student(String stName, String stUrl) {
        this.stName = stName;
        this.stUrl = stUrl;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStUrl() {
        return stUrl;
    }

    public void setStUrl(String stUrl) {
        this.stUrl = stUrl;
    }
}
