package com.example.hau.myweather.views.activities;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hau.myweather.R;
import com.example.hau.myweather.models.beans.Contact;
import com.example.hau.myweather.models.jsons.Weather;
import com.example.hau.myweather.views.adapters.ConditionAdapter;
import com.example.hau.myweather.views.adapters.ContactAdapter;
import com.example.hau.myweather.views.adapters.interfaces.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Hau on 31/12/2016.
 */

public class ContactActivityImpl extends Activity {
    @BindView(R.id.rv_list)
    RecyclerView rvListContact;
    @BindView(R.id.edt_message_add)
    EditText edtMessageAdd;
    @BindView(R.id.edt_phoneNumber)
    EditText edtPhoneNumber;
    @BindView(R.id.imv_send)
    ImageView imvSend;

    private ContactAdapter adapter;
    private boolean getNumber = true;
    private List<String> nameList = new ArrayList<>();
    private List<String> phoneList = new ArrayList<>();
    private String getPhoneNumber;
    private String name;
    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);
        ButterKnife.bind(this);
        getNumber = false;
        getNumber(this.getContentResolver());
        setupUI();
        addTextListener();
        addListeners();
        addTextMessage();
    }

    private void dialogAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Would you like to send message?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (getNumber == true){
                    sendSMS(getPhoneNumber, edtMessageAdd.getText().toString());
                    Intent intent = new Intent(ContactActivityImpl.this, WeatherActivityImpl.class);
                    startActivity(intent);
                    Toast.makeText(ContactActivityImpl.this, "Message sent!\n"
                            + getPhoneNumber.toString(), Toast.LENGTH_LONG).show();
                }else {
                    sendSMS(edtPhoneNumber.getText().toString(), edtMessageAdd.getText().toString());
                    Intent intent = new Intent(ContactActivityImpl.this, WeatherActivityImpl.class);
                    startActivity(intent);
                    Toast.makeText(ContactActivityImpl.this, "Message sent!\n"
                            + edtPhoneNumber.getText().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void addTextMessage() {
        Intent intent = getIntent();
        String condition = (String) intent.getSerializableExtra("condition");
        String temperatorC = (String) intent.getSerializableExtra("temperatureC");
        String temperatorF = (String) intent.getSerializableExtra("temperatureF");
        edtMessageAdd.setText("Condition: " + condition
                + "\nTemperator(°C): " + temperatorC
                + "\nTemperator(°F): "+ temperatorF );
    }

    private void addListeners() {
        adapter.setRecyclerItemClickListener(new RecyclerItemClickListener() {
            @Override
            public void onItemClickListener(int position) {

                getNumber = true;

                getPhoneNumber = Contact.list.get(position).getPhoneNumber();

                edtPhoneNumber.setText(Contact.list.get(position).getName());
            }
        });
    }

    private void addTextListener() {
        edtPhoneNumber.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence query, int start, int before, int count) {

                query = query.toString().toLowerCase();


                final List<Contact> filteredList = new ArrayList<>();


                for (int i = 0; i < nameList.size(); i++) {

                    final String name = nameList.get(i).toLowerCase();
                    final String number = phoneList.get(i).toLowerCase();
                    if (name.contains(query) || number.contains(query)) {

                        filteredList.add(new Contact(
                                Contact.list.get(i).getName(),
                                Contact.list.get(i).getPhoneNumber()));
                    }
                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(ContactActivityImpl.this);
//Add this to your Recyclerview
                rvListContact.setLayoutManager(layoutManager);

                rvListContact.setHasFixedSize(true);

                adapter = new ContactAdapter(filteredList, ContactActivityImpl.this);

                rvListContact.setAdapter(adapter);

                adapter.notifyDataSetChanged();  // data set changed
            }
        });

    }

    private void setupUI() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//Add this to your Recyclerview
        rvListContact.setLayoutManager(layoutManager);

        rvListContact.setHasFixedSize(true);

        adapter = new ContactAdapter(Contact.list, ContactActivityImpl.this);

        rvListContact.setAdapter(adapter);
    }

    @OnClick(R.id.imv_send)
    public void onSend(){
        dialogAlert();
    }

    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }

    public void getNumber(ContentResolver cr)
    {
        Contact.list.clear();
        nameList.clear();
        phoneList.clear();
        Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//            System.out.println(".................."+phoneNumber);
//            System.out.println(".................."+name);
            Contact contactModel = new Contact(name, phoneNumber);
            Contact.list.add(contactModel);
            nameList.add(name);
            phoneList.add(phoneNumber);
        }
        phones.close();
    }
}
