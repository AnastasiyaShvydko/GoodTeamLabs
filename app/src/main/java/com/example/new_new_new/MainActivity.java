package com.example.new_new_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE1 = "com.example.myfirstapp.MESSAGE";
    public static  String EXTRA_MESSAGE2 = "";
    public static final String EXTRA_MESSAGE3 = "";
    EditText EnterEmail, EnterPolicyNumber;
    Button btnSingUp, btnSingIn;
    DBHelper dbHelper;


    public static String GetName, GetId, GetEmail, GetNationality, GetAge, GetResults, GetAppointment, GetLastName, GetPolicyNumber,GetPhoneNumber;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EnterEmail = (EditText) findViewById(R.id.EnterEmail);
        EnterPolicyNumber = (EditText) findViewById(R.id.EnterPolicyNumber);
        btnSingUp = findViewById(R.id.btnSingUp);
        btnSingUp.setOnClickListener(this);
        btnSingIn = findViewById(R.id.btnSingIn);
        btnSingIn.setOnClickListener(this);


        dbHelper = new DBHelper(this);


    }


    @Override
    public void onClick(View v) {

        String email = EnterEmail.getText().toString();
        String policy_number = EnterPolicyNumber.getText().toString();

        if (v.getId() == R.id.btnSingUp) {
            Intent intent1 = new Intent(this, SecondActivity.class);


            startActivity(intent1);
        } else if (v.getId() == R.id.btnSingIn) {


            SQLiteDatabase db = dbHelper.getReadableDatabase();




           Cursor cursor = db.query(DBHelper.TABLE_CONTACTS, null, null, null, null,null,null);

                if (cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int lastNameIndex = cursor.getColumnIndex(DBHelper.KEY_LAST_NAME);
                    int policyNumberIndex = cursor.getColumnIndex(DBHelper.KEY_POLICY_NUMBER);
                    int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);
                    int phoneNumberIndex = cursor.getColumnIndex(DBHelper.KEY_PHONE_NUMBER);
                    int nationalityIndex = cursor.getColumnIndex(DBHelper.KEY_NATIONALITY);
                    int ageIndex = cursor.getColumnIndex(DBHelper.KEY_AGE);
                    int resultIndex = cursor.getColumnIndex(DBHelper.KEY_RESULTS);
                    int appointmentIndex = cursor.getColumnIndex(DBHelper.KEY_APPOINTMENT);

//


                    do { Log.d("mLog ",cursor.getString(nameIndex) + cursor.getString(policyNumberIndex));

                        if (cursor.getString(emailIndex).equals(email) && (cursor.getString(policyNumberIndex).equals(policy_number))) {

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

                            String message = "Id " + GetId + "\nName : " + GetName +"\nLast Name: " + GetLastName +"\nPolicy Number: " +
                                    GetPolicyNumber + "\nE-mail: " + GetEmail +
                                    "\nNationality: " + GetNationality + "\nAge: " + GetAge + "\nResult: " + GetResults + "\nAppointment: " + GetAppointment ;

                            Intent intent = new Intent(this, ThirdActivity.class);
                            intent.putExtra(EXTRA_MESSAGE1, message);

                            intent.putExtra("name", GetName);
                            intent.putExtra("last_name", GetLastName);
                            intent.putExtra("id", GetId);
                            intent.putExtra("email", GetEmail);
                            intent.putExtra("policy_number", GetPolicyNumber);
                            intent.putExtra("phone_number", GetPhoneNumber);
                            intent.putExtra("nationality", GetNationality);
                            intent.putExtra("age", GetAge);
                            intent.putExtra("appointment", GetAppointment);
                            intent.putExtra("results", GetResults);

                            startActivity(intent);


                            Log.d("mLog ", email + policy_number);
                            ;
                        }
                    } while (cursor.moveToNext());
                } else
                    Log.d("mLog", "0 rows");

                 cursor.close();
            }
        }
    }
