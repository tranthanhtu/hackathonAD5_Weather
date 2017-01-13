package com.techkids.weatherfunny.services;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.techkids.weatherfunny.configs.Constant;
import com.techkids.weatherfunny.eventbus.LoadDataFailEvent;
import com.techkids.weatherfunny.eventbus.LoadDataSuccessEvent;
import com.techkids.weatherfunny.managers.Preferrences;
import com.techkids.weatherfunny.managers.RealmHandler;
import com.techkids.weatherfunny.models.json.api_apixu.ForeCastDay;
import com.techkids.weatherfunny.models.json.api_apixu.Forecast;
import com.techkids.weatherfunny.models.json.api_apixu.Weather;
import com.techkids.weatherfunny.network.APIWeatherAPIXUHelper;
import com.techkids.weatherfunny.utils.StringUtils;

import org.greenrobot.eventbus.EventBus;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hau on 10/01/2017.
 */

public class LoadDataFromAPIService extends IntentService {
    public static final String TAG = LoadDataFromAPIService.class.toString();

    public LoadDataFromAPIService() {
        super("LoadDataFromAPIService");
        Log.d(TAG, "LoadDataFromAPIService: ");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
//        Log.d(TAG, "onHandleIntent: " + StringUtils.removeAccent(Preferrences.getInstance().getCity()));
        APIWeatherAPIXUHelper.getInstance()
                .getApiWeatherAPIXU()
                .getWeather(Constant.KEY_API, StringUtils.removeAccent(Preferrences.getInstance().getCity()), "10")
                .enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Response<Weather> response) {
                        Log.d(TAG, "onResponse: " + response.body().toString());
                        Weather weather = response.body();
                        if (weather.getCurrent() != null || weather.getLocation() !=null || weather.getForecast() != null) {

                            Log.d(TAG, "lay duoc" + weather.getCurrent().getCondition().getCode());

                            RealmHandler.getInstance().addWeather(weather);
                            Log.d(TAG, "trong realm: " + RealmHandler.getInstance().getWeather().toString());

                            EventBus.getDefault().post(new LoadDataSuccessEvent(weather));
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.d(TAG, "onFailure: " + t.toString());
                        EventBus.getDefault().post(new LoadDataFailEvent());
                    }
                });
    }
}

