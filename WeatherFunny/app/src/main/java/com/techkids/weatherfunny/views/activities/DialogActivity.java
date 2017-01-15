package com.techkids.weatherfunny.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.techkids.weatherfunny.R;
import com.techkids.weatherfunny.eventbus.BaseEvent;
import com.techkids.weatherfunny.eventbus.LoadRemindEvent;
import com.techkids.weatherfunny.managers.RealmHandler;
import com.techkids.weatherfunny.models.json.api_trolyfacebook.Message;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogActivity extends AppCompatActivity {

    @BindView(R.id.iv_icon_dialog)
    ImageView ivIcon;
    @BindView(R.id.tv_remind)
    TextView tvRemind;
    Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
        message = RealmHandler.getInstance().getMessage();
        setupUI();
    }

    private void setupUI() {
        GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(ivIcon);
        Glide.with(this).load(R.drawable.rain).into(target);
        if (message != null) {
            tvRemind.setText(message.getList().get(6).getText());
        } else {
            tvRemind.setText("Chửa có gì để show");
        }

    }

}
