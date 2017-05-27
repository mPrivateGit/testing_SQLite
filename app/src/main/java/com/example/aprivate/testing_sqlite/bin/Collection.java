package com.example.aprivate.testing_sqlite.bin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aprivate.testing_sqlite.bin.data.BaseHelper;
import com.example.aprivate.testing_sqlite.bin.data.BaseShema;
import com.example.aprivate.testing_sqlite.bin.data.ContactCursorWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Collection {

    public static Collection sCollection;

    private Context mContext;
    private SQLiteDatabase mDataBase;

    public static Collection get(Context context){
        if (sCollection == null){
            sCollection = new Collection(context);
        }
        return sCollection;
    }

    private Collection(Context context) {
        mContext = context.getApplicationContext();
        mDataBase = new BaseHelper(mContext)
                .getWritableDatabase();
    }

    public List<Contacts> getContacts() {
        List<Contacts> contacts = new ArrayList<>();

        ContactCursorWrapper cursorWrapper = queryContacts(null, null);
        try {
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()) {
                contacts.add(cursorWrapper.getContacts());
                cursorWrapper.moveToNext();
            }
        } finally {
            cursorWrapper.close();
        }
        return contacts;
    }


    public Contacts getContacts(UUID id) {
        ContactCursorWrapper cursorWrapper = queryContacts(

                BaseShema.Cols.UUID + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursorWrapper.getCount() == 0) {
                return null;
            }
            cursorWrapper.moveToFirst();
            return cursorWrapper.getContacts();
        } finally {
            cursorWrapper.close();
        }
    }

    public void updateContacts(Contacts contacts){
        String uuidString = contacts.getmId().toString();
        ContentValues values = getContentValues(contacts);

        mDataBase.update(BaseShema.ContactsTable.NAME, values,
                BaseShema.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    public static ContentValues getContentValues(Contacts contacts){
        ContentValues contentValues = new ContentValues();
        contentValues.put(BaseShema.Cols.UUID, contacts.getmId().toString());
        contentValues.put(BaseShema.Cols.FIRST_NAME, contacts.getmFirstNames());
        contentValues.put(BaseShema.Cols.SECOND_NAME, contacts.getmSecondNames());
        contentValues.put(BaseShema.Cols.PHONE_NUMBER, contacts.getmPhoneNumbers());

        return contentValues;
    }

    private ContactCursorWrapper queryContacts(String whereClause, String [] whereArgs) {
        Cursor cursor = mDataBase.query(
                BaseShema.ContactsTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new ContactCursorWrapper(cursor);
    }

    public void addContact(Contacts c){
        ContentValues values = getContentValues(c);

        mDataBase.insert(BaseShema.ContactsTable.NAME, null, values);
    }
}
