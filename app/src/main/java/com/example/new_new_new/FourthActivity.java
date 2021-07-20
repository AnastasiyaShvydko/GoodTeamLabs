package com.example.new_new_new;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.content.res.ResourcesCompat;

import java.io.File;

import javax.activation.FileDataSource;
import javax.sql.DataSource;

public class FourthActivity extends Activity implements View.OnClickListener {
    Button btn08,btn09,btn10,btn11,btn12,btn01,btn02,btn03,btn04,btn05,btn06,btn07;
    DBHelper dbHelper;
    EditText EnterName, EnterID;
    String name,last_name,email,policy_number,phone_number,welcome,part0,part1,part2,text;
    DBAppointment dbAppointment;
    FileDataSource sourse = new FileDataSource("src/main/res/drawable-v24/goodteam.png");

   String btn;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        dbAppointment = new DBAppointment(this);


        btn08 = findViewById(R.id.btn08);
        btn08.setOnClickListener(this);
        btn08.setClickable(false);
        btn08.setBackgroundColor(Color.parseColor("#C3BFBF"));


        CheckAppointment(btn08,"08:00");




        btn09 = findViewById(R.id.btn09);
        btn09.setOnClickListener(this);
        btn09.setClickable(false);
        btn09.setBackgroundColor(Color.parseColor("#C3BFBF"));

        CheckAppointment(btn09,"09:00");

        btn10 = findViewById(R.id.btn10);
        btn10.setOnClickListener(this);
        btn10.setClickable(false);
        btn10.setBackgroundColor(Color.parseColor("#C3BFBF"));
        CheckAppointment(btn10,"10:00");


        btn11 = findViewById(R.id.btn11);
        btn11.setOnClickListener(this);
        btn11.setClickable(false);
        btn11.setBackgroundColor(Color.parseColor("#C3BFBF"));
        CheckAppointment(btn11,"11:00");

        btn12 = findViewById(R.id.btn12);
        btn12.setOnClickListener(this);
        btn12.setClickable(false);
        btn12.setBackgroundColor(Color.parseColor("#C3BFBF"));

        CheckAppointment(btn12,"12:00");

        btn01 = findViewById(R.id.btn01);
        btn01.setOnClickListener(this);
        btn01.setClickable(false);
        btn01.setBackgroundColor(Color.parseColor("#C3BFBF"));
        CheckAppointment(btn01,"01:00");

        btn02 = findViewById(R.id.btn02);
        btn02.setOnClickListener(this);
        btn02.setClickable(false);
        btn02.setBackgroundColor(Color.parseColor("#C3BFBF"));
        CheckAppointment(btn02,"02:00");

        btn03 = findViewById(R.id.btn03);
        btn03.setOnClickListener(this);
        btn03.setClickable(false);
        btn03.setBackgroundColor(Color.parseColor("#C3BFBF"));
        CheckAppointment(btn03,"03:00");

        btn04 = findViewById(R.id.btn04);
        btn04.setOnClickListener(this);
        btn04.setClickable(false);
        btn04.setBackgroundColor(Color.parseColor("#C3BFBF"));
        CheckAppointment(btn04,"04:00");

        btn05 = findViewById(R.id.btn05);
        btn05.setOnClickListener(this);
        btn05.setClickable(false);
        btn05.setBackgroundColor(Color.parseColor("#C3BFBF"));
        btn05.setBackgroundResource(R.drawable.buttoval);
        CheckAppointment(btn05,"05:00");

        btn06 = findViewById(R.id.btn06);
        btn06.setOnClickListener(this);
        btn06.setClickable(false);
        btn06.setBackgroundColor(Color.parseColor("#C3BFBF"));
        CheckAppointment(btn06,"06:00");

        btn07 = findViewById(R.id.btn07);
        btn07.setOnClickListener(this);
        btn07.setClickable(false);
        btn07.setBackgroundColor(Color.parseColor("#C3BFBF"));
        CheckAppointment(btn07,"07:00");

        dbHelper = new DBHelper(this);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        last_name = intent.getStringExtra("last_name");
        email = intent.getStringExtra("email");
        policy_number = intent.getStringExtra("policy_number");
        phone_number = intent.getStringExtra("phone_number");


        welcome = "Appointment details";
        part0 = "Hello,";
        part1 = ".\nThanks for scheduling your lab test with us!\nThis email confirms that you have successfully booked an appointment for a lab test at ";
        part2 = ".\nYou may reschedule your appointment up to 12 hours before the appointed time.\nThank you for booking with Us!!\nGoodTeamLabs.";



    }
    public  void Send(String btn_name, View element){
        SetAppointment();
        InsertToBase(btn_name);
        text = part0 + name + part1 + btn_name + part2;
        SendEmail sendEmail = new SendEmail(email,welcome,text);
        sendEmail.execute();
        element.setClickable(false);
        element.setBackgroundColor(Color.parseColor("#C3BFBF"));


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn08) {
            btn = "08:00";
            Send(btn,btn08);



        }
        else if(v.getId() == R.id.btn09) {

            btn = "09:00";

            Send(btn,btn09);
        }
        else if(v.getId() == R.id.btn10) {

            btn = "10:00";
            Send(btn,btn10);

        }
        else if(v.getId() == R.id.btn11) {

            btn = "11:00";
            Send(btn,btn11);

        }
        else if(v.getId() == R.id.btn12) {

            btn = "12:00";

           Send(btn,btn12);

        }
        else if(v.getId() == R.id.btn01) {

            btn = "01:00";
           Send(btn,btn01);

        }
        else if(v.getId() == R.id.btn02) {

            btn = "02:00";
            Send(btn,btn02);

        }
        else if(v.getId() == R.id.btn03) {

            btn = "03:00";
            Send(btn,btn03);

        }
        else if(v.getId() == R.id.btn04) {

            btn = "04:00";
            Send(btn,btn04);

        }
        else if(v.getId() == R.id.btn05) {

            btn = "05:00";
            Send(btn,btn05);

        }
        else if(v.getId() == R.id.btn06) {

            btn = "06:00";
            Send(btn,btn06);

        }
        else if(v.getId() == R.id.btn07) {

            btn = "07:00";

            Send(btn,btn07);

        }
    }


    public void CheckAppointment(Button button, String str_time) {

        SQLiteDatabase db = dbAppointment.getReadableDatabase();
        Cursor cursor = db.query(DBAppointment.TABLE_CONTACTS, null, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int dateIndex = cursor.getColumnIndex(DBAppointment.KEY_DATE);
            int timeIndex = cursor.getColumnIndex(DBAppointment.KEY_TIME);
            do {
               // Log.d("mLog ", cursor.getString(timeIndex) + str_time);
                if (cursor.getString(timeIndex).equals(str_time) ) {
                    button.setClickable(true);
                    button.setBackgroundColor(Color.parseColor("#01579B"));

                }
        }while (cursor.moveToNext());
    } else
            Log.d("mLog", "0 rows");
        cursor.close();
    }


    public void SetAppointment() {
        SQLiteDatabase db = dbAppointment.getReadableDatabase();
        Cursor cursor = db.query(DBAppointment.TABLE_CONTACTS, null, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int dateIndex = cursor.getColumnIndex(DBAppointment.KEY_DATE);
            int timeIndex = cursor.getColumnIndex(DBAppointment.KEY_TIME);




            do {
                Log.d("mLog ", "DATABASE VERSION"+String.valueOf(DBAppointment.version));
                //cursor.getString(1);
                if (cursor.getString(timeIndex).equals(btn) ) {


                    ContentValues contentValues = new ContentValues();
                    contentValues.put("Time", "n/a");
                    contentValues.put(DBAppointment.KEY_NAME, name);
                   contentValues.put(DBAppointment.KEY_LAST_NAME, last_name);
                    contentValues.put(DBAppointment.KEY_POLICY_NUMBER, policy_number);
                    contentValues.put(DBAppointment.KEY_PHONE_NUMBER, phone_number);

                    db.update(DBAppointment.TABLE_CONTACTS, contentValues, "Time=?" , new String[]{btn});

                }
            }while (cursor.moveToNext());
        } else
            Log.d("mLog", "0 rows");
        cursor.close();


        }


    public void InsertToBase(String time) {

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Log.d("mLog ", "hello");

        Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
            int emailIndex = cursor.getColumnIndex(DBAssetsHelper.KEY_MAIL);
            int nationalityIndex = cursor.getColumnIndex(DBAssetsHelper.KEY_NATIONALITY);
            int ageIndex = cursor.getColumnIndex(DBAssetsHelper.KEY_AGE);
            int resultIndex = cursor.getColumnIndex(DBAssetsHelper.KEY_RESULTS);
            int appointmentIndex = cursor.getColumnIndex(DBHelper.KEY_APPOINTMENT);


            do {
                Log.d("mLog ", "HELLO ");

                if (cursor.getString(nameIndex).equals(name) ) {

                   ContentValues contentValues = new ContentValues();
                    contentValues.put("Appointment", time);
                    database.update(DBHelper.TABLE_CONTACTS, contentValues, "Name = ?" , new String[]{name});

                }
            }while (cursor.moveToNext());
        } else
            Log.d("mLog", "0 rows");
        cursor.close();
    }

}
