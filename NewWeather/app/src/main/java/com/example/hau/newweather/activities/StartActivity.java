package com.example.hau.newweather.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hau.newweather.R;
import com.example.hau.newweather.eventbus.BaseEvent;
import com.example.hau.newweather.eventbus.LoadDataFailEvent;
import com.example.hau.newweather.eventbus.LoadDataSuccessEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity {
    @BindView(R.id.pb_wait_load_api)
    ProgressBar pbWaitLoadApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void getData(BaseEvent event) {
        if (event instanceof LoadDataSuccessEvent) {
            pbWaitLoadApi.setVisibility(View.GONE);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (event instanceof LoadDataFailEvent) {
            pbWaitLoadApi.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Check Interner Conection!", Toast.LENGTH_SHORT).show();
        }

    }
}
