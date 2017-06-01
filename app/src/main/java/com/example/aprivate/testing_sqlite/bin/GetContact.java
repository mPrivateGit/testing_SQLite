package com.example.aprivate.testing_sqlite.bin;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.aprivate.testing_sqlite.R;
import com.example.aprivate.testing_sqlite.bin.data.BaseHelper;
import com.example.aprivate.testing_sqlite.bin.data.BaseShema;

import java.util.UUID;

public class GetContact extends Fragment {
    private static final String TAG = "BF_class ===========";
    private static final String ARG_CONTACT_ID = "contact_id";

    private SQLiteDatabase mDbHelper;
    private Contacts mContacts;
    private TextView mTextViewFirstName;
    private TextView mTextViewSecondName;
    private TextView mTextViewPhoneNumber;
    private Button mDeleteButton; //Костыль который нужно потом переместить в тулбар

    public static GetContact newInstance(UUID contactId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CONTACT_ID, contactId);
        GetContact fragment = new GetContact();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID contactsId = (UUID) getArguments().getSerializable(ARG_CONTACT_ID);
        mContacts = Collection.get(getActivity()).getContacts(contactsId);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact, container, false);

        mTextViewFirstName = (TextView) v.findViewById(R.id.get_first_name);
        mTextViewSecondName = (TextView) v.findViewById(R.id.get_second_name);
        mTextViewPhoneNumber = (TextView) v.findViewById(R.id.get_phone_number);

        set();

        mDeleteButton = (Button) v.findViewById(R.id.delete_contact);
        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseHelper mDbHelper = new BaseHelper(getContext());
                SQLiteDatabase db = mDbHelper.getWritableDatabase();

                String test = BaseShema.Cols.UUID +
                        " =" +
                        "'" +
                        mContacts.getmId().toString() +
                        "'";

                db.delete(BaseShema.ContactsTable.NAME, test, null);

                Intent i = new Intent(getContext(), MainActivity.class);
                startActivity(i);
            }
        });

        return v;
    }

    void set (){
        mTextViewFirstName.setText(mContacts.getmFirstNames());
        mTextViewSecondName.setText(mContacts.getmSecondNames());
        mTextViewPhoneNumber.setText(mContacts.getmPhoneNumbers());
    }

    @Override
    public void onPause() {
        super.onPause();
        Collection.get(getActivity()).updateContacts(mContacts);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.activity_menu_getcontact,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                // do s.th.
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}