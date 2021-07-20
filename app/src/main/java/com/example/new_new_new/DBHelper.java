package com.example.new_new_new;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //this class help to create new user and store info in the database  when Second activity(Sign Up) is called and also
    // it is used when user enters to the app.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contact_new_users.db";
    public static final String TABLE_CONTACTS = "contacts";
//columns of the table
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

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table "+ TABLE_CONTACTS + "(" + KEY_ID + " integer primary key,"+ KEY_NAME + " text,"+ KEY_LAST_NAME + " text,"+ KEY_POLICY_NUMBER + " text," + KEY_MAIL + " text,"+ KEY_PHONE_NUMBER + " text," + KEY_NATIONALITY + " text," + KEY_AGE + " text," + KEY_RESULTS + " text," + KEY_APPOINTMENT + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists " + TABLE_CONTACTS);

    onCreate(db);
    }
}
