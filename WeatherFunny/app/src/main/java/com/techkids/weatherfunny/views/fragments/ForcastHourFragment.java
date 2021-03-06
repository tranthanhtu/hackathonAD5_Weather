package com.techkids.weatherfunny.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.techkids.weatherfunny.R;
import com.techkids.weatherfunny.eventbus.BaseEvent;
import com.techkids.weatherfunny.eventbus.LoadDataFailEvent;
import com.techkids.weatherfunny.eventbus.LoadDataSuccessEvent;
import com.techkids.weatherfunny.managers.NetworkManager;
import com.techkids.weatherfunny.managers.RealmHandler;
import com.techkids.weatherfunny.models.json.api_apixu.Hour;
import com.techkids.weatherfunny.models.json.api_apixu.Weather;
import com.techkids.weatherfunny.views.view_customs.CircularSeekBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForcastHourFragment extends Fragment {

    public static final String TAG = ForcastHourFragment.class.toString();

    @BindView(R.id.circularSeekBar1)
    CircularSeekBar seekBar;
    @BindView(R.id.tv_hour)
    TextView tvHour;
    @BindView(R.id.tv_temp)
    TextView tvTemp;
    @BindView(R.id.tv_precipit)
    TextView tvPrecipit;
    @BindView(R.id.tv_humidity)
    TextView tvHumidity;
    @BindView(R.id.tv_condition)
    TextView tvCondition;
    @BindView(R.id.tv_wind)
    TextView tvWind;
    @BindView(R.id.iv_icon_weather)
    ImageView ivIconWeather;
    @BindView(R.id.tv_city_day_hour)
    TextView tvCityDayHour;

    private Weather weather;

    public ForcastHourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forcast_hour, container, false);
        ButterKnife.bind(this, view);
        weather = RealmHandler.getInstance().getWeather();
        if (weather != null) {
            setupUI();
            addListeners();
        }

        EventBus.getDefault().register(this);
//        Log.d(TAG, "onCreateView: " + weather.toString());

        return view;
    }

    private void addListeners() {
        seekBar.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {
                Log.d(TAG, "onProgressChanged: " + progress);
                List<Hour> listHour = weather.getForecast().getList().get(0).getList();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");


                for (Hour hour : listHour) {
                    Date date = null;
                    try {
                        date = format.parse(hour.getTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (date.getHours() == progress || date.getHours() == progress / 100) {
                        updateWeather(hour);
                        break;
                    }
                }
                if (progress == circularSeekBar.getMax()) {
                    updateWeather(listHour.get(0));
                }
                updateHour(progress);

            }

            @Override
            public void onStopTrackingTouch(CircularSeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(CircularSeekBar seekBar) {

            }
        });
    }

    private void updateWeather(Hour hour) {
        tvTemp.setText(hour.getTempC() + "°");
        tvPrecipit.setText(hour.getPrecipIn());
        tvHumidity.setText(hour.getHumidity() + "%");
        tvCondition.setText(hour.getConditionHour().getText() + "\n" + "Feel like: " + hour.getFeelsLikeC() + "°");
        tvWind.setText("Wind " + hour.getWindMph() + " mph");
        ivIconWeather.setImageResource(loadImage(hour.getConditionHour().getCode()));
    }

    private void updateHour(int progress) {
        if (progress == seekBar.getMax()) {
            progress = 0;
        }
        if (progress / 100 < 10) {
            tvHour.setText("0" + progress / 100 + ":00");
        } else {
            tvHour.setText(progress / 100 + ":00");
        }
    }

    private void setupUI() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = null;
        try {
            date = format.parse(weather.getCurrent().getLastUpdate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date.getHours() < 10) {
            tvHour.setText(String.format("0%d:00", date.getHours()));
        } else {
            tvHour.setText(String.format("%d:00", date.getHours()));
        }
        tvCityDayHour.setText(weather.getLocation().getName());
        seekBar.setProgress(date.getHours() * 100);
        tvTemp.setText(weather.getCurrent().getTempC() + "°");
        tvPrecipit.setText(weather.getCurrent().getPrecipIn());
        tvHumidity.setText(weather.getCurrent().getHumidity() + "%");
        tvCondition.setText(weather.getCurrent().getCondition().getText() + "\n" + "Feel like: " + weather.getCurrent().getFeelslikeC() + "°");
        tvWind.setText("Wind " + weather.getCurrent().getWindMph() + " mph");
        ivIconWeather.setImageResource(loadImage(weather.getCurrent().getCondition().getCode()));
    }

    @Subscribe
    void onDataEvent(BaseEvent baseEvent) {
        Log.d(TAG, "onDataEvent: ");
        if (baseEvent instanceof LoadDataSuccessEvent) {
            LoadDataSuccessEvent event = (LoadDataSuccessEvent) baseEvent;
            weather = event.getWeather();
            setupUI();
        } else if (baseEvent instanceof LoadDataFailEvent) {
            Toast.makeText(getContext(), "Check city again! Or check Internet ", Toast.LENGTH_SHORT).show();
        }
    }

    private int loadImage(String id) {
        return this.getActivity().getResources().getIdentifier("icon_" + id, "drawable", this.getActivity().getPackageName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

}
