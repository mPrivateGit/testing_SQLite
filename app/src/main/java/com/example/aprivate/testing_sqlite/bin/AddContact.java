package com.example.aprivate.testing_sqlite.bin;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.aprivate.testing_sqlite.R;

public class AddContact extends Fragment {
    private static final String TAG = "ADD-------------: ";

    private Button mButtonAdd;
    private EditText mEditTextFirstName;
    private EditText mEditTextSecondName;
    private EditText mEditTextPhoneNumber;

    private String mFirstName;
    private String mSecondName;
    private String mPhoneNumber;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_add, container, false);

        mButtonAdd = (Button) v.findViewById(R.id.add_button);
        mEditTextFirstName = (EditText) v.findViewById(R.id.set_first_name);
        mEditTextSecondName = (EditText) v.findViewById(R.id.set_second_name);
        mEditTextPhoneNumber = (EditText) v.findViewById(R.id.set_phone_number);

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mFirstName = mEditTextFirstName.getText().toString();
                mSecondName = mEditTextSecondName.getText().toString();
                mPhoneNumber = mEditTextPhoneNumber.getText().toString();

                Contacts c = new Contacts();
                c.setmFirstNames(mFirstName);
                c.setmSecondNames(mSecondName);
                c.setmPhoneNumbers(mPhoneNumber);

                Collection.sCollection.getContacts().add(c);

                Log.d(TAG, Collection.sCollection.getContacts()
                        .get(Collection.sCollection.getContacts().size()-1)
                        .getmId().toString());


                Intent i = new Intent(getContext(), MainActivity.class);
                startActivity(i);
            }
        });
        return v;
    }
}