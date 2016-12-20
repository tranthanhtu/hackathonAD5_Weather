package vn.tranthanhtu.weather.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.tranthanhtu.weather.R;
import vn.tranthanhtu.weather.models.ContactModel;

/**
 * Created by Dell latitude E6520 on 12/5/2016.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phoneNumber)
    TextView tvPhoneNumber;
    public ContactViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(ContactModel model){
        tvName.setText(model.getName());
        tvPhoneNumber.setText(model.getPhoneNumber());
    }
}
