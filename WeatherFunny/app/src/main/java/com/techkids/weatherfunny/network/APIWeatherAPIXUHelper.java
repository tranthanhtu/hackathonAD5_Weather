package com.techkids.weatherfunny.network;

import com.techkids.weatherfunny.configs.Constant;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Hau on 09/01/2017.
 */

public class APIWeatherAPIXUHelper {
    private Retrofit retrofit;
    private APIWeatherAPIXU apiWeatherAPIXU;

    private APIWeatherAPIXUHelper() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL_APIXU)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiWeatherAPIXU = retrofit.create(APIWeatherAPIXU.class);
    }

    public APIWeatherAPIXU getApiWeatherAPIXU() {
        return apiWeatherAPIXU;
    }

    private static APIWeatherAPIXUHelper instance = new APIWeatherAPIXUHelper();

    public static APIWeatherAPIXUHelper getInstance() {
        return instance;
    }
}
