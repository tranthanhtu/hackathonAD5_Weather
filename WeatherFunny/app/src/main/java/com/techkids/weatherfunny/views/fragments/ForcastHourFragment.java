package com.techkids.weatherfunny.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techkids.weatherfunny.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForcastHourFragment extends Fragment {


    public ForcastHourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forcast_hour, container, false);
    }

}
