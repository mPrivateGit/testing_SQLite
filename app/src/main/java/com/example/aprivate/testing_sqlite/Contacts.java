package com.example.aprivate.testing_sqlite;


public class Contacts implements Iterator{

    private static final String TAG = "Contacts***********=== ";


    private String mFirstNames;
    private String mSecondNames;
    private String mPhoneNumbers;


    public String getmFirstNames() {

        return mFirstNames;
    }
    public void setmFirstNames(String mFirstNames) {
        this.mFirstNames = mFirstNames;
    }
    public String getmSecondNames() {
        return mSecondNames;
    }
    public void setmSecondNames(String mSecondNames) {
        this.mSecondNames = mSecondNames;
    }
    public String getmPhoneNumbers() {
        return mPhoneNumbers;
    }
    public void setmPhoneNumbers(String mPhoneNumbers) {
        this.mPhoneNumbers = mPhoneNumbers;
    }

    @Override
    public Contacts next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public void remove() {

    }

    @Override
    public void addContact(String s, String a, String d) {

    }

    @Override
    public int getContacts(int index) {

        return 0;
//        return this.mContacts.get(index);
    }



}
