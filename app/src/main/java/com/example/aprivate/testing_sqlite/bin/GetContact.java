package com.example.aprivate.testing_sqlite.bin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aprivate.testing_sqlite.R;

import java.util.UUID;

public class GetContact extends Fragment {
    private static final String TAG = "BF_class ===========";
    private static final String ARG_CONTACT_ID = "contact_id";

    private Contacts mContacts;
    private TextView mTextViewFirstName;
    private TextView mTextViewSecondName;
    private TextView mTextViewPhoneNumber;

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
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact, container, false);

        mTextViewFirstName = (TextView) v.findViewById(R.id.get_first_name);
        mTextViewSecondName = (TextView) v.findViewById(R.id.get_second_name);
        mTextViewPhoneNumber = (TextView) v.findViewById(R.id.get_phone_number);

        set();

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
        onDestroyView();
    }

//        mTextViewFirstName.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "fonts/"));
}