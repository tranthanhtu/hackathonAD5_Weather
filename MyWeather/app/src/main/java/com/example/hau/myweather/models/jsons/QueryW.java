package com.example.hau.myweather.models.jsons;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 31/12/2016.
 */

public class QueryW {
    @SerializedName("results")
    private ResultW resultW;

    public ResultW getResultW() {
        return resultW;
    }
}
