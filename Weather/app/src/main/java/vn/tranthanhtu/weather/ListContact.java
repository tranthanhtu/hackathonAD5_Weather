package vn.tranthanhtu.weather;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.tranthanhtu.weather.adapters.ContactAdapter;
import vn.tranthanhtu.weather.listeners.RecyclerItemClickListener;
import vn.tranthanhtu.weather.models.ContactModel;

public class ListContact extends Activity {
    @BindView(R.id.rv_list)
    RecyclerView rvListContact;
    @BindView(R.id.edt_message_add)
    EditText edtMessageAdd;
    @BindView(R.id.edt_phoneNumber)
    EditText edtPhoneNumber;
    @BindView(R.id.imv_send)
    ImageView imvSend;


    private String name;
    private String phoneNumber;
    private ContactAdapter adapter;
    private String getPhoneNumber;
    private boolean getNumber = true;
    private List<String> namelist = new ArrayList<>();
    private List<String> phonelist = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);
        ButterKnife.bind(this);
        getNumber = false;
        getNumber(this.getContentResolver());
        setupUI();
        addTextListener();
        addListener();
        addTextMessage();
        sendClick();

    }

    private void sendClick() {
        imvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getNumber == true){
                    sendSMS(getPhoneNumber, edtMessageAdd.getText().toString());
                    Intent intent = new Intent(ListContact.this, Weather.class);
                    startActivity(intent);
                    Toast.makeText(ListContact.this, "Message sent!\n"
                            + getPhoneNumber.toString(), Toast.LENGTH_LONG).show();
                }else {
                    sendSMS(edtPhoneNumber.getText().toString(), edtMessageAdd.getText().toString());
                    Intent intent = new Intent(ListContact.this, Weather.class);
                    startActivity(intent);
                    Toast.makeText(ListContact.this, "Message sent!\n"
                            + edtPhoneNumber.getText().toString(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void addTextMessage() {
        Intent intent = getIntent();
        String condition = (String) intent.getSerializableExtra("condition");
        String temperatorC = (String) intent.getSerializableExtra("temperatorC");
        String temperatorF = (String) intent.getSerializableExtra("temperatorF");
        edtMessageAdd.setText("Condition: " + condition
                + "\nTemperator(°C): " + temperatorC
                + "\nTemperator(°F): "+ temperatorF );
    }

    private void addTextListener() {
        edtPhoneNumber.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence query, int start, int before, int count) {

                query = query.toString().toLowerCase();


                final List<ContactModel> filteredList = new ArrayList<>();


                for (int i = 0; i < namelist.size(); i++) {

                    final String name = namelist.get(i).toLowerCase();
                    final String number = phonelist.get(i).toLowerCase();
                    if (name.contains(query) || number.contains(query)) {

                        filteredList.add(new ContactModel(
                                ContactModel.list.get(i).getName(),
                                ContactModel.list.get(i).getPhoneNumber()));

                    }
                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(ListContact.this);
//Add this to your Recyclerview
                rvListContact.setLayoutManager(layoutManager);

                rvListContact.setHasFixedSize(true);

                adapter = new ContactAdapter(filteredList, ListContact.this);

                rvListContact.setAdapter(adapter);

                adapter.notifyDataSetChanged();  // data set changed

            }
        });

    }




    private void addListener() {
        rvListContact.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                getNumber = true;

                getPhoneNumber = ContactModel.list.get(position).getPhoneNumber();

                edtPhoneNumber.setText(ContactModel.list.get(position).getName());
            }
        }));
    }

    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }


    private void setupUI() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//Add this to your Recyclerview
        rvListContact.setLayoutManager(layoutManager);

        rvListContact.setHasFixedSize(true);

        adapter = new ContactAdapter(ContactModel.list, ListContact.this);

        rvListContact.setAdapter(adapter);
    }

    public void getNumber(ContentResolver cr)
    {
        Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//            System.out.println(".................."+phoneNumber);
//            System.out.println(".................."+name);
            ContactModel contactModel = new ContactModel(name, phoneNumber);
            ContactModel.list.add(contactModel);
            namelist.add(name);
            phonelist.add(phoneNumber);
//            for (int i = 0; i < namelist.size(); i++){
//                System.out.println(""+ namelist.get(i).getName());
//            }
        }
        phones.close();

    }


}
