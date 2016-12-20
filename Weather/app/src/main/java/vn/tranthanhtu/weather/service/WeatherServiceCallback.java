package vn.tranthanhtu.weather.service;

import vn.tranthanhtu.weather.data.Channel;

/**
 * Created by Dell latitude E6520 on 11/30/2016.
 */

public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception e);
}
