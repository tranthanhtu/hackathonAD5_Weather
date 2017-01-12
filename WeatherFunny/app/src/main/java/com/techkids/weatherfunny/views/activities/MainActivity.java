package com.techkids.weatherfunny.views.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.techkids.weatherfunny.R;
import com.techkids.weatherfunny.views.adapters.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    CircleIndicator indicator;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        indicator.setViewPager(viewPager);
    }




}
