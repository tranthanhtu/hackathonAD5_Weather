package com.example.hau.newweather.eventbus;

import com.example.hau.newweather.models.json.api_apixu.Weather;

/**
 * Created by Hau on 09/01/2017.
 */

public class LoadDataSuccessEvent extends BaseEvent{
    private Weather weather;

    public LoadDataSuccessEvent(Weather weather) {
        this.weather = weather;
    }

    public Weather getWeather() {
        return weather;
    }
}
