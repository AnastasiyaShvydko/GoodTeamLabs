package com.example.new_new_new;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBAssetsHelper extends SQLiteAssetHelper {
    //this class help to get information about results from database which stores in the assets.
    public static final String name = "contacts_results.db";
    public static final int version = 1;
    public static final String TABLE_CONTACTS = "contacts";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "Name";
    public static final String KEY_LAST_NAME = "LastName";
    public static final String KEY_POLICY_NUMBER = "PolicyNumber";
    public static final String KEY_MAIL = "Mail";
    public static final String KEY_PHONE_NUMBER = "PhoneNumber";
    public static final String KEY_NATIONALITY = "Nationality";
    public static final String KEY_AGE = "Age";
    public static final String KEY_RESULTS = "Results";
    public static final String KEY_APPOINTMENT = "Appointment";



    public DBAssetsHelper(Context context) {
        super(context, name, null, version);
    }
}
