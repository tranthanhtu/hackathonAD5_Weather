package vn.tranthanhtu.weather.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell latitude E6520 on 12/5/2016.
 */

public class ContactModel {
    private String name;
    private String phoneNumber;

    public ContactModel(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public ContactModel(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static List<ContactModel> list = new ArrayList<>();
}
