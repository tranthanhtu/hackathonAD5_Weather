package com.techkids.weatherfunny.network;

import com.techkids.weatherfunny.configs.Constant;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Hau on 08/01/2017.
 */

public class APIOpenWeatherHelper {
    private Retrofit retrofit;
    private APIOpenWeatherHelper apiOpenWeatherHelper;

    private APIOpenWeatherHelper() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL_OPEN_WEATHER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
