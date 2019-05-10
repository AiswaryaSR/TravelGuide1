package com.example.nyesteventure3.travelguide.Subactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nyesteventure3.travelguide.R;

public class Notify1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify1);
        Toast.makeText(getApplicationContext(),"Destination Reached",Toast.LENGTH_LONG).show();
    }
}
