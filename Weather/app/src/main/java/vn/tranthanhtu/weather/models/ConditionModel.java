package vn.tranthanhtu.weather.models;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell latitude E6520 on 12/19/2016.
 */

public class ConditionModel {
    private String day;
    private String text;
    private String high;
    private String low;
    private int code;

    public ConditionModel(String day, String text, String high, String low, int code) {
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

    public static List<ConditionModel> list = new ArrayList<>();
}
