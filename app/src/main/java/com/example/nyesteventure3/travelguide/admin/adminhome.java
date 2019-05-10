package com.example.nyesteventure3.travelguide.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nyesteventure3.travelguide.HomePage1;
import com.example.nyesteventure3.travelguide.R;
import com.example.nyesteventure3.travelguide.StatePage;

public class adminhome extends AppCompatActivity {

    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);

        b1=(Button)findViewById(R.id.fare);
        b2=(Button)findViewById(R.id.guide);
        b3=(Button)findViewById(R.id.viewuser);
        b4=(Button)findViewById(R.id.viewfeed);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(adminhome.this,Add_Fare_Details.class);
                 startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(adminhome.this,Add_Guide_details.class);
//                i.putExtra("tag","goa");
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(adminhome.this,ViewUserDetails.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(adminhome.this,viewfeedback.class);
                startActivity(i);
            }
        });
    }
}
