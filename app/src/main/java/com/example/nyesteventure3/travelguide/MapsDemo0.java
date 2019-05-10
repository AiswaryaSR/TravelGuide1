package com.example.nyesteventure3.travelguide;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.TextView;

public class MapsDemo0 extends AppCompatActivity {

    TextView map;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_demo0);
        map=findViewById(R.id.mapp);
        map.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);

    }
}
