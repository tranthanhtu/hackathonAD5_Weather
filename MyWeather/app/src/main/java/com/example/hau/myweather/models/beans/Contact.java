package com.example.hau.myweather.models.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hau on 31/12/2016.
 */

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name) {
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

    public static List<Contact> list = new ArrayList<>();
}
