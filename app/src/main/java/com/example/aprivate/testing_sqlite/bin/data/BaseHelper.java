package com.example.aprivate.testing_sqlite.bin.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BaseHelper extends SQLiteOpenHelper{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "contactsBase.db";

    public BaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + BaseShema.ContactsTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                BaseShema.Cols.UUID + ", " +
                BaseShema.Cols.FIRST_NAME + ", " +
                BaseShema.Cols.SECOND_NAME + ", " +
                BaseShema.Cols.PHONE_NUMBER + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
