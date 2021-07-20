package com.example.new_new_new;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBAppointment extends SQLiteAssetHelper {
        public static final String name = "appointments_1.db";
        public static final int version = 1;
        public static final String TABLE_CONTACTS = "appointments";

//
        public static final String KEY_DATE = "Date";
        public static final String KEY_TIME = "Time";
        public static final String KEY_NAME = "Name";
        public static final String KEY_LAST_NAME = "LastName";
        public static final String KEY_POLICY_NUMBER = "PolicyNumber";
        public static final String KEY_PHONE_NUMBER = "PhoneNumber";







    public DBAppointment(Context context) {
        super(context, name, null, version);
    }
}
