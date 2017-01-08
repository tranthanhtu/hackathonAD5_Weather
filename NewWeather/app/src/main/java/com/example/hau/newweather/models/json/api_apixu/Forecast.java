package com.example.hau.newweather.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Hau on 08/01/2017.
 */

public class Forecast {
    @SerializedName("forecastday")
    ArrayList<ForeCastDay> list;

    public ArrayList<ForeCastDay> getList() {
        return list;
    }
}
