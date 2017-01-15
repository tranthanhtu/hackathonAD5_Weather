package com.techkids.weatherfunny.network;

import com.techkids.weatherfunny.models.json.api_trolyfacebook.Message;
import com.techkids.weatherfunny.models.json.api_trolyfacebook.Remind;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hau on 15/01/2017.
 */

public interface APITroLyFacebook {
    @GET("/thoitiet/")
    Call<Message> getRemind(@Query("noidung") String content);
}
