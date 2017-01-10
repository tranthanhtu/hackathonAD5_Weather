package com.techkids.weatherfunny.views.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.techkids.weatherfunny.views.fragments.ForcastHourFragment;
import com.techkids.weatherfunny.views.fragments.HomeFragment;

/**
 * Created by Hau on 10/01/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private int mNumOfTabs;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        this.mNumOfTabs = 2;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new ForcastHourFragment();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
