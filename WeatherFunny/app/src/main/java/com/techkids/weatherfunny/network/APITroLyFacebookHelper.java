package com.techkids.weatherfunny.network;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Hau on 15/01/2017.
 */

public class APITroLyFacebookHelper {
    private Retrofit retrofit;
    private APITroLyFacebook apiTroLyFacebook;

    private APITroLyFacebookHelper() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.trolyfacebook.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiTroLyFacebook = retrofit.create(APITroLyFacebook.class);
    }

    public APITroLyFacebook getApiTroLyFacebook() {
        return apiTroLyFacebook;
    }

    private static APITroLyFacebookHelper instance = new APITroLyFacebookHelper();

    public static APITroLyFacebookHelper getInstance() {
        return instance;
    }
}
