package com.example.hau.newweather.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hau.newweather.R;
import com.example.hau.newweather.adapters.SamplePagerAdapter;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.vp_main);
        circleIndicator = (CircleIndicator) findViewById(R.id.indicator);
        viewPager.setAdapter(new SamplePagerAdapter());
        circleIndicator.setViewPager(viewPager);

        getDataFromAPI();
    }

    private void getDataFromAPI() {

    }
}
