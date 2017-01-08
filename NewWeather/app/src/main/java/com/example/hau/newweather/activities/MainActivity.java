package com.example.hau.newweather.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hau.newweather.R;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDataFromAPI();
    }

    private void getDataFromAPI() {

    }
}
