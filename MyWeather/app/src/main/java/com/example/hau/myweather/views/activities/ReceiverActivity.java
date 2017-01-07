package com.example.hau.myweather.views.activities;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hau.myweather.R;
import com.example.hau.myweather.utils.Utils;

import butterknife.BindView;

public class ReceiverActivity extends AppCompatActivity {
    @BindView(R.id.tv_condition_receiver)
    TextView tvConditionReceiver;
    @BindView(R.id.tv_temperatorC_receiver)
    TextView tvTemperatorCReceiver;
    @BindView(R.id.tv_temperatorF_receiver)
    TextView tvTemperatorFReceiver;
    @BindView(R.id.alert_receiver)
    TextView tvAlertReceiver;
    @BindView(R.id.ll_background_receiver)
    LinearLayout llBackgroundReceiver;
    @BindView(R.id.btn_oke)
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_receiver);
        dialog.setTitle("Today's Weather");

        btnOK = (Button) dialog.findViewById(R.id.btn_oke);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent1 = new Intent(ReceiverActivity.this, WeatherActivityImpl.class);
                startActivity(intent1);
            }
        });
        dialog.show();
    }
}
