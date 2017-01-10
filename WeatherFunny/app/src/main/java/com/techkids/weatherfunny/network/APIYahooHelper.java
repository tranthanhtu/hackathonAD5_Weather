package com.techkids.weatherfunny.network;

import com.techkids.weatherfunny.configs.Constant;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Hau on 08/01/2017.
 */

public class APIYahooHelper {
    private Retrofit retrofit;
    private APIYahooHelper apiYahooHelper;

    private APIYahooHelper() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL_YAHOO_WEATHER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiYahooHelper = (APIYahooHelper) retrofit.create(APIWeatherYahoo.class);
    }

    public APIYahooHelper getApiYahooHelper() {
        return apiYahooHelper;
    }

    private static APIYahooHelper instance = new APIYahooHelper();

    public static APIYahooHelper getInstance() {
        return instance;
    }

}
