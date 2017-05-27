package com.example.aprivate.testing_sqlite.bin.data;


import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.aprivate.testing_sqlite.bin.Contacts;

import java.util.UUID;

public class ContactCursorWrapper extends CursorWrapper {
    public ContactCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Contacts getContacts(){
        String uuidString = getString(getColumnIndex(BaseShema.Cols.UUID));
        String firstName = getString(getColumnIndex(BaseShema.Cols.FIRST_NAME));
        String secondName = getString(getColumnIndex(BaseShema.Cols.SECOND_NAME));
        String phoneNumber = getString(getColumnIndex(BaseShema.Cols.PHONE_NUMBER));

        Contacts contacts = new Contacts(UUID.fromString(uuidString));
        contacts.setmFirstNames(firstName);
        contacts.setmSecondNames(secondName);
        contacts.setmPhoneNumbers(phoneNumber);

        return contacts;
    }
}
