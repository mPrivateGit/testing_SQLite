package com.example.aprivate.testing_sqlite;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContact extends AppCompatActivity {

    private static final String TAG = "ADD-------------: ";


    private Button mButtonAdd;
    private EditText mEditTextFirstName;
    private EditText mEditTextSecondName;
    private EditText mEditTextPhoneNumber;

    private String mFirstName;
    private String mSecondName;
    private String mPhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        mButtonAdd = (Button) findViewById(R.id.add_button);
        mEditTextFirstName = (EditText) findViewById(R.id.set_first_name);
        mEditTextSecondName = (EditText) findViewById(R.id.set_second_name);
        mEditTextPhoneNumber = (EditText) findViewById(R.id.set_phone_number);


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


                Collection.getInstance().getCrimes().add(c);


                Intent i = new Intent(AddContact.this, MainActivity.class);


                startActivity(i);

            }
        });
    }
}
