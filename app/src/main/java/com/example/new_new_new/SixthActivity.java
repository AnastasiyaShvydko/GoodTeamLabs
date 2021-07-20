package com.example.new_new_new;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SixthActivity extends AppCompatActivity {
    TextView resultsInfo;

    String results,name,policy_number;
    DBAssetsHelper dbAssetsHelper;
    public static String GetName, GetId, GetEmail, GetNationality, GetAge, GetResults, GetAppointment, GetLastName, GetPolicyNumber,GetPhoneNumber;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        Intent intent = getIntent();
        policy_number = intent.getStringExtra("policy_number");
        name = intent.getStringExtra("name");
        resultsInfo =  findViewById(R.id.resultsInfo);
        dbAssetsHelper = new DBAssetsHelper(this);
        SQLiteDatabase db = dbAssetsHelper.getReadableDatabase();
        Cursor cursor = db.query(DBAssetsHelper.TABLE_CONTACTS, null, null, null, null,null,null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBAssetsHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBAssetsHelper.KEY_NAME);
                    int lastNameIndex = cursor.getColumnIndex(DBAssetsHelper.KEY_LAST_NAME);
                    int policyNumberIndex = cursor.getColumnIndex(DBAssetsHelper.KEY_POLICY_NUMBER);
                    int emailIndex = cursor.getColumnIndex(DBAssetsHelper.KEY_MAIL);
                    int phoneNumberIndex = cursor.getColumnIndex(DBAssetsHelper.KEY_PHONE_NUMBER);
                    int nationalityIndex = cursor.getColumnIndex(DBAssetsHelper.KEY_NATIONALITY);
                    int ageIndex = cursor.getColumnIndex(DBAssetsHelper.KEY_AGE);
                    int resultIndex = cursor.getColumnIndex(DBAssetsHelper.KEY_RESULTS);
                    int appointmentIndex = cursor.getColumnIndex(DBAssetsHelper.KEY_APPOINTMENT);

            do { Log.d("mLog ",cursor.getString(nameIndex) + cursor.getString(policyNumberIndex));
                //cursor.getString(1);
                if (cursor.getString(nameIndex).equals(name) && (cursor.getString(policyNumberIndex).equals(policy_number))) {

                    GetId = cursor.getString(idIndex);
                    GetName = cursor.getString(nameIndex);
                    GetLastName = cursor.getString(lastNameIndex);
                    GetPolicyNumber = cursor.getString(policyNumberIndex);
                    GetEmail = cursor.getString(emailIndex);
                    GetNationality = cursor.getString(nationalityIndex);
                    GetAge = cursor.getString(ageIndex);
                    GetResults = cursor.getString(resultIndex);
                    GetAppointment = cursor.getString(appointmentIndex);
                    GetPhoneNumber = cursor.getString(phoneNumberIndex);

                }
            } while (cursor.moveToNext());
        } else
            Log.d("mLog", "0 rows");

        cursor.close();

        resultsInfo.setText(GetResults);

    }
        }



