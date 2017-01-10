package com.techkids.weatherfunny.models.json.api_openweather;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Hau on 08/01/2017.
 */

public class City {
    @SerializedName("list")
    ArrayList<Timeline> list;

    public ArrayList<Timeline> getList() {
        return list;
    }
}
