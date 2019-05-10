package com.example.nyesteventure3.travelguide.Subactivity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.TextView;

import com.example.nyesteventure3.travelguide.R;

public class FragAbout1 extends AppCompatActivity {


    TextView about;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_about1);
        about=findViewById(R.id.about);
        about.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);

    }
}
