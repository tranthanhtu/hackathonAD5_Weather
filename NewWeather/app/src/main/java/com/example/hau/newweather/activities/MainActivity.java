package com.example.hau.newweather.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.hau.newweather.R;
import com.example.hau.newweather.configs.Constant;
import com.example.hau.newweather.models.json.api_apixu.Weather;
import com.example.hau.newweather.network.APIWeatherAPIXUHelper;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDataFromAPI();
    }

    private void getDataFromAPI() {
        APIWeatherAPIXUHelper.getInstance()
                .getApiWeatherAPIXU()
                .getWeather(Constant.KEY_API, "10000")
                .enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Response<Weather> response) {
                        Log.d(TAG, "onResponse: ");
                        Weather weather = response.body();
                        Log.d(TAG, weather.getCurrent().toString() );
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.d(TAG, "onFailure: " + t.toString());
                    }
                });
    }
}
