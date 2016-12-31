package com.example.hau.myweather.views.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hau.myweather.R;
import com.example.hau.myweather.models.beans.Contact;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hau on 31/12/2016.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phoneNumber)
    TextView tvPhoneNumber;
    View view;
    public ContactViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.view = itemView;
    }

    public void bind(Contact model){
        tvName.setText(model.getName());
        tvPhoneNumber.setText(model.getPhoneNumber());
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        view.setOnClickListener(onClickListener);
    }
}
