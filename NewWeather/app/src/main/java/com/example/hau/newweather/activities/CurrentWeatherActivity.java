package com.example.hau.newweather.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hau.newweather.CircularSeekBar;
import com.example.hau.newweather.R;
import com.example.hau.newweather.eventbus.BaseEvent;
import com.example.hau.newweather.eventbus.LoadDataSuccessEvent;
import com.example.hau.newweather.models.json.api_apixu.Hour;
import com.example.hau.newweather.models.json.api_apixu.Weather;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrentWeatherActivity extends AppCompatActivity {

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

    private Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_weather);
        ButterKnife.bind(this);
        if (weather != null) {
            setupUI();
            addListeners();
        }
    }

    private void addListeners() {
        seekBar.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {
                ArrayList<Hour> listHour = weather.getForecast().getList().get(0).getList();
                String time;
                for (Hour hour : listHour) {
                    time = hour.getTime().substring(11, 12);
                    if (Integer.parseInt(time) == progress) {
                        updateWeather(hour);
                        break;
                    }
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
        tvTemp.setText(hour.getTempC() + "");
        tvPrecipit.setText(hour.getPrecipIn() + "");
        tvHumidity.setText(hour.getHumidity() + "");
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

    @Subscribe
    public void getData(BaseEvent event) {
        if (event instanceof LoadDataSuccessEvent) {
            LoadDataSuccessEvent loadDataSuccessEvent = (LoadDataSuccessEvent) event;
            weather = loadDataSuccessEvent.getWeather();
        }
    }
}
