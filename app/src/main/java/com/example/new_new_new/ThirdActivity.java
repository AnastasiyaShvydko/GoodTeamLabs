package com.example.new_new_new;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{
  //  TextView PersonalData;
    CardView app,personalInfo,getResults,aboutus,price_list;
   // Button app;
    String name,last_name,id,email,policy_number,phone_number,nationality,age,appointment,results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent = getIntent();
        String message = intent.getStringExtra(SecondActivity.EXTRA_MESSAGE);
        name = intent.getStringExtra("name");
        id = intent.getStringExtra("id");
        email = intent.getStringExtra("email");
        last_name = intent.getStringExtra("last_name");
        policy_number = intent.getStringExtra("policy_number");
        phone_number = intent.getStringExtra("phone_number");
        nationality = intent.getStringExtra("nationality");
        age = intent.getStringExtra("age");
        appointment =  intent.getStringExtra("appointment");
        results = intent.getStringExtra("results");




        app = findViewById(R.id.appointment);
        app.setOnClickListener(this);
        personalInfo = findViewById(R.id.personalInfo);
        personalInfo.setOnClickListener(this);
        getResults = findViewById(R.id.getResults);
        getResults.setOnClickListener(this);
        aboutus = findViewById(R.id.aboutus);
        aboutus.setOnClickListener(this);
        price_list = findViewById(R.id.price_list);
        price_list.setOnClickListener(this);


        }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.appointment){

            Intent intent1 = new Intent(this, FourthActivity.class);
            intent1.putExtra("name", name);
            intent1.putExtra("email", email);
            intent1.putExtra("last_name", last_name);
            intent1.putExtra("policy_number", policy_number);
            intent1.putExtra("phone_number", phone_number);
            startActivity(intent1);
        }
        else if(v.getId() == R.id.personalInfo){
            Intent intent1 = new Intent(this, FifthActivity.class);
            intent1.putExtra("name", name);
            intent1.putExtra("email", email);
            intent1.putExtra("last_name", last_name);
            intent1.putExtra("policy_number", policy_number);
            intent1.putExtra("phone_number", phone_number);
            intent1.putExtra("appointment",appointment );
            intent1.putExtra("nationality", nationality);
            intent1.putExtra("age", age);


            startActivity(intent1);
        }
        else if(v.getId() == R.id.getResults){
            Intent intent1 = new Intent(this, SixthActivity.class);
            intent1.putExtra("name", name);
            intent1.putExtra("policy_number", policy_number);
            startActivity(intent1);
        }
        else if (v.getId() == R.id.aboutus){
            Intent intent1 = new Intent(this, AboutUs.class);
            startActivity(intent1);
        }
        else if (v.getId() == R.id.price_list){
            Intent intent1 = new Intent(this, PriceListActivity.class);
            startActivity(intent1);
        }
    }
}

