package com.example.hau.myweather.views.activities;

import com.example.hau.myweather.models.jsons.ForecastItem;
import com.example.hau.myweather.models.jsons.Weather;

/**
 * Created by Hau on 31/12/2016.
 */

public interface WeatherActivity {
    void updateUI(Weather weather);
}
