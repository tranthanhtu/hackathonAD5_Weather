package com.example.hau.myweather.models.jsons;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 31/12/2016.
 */

public class Weather {
    @SerializedName("query")
    private QueryW query;

    public QueryW getQuery() {
        return query;
    }
}
