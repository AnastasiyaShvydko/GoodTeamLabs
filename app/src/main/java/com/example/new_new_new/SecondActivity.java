package com.example.new_new_new;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SecondActivity extends Activity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    DBHelper dbHelper;
    public static EditText etName, etEmail, etNationality, etAge, etLastName, etPolicyNumber, etPhoneNumber;
    Button btnAdd;
    MainActivity main = new MainActivity();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        etName = (EditText) findViewById(R.id.etName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etPolicyNumber = (EditText) findViewById(R.id.etPolicyNumber);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etNationality = (EditText) findViewById(R.id.etNationality);
        etAge = (EditText) findViewById(R.id.etAge);
        etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);

        dbHelper = new DBHelper(this);

    }

    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.btnAdd) {
            String Email = etEmail.getText().toString();
            String Name = etName.getText().toString();
            String LastName = etLastName.getText().toString();

            String welcome = "Welcome to GoodTeamLabs," + Name + " " + LastName + "." ;
            String text = "Hello, " + Name + " " + LastName + ". We have been waiting for you!" +
                    "\n Thank you for signing up on the GoodTeamLab App." +
                    "\n Booking a laboratory test has never been easier! " +
                    "It’s all at your fingertips now. Just click your way to an appointment." +
                    "\nIf you have any concerns, suggestions or questions, contact support at gtlabs@nastya.com and you will have our attention ASAP!" +
                    "\nWe hope you enjoy our application!" ;
            CreateBase();
           SendEmail sendEmail = new SendEmail(Email,welcome,text);

            sendEmail.execute();




            Toast toast = Toast.makeText(getApplicationContext(),
                    "Successfully Submitted!", Toast.LENGTH_LONG);

            toast.show();




            Intent intent2 = new Intent(this, MainActivity.class);

            startActivity(intent2);


        }

    }





    public void CreateBase() {
        String name = etName.getText().toString();
        String lastName = etLastName.getText().toString();
        String policyNumber = etPolicyNumber.getText().toString();
        String email = etEmail.getText().toString();
        String nationality = etNationality.getText().toString();
        String age = etAge.getText().toString();
        String results = "in process";
        String appointment = "";
        String phoneNumber = etPhoneNumber.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.KEY_NAME, name);
        contentValues.put(DBHelper.KEY_LAST_NAME,lastName);
        contentValues.put(DBHelper.KEY_POLICY_NUMBER,policyNumber);
        contentValues.put(DBHelper.KEY_MAIL, email);
        contentValues.put(DBHelper.KEY_NATIONALITY, nationality);
        contentValues.put(DBHelper.KEY_AGE, age);
        contentValues.put(DBHelper.KEY_RESULTS, results);
        contentValues.put(DBHelper.KEY_APPOINTMENT, appointment);
        contentValues.put(DBHelper.KEY_PHONE_NUMBER, phoneNumber);
        database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);


    }

    public static String getProperty(String key, Context context) throws IOException {
        Properties properties = new Properties();

        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open("email.properties");
        properties.load(inputStream);
        return properties.getProperty(key);

    }


}





