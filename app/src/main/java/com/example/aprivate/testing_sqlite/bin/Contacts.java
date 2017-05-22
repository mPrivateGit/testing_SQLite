package com.example.aprivate.testing_sqlite.bin;


import java.util.UUID;

public class Contacts {

    private static final String TAG = "Contacts***********=== ";

    private String mFirstNames;
    private String mSecondNames;
    private String mPhoneNumbers;
    private UUID mId;

    public Contacts(){
        mId = UUID.randomUUID();
    }

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

    public UUID getmId() {
        return mId;
    }

}
