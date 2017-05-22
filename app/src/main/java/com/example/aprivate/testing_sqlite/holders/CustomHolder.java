package com.example.aprivate.testing_sqlite.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.aprivate.testing_sqlite.R;
import com.example.aprivate.testing_sqlite.bin.Contacts;

public class CustomHolder extends RecyclerView.ViewHolder {
    private TextView mTextViewFirstName;
    private TextView mTextViewSecondName;
    private TextView mTextViewPhoneNumber;


    public CustomHolder(View itemView) {
        super(itemView);
        mTextViewFirstName = TextView.class.cast(itemView.findViewById(R.id.first_name_item_view));
        mTextViewSecondName = (TextView) itemView.findViewById(R.id.get_second_name_item_view);
        mTextViewPhoneNumber = (TextView) itemView.findViewById(R.id.phone_number_item_view);
    }

    public void bind(Contacts contacts){
        mTextViewFirstName.setText(contacts.getmFirstNames());
        mTextViewSecondName.setText(contacts.getmSecondNames());
        mTextViewPhoneNumber.setText(contacts.getmPhoneNumbers());
    }
}
