package com.techkids.testanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    JJSearchView mJJSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJJSearchView = (JJSearchView) findViewById(R.id.jjsv);
        mJJSearchView.setController(new JJChangeArrowController());
        mJJSearchView.resetAnim();
    }

    public void start(View v) {
        mJJSearchView.startAnim();
    }

    public void reset(View v) {
        mJJSearchView.resetAnim();
    }
}
