package com.example.hau.myweather.models.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hau on 31/12/2016.
 */

public class Condition {
    private String day;
    private String text;
    private String high;
    private String low;
    private int code;

    public Condition(String day, String text, String high, String low, int code) {
        this.day = day;
        this.text = text;
        this.high = high;
        this.low = low;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDay() {
        return day;
    }

    public String getText() {
        return text;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public static List<Condition> list = new ArrayList<>();
}
