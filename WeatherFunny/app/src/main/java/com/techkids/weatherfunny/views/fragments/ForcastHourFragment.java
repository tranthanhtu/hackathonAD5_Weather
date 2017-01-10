package com.techkids.weatherfunny.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techkids.weatherfunny.R;
import com.techkids.weatherfunny.managers.RealmHandler;
import com.techkids.weatherfunny.models.json.api_apixu.Hour;
import com.techkids.weatherfunny.models.json.api_apixu.Weather;
import com.techkids.weatherfunny.views.view_customs.CircularSeekBar;

import java.util.ArrayList;
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
        Log.d(TAG, "onCreateView: " + weather.toString());
        if (weather != null) {
            setupUI();
            addListeners();
        }
        return view;
    }

    private void addListeners() {
        seekBar.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {
                List<Hour> listHour = weather.getForecast().getList().get(0).getList();
                String time;
//                for (Hour hour : listHour) {
//                    time = hour.getTime().substring(11, 12);
//                    if (Integer.parseInt(time) == progress) {
//                        updateWeather(hour);
//                        break;
//                    }
//                }
//                updateHour(progress);

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
        tvTemp.setText(hour.getTempC() + "");
        tvPrecipit.setText(hour.getPrecipIn() + "");
        tvHumidity.setText(hour.getHumidity() + "");
        tvCondition.setText(hour.getConditionHour().getText());
        tvWind.setText("Wind" + hour.getWindMph() + "mph");
    }

    private void updateHour(int progress) {
        if (progress == seekBar.getMax()) {
            progress = 0;
        }
        if (progress < 10) {
            tvHour.setText("0" + progress + ":00");
        } else {
            tvHour.setText(progress + ":00");
        }
    }

    private void setupUI() {

    }
}
