package com.example.aprivate.testing_sqlite.bin;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Collection {

    public static Collection sCollection;

    private List<Contacts> mContacts;

    public static Collection get(Context context){
        if (sCollection == null){
            sCollection = new Collection(context);
        }
        return sCollection;
    }

    private Collection(Context context) {
        mContacts = new ArrayList<>();
    }

    public List<Contacts> getContacts() {
        return mContacts;
    }

    public Contacts getContacts(UUID id) {
        for (Contacts contacts : mContacts) {
            if (contacts.getmId().equals(id)) {
                return contacts;
            }
        }
        return null;
    }
}