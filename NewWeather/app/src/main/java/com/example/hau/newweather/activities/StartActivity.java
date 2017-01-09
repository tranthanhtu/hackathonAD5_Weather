package com.example.hau.newweather.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hau.newweather.R;
import com.example.hau.newweather.eventbus.BaseEvent;
import com.example.hau.newweather.eventbus.LoadDataFailEvent;
import com.example.hau.newweather.eventbus.LoadDataSuccessEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void getData(BaseEvent event) {
        if (event instanceof LoadDataSuccessEvent) {

        } else if (event instanceof LoadDataFailEvent) {

        }

    }
}
