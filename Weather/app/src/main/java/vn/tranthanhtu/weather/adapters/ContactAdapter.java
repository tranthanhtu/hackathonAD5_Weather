package vn.tranthanhtu.weather.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.tranthanhtu.weather.R;
import vn.tranthanhtu.weather.models.ContactModel;
import vn.tranthanhtu.weather.viewholders.ContactViewHolder;

/**
 * Created by Dell latitude E6520 on 12/5/2016.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder>{
    private List<ContactModel> list;
    private Context mContext;

    public ContactAdapter(List<ContactModel> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View menuView = layoutInflater.inflate(R.layout.list_contact, parent, false);

        ContactViewHolder contactViewHolder = new ContactViewHolder(menuView);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        ContactModel contactModel = list.get(position);
        holder.bind(contactModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
