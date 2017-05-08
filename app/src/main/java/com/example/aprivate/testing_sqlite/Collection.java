package com.example.aprivate.testing_sqlite;

import java.util.ArrayList;
import java.util.List;




public class Collection {
    private static final Collection ourInstance = new Collection();

    private ArrayList<Contacts> mContacts;

    public static Collection getInstance() {
        return ourInstance;
    }

    private Collection() {
        mContacts = new ArrayList<>();
    }

    public List<Contacts> getCrimes() {
        return mContacts;
    }
}