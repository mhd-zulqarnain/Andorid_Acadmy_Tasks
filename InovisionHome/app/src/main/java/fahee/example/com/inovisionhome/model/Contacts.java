package fahee.example.com.inovisionhome.model;

/**
 * Created by Zul Qarnain on 2/14/2018.
 */

public class Contacts {
    String name;
    String imgAddress;

    public Contacts(String name, String imgAddress) {
        this.name = name;
        this.imgAddress = imgAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }
}
