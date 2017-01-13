package com.techkids.weatherfunny.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.techkids.weatherfunny.R;
import com.techkids.weatherfunny.eventbus.BaseEvent;
import com.techkids.weatherfunny.eventbus.LoadDataFailEvent;
import com.techkids.weatherfunny.eventbus.LoadDataSuccessEvent;
import com.techkids.weatherfunny.eventbus.LoadLocationSuccessEvent;
import com.techkids.weatherfunny.services.LoadDataFromAPIService;
import com.techkids.weatherfunny.services.LoadLocationService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity {

    private static final String TAG = StartActivity.class.toString();
    @BindView(R.id.pb_wait_load_api)
    ProgressBar pbWaitLoadApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
        Intent intent = new Intent(this, LoadLocationService.class);
        startService(intent);
        Log.d(TAG, "onCreate: ");
//        Intent intent = new Intent(this, LoadDataFromAPIService.class);
//        startService(intent);
    }

    @Subscribe
    void onLocationEvent(BaseEvent baseEvent) {
        if (baseEvent instanceof LoadLocationSuccessEvent) {
            Intent intent = new Intent(this, LoadDataFromAPIService.class);
            startService(intent);
        }
    }

    @Subscribe
    void onDataEvent(BaseEvent baseEvent) {
        if (baseEvent instanceof LoadDataSuccessEvent) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (baseEvent instanceof LoadDataFailEvent) {
            pbWaitLoadApi.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Check Interner Conection!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }
}
