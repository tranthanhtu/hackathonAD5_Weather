package com.techkids.weatherfunny.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.techkids.weatherfunny.R;
import com.techkids.weatherfunny.eventbus.BaseEvent;
import com.techkids.weatherfunny.eventbus.LoadDataSuccessEvent;
import com.techkids.weatherfunny.managers.Preferrences;
import com.techkids.weatherfunny.managers.RealmHandler;
import com.techkids.weatherfunny.models.json.api_apixu.Weather;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public static final String TAG = HomeFragment.class.toString();

    @BindView(R.id.iv_weather_home)
    ImageView ivWeatherHome;
    @BindView(R.id.tv_city_home)
    TextView tvCityHome;
    @BindView(R.id.tv_temp_home)
    TextView tvTempHome;
    @BindView(R.id.tv_condition_home)
    TextView tvConditionHome;
    @BindView(R.id.tv_humidity_home)
    TextView tvHumidityHome;
    @BindView(R.id.tv_wind_home)
    TextView tvWindHome;

    Weather weather;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        weather = RealmHandler.getInstance().getWeather();
        Log.d(TAG, "onCreateView: " + weather.getLocation().toString());
        if (weather != null) {
            setupUI();
        }
        return view;
    }

    private void setupUI() {
        Log.d(TAG, "setupUI: ");
        tvCityHome.setText(weather.getLocation().getName());
        tvTempHome.setText(weather.getCurrent().getTempC());
        tvConditionHome.setText(weather.getCurrent().getCondition().getText());
        tvHumidityHome.setText(weather.getCurrent().getHumidity());
        tvWindHome.setText(weather.getCurrent().getWindMph());

    }

    @Subscribe
    void onDataEvent(BaseEvent baseEvent) {
        Log.d(TAG, "onDataEvent: ");
        if (baseEvent instanceof LoadDataSuccessEvent) {
            LoadDataSuccessEvent event = (LoadDataSuccessEvent) baseEvent;
            weather = event.getWeather();
        }
    }
}
