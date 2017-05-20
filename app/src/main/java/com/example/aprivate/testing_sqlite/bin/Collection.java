package com.example.aprivate.testing_sqlite.bin;

import java.util.ArrayList;




public class Collection {
    private static final Collection ourInstance = new Collection();

    private ArrayList<Contacts> mContacts;

    public static Collection getInstance() {
        return ourInstance;
    }

    private Collection() {
        mContacts = new ArrayList<>();
    }

    public ArrayList<Contacts> getContacts() {
        return mContacts;
    }
}