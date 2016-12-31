package com.example.hau.myweather.apihelpers;

import com.example.hau.myweather.constants.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hau on 31/12/2016.
 */

public class APIHelper {
    private APIWeather apiWeather;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constant.API_WEAHTER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static APIHelper _sharePointer = new APIHelper();

    public static APIHelper getInstance() {
        return _sharePointer;
    }

    private APIHelper() {
        apiWeather = retrofit.create(APIWeather.class);
    }

    public APIWeather getApiWeather() {
        return apiWeather;
    }
}
