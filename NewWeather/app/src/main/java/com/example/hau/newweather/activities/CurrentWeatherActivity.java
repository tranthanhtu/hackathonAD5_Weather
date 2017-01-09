package com.example.hau.newweather.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hau.newweather.CircularSeekBar;
import com.example.hau.newweather.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrentWeatherActivity extends AppCompatActivity {

    @BindView(R.id.circularSeekBar1)
    CircularSeekBar seekBar;
    @BindView(R.id.tv_hour)
    TextView tvHour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_weather);
        ButterKnife.bind(this);
        setupUI();
        addListeners();
    }

    private void addListeners() {
        seekBar.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {
                if (progress == seekBar.getMax()) {
                    progress = 0;
                }
                if (progress < 10) {
                    tvHour.setText("0" + progress + ":00");
                } else {
                    tvHour.setText(progress + ":00");
                }
            }

            @Override
            public void onStopTrackingTouch(CircularSeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(CircularSeekBar seekBar) {

            }
        });
    }

    private void setupUI() {
    }
}
