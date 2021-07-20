package com.example.new_new_new;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FifthActivity extends AppCompatActivity{


    TextView nameInfo,lastNameInfo,emailInfo,phoneInfo,policyNumberInfo,nationalityInfo,ageInfo,appointmentInfo;
String name,last_name,id,email,policy_number,phone_number,nationality,age,appointment,results;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        id = intent.getStringExtra("id");
        email = intent.getStringExtra("email");
        last_name = intent.getStringExtra("last_name");
        policy_number = intent.getStringExtra("policy_number");
        phone_number = intent.getStringExtra("phone_number");
        nationality = intent.getStringExtra("nationality");
        age = intent.getStringExtra("age");
        appointment =  intent.getStringExtra("appointment");
        nameInfo = findViewById(R.id.nameInfo);
        nameInfo.setText(name);
        lastNameInfo = findViewById(R.id.lastNameInfo);
        lastNameInfo.setText(last_name);
        emailInfo = findViewById(R.id.emailInfo);
        emailInfo.setText(email);
        phoneInfo = findViewById(R.id.phoneInfo);
        phoneInfo.setText(phone_number);
        policyNumberInfo = findViewById(R.id.policyNumberInfo);
        policyNumberInfo.setText(policy_number);
      nationalityInfo =  findViewById(R.id.nationalityInfo);
      nationalityInfo.setText(nationality);
      ageInfo = findViewById(R.id.ageInfo);
      ageInfo.setText(age);
      appointmentInfo = findViewById(R.id.appointmentInfo);
      appointmentInfo.setText(appointment);




}




}
