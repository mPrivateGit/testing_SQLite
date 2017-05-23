package com.example.aprivate.testing_sqlite.bin;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aprivate.testing_sqlite.R;

import java.util.List;
import java.util.UUID;

public class ContactPager extends AppCompatActivity {
    private static final String EXTRA_CONTACT_ID =
            "com.example.aprivate.testing_sqlite";

    private ViewPager mViewPager;
    private List<Contacts> mContacts;


    public static Intent newIntent(Context packageContext, UUID contactID) {
        Intent intent = new Intent(packageContext, ContactPager.class);
        intent.putExtra(EXTRA_CONTACT_ID, contactID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_pager);

        UUID contactID = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CONTACT_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_contact_pager_view_pager);
        mContacts = Collection.get(this).getContacts();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Contacts contacts = mContacts.get(position);
                return GetContact.newInstance(contacts.getmId());
            }

            @Override
            public int getCount() {
                return mContacts.size();
            }
        });
        for (int i = 0; i < mContacts.size(); i++) {
            if (mContacts.get(i).getmId().equals(contactID)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}