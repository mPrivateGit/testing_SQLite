package com.example.aprivate.testing_sqlite.bin;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;


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


}