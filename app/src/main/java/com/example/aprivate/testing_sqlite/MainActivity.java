package com.example.aprivate.testing_sqlite;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class MainActivity extends Activity  {

    private Button mButtonNewContact;
    private Button mButtonContacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        // добавляем фрагмент
        BlankFragment myFragment = new BlankFragment();
        ft.add(R.id.frgmCont, myFragment);
        ft.commit();



        mButtonNewContact = (Button) findViewById(R.id.new_contact);
        mButtonNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddContact.class);
                startActivity(i);
            }
        });


        mButtonContacts = (Button) findViewById(R.id.button_contacts);
        mButtonContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                // добавляем фрагмент
                BlankFragment myFragment = new BlankFragment();
                ft.add(R.id.frgmCont, myFragment);
                ft.commit();

            }
        });
    }

//
}
