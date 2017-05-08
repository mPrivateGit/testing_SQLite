package com.example.aprivate.testing_sqlite;




public interface Iterator<Object> {



    Contacts next();
    boolean hasNext();
    void remove();
    void addContact(String s, String a, String d);
    int getContacts(int index);

}
