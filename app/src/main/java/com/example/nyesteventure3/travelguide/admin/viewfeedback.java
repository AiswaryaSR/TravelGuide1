package com.example.nyesteventure3.travelguide.admin;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.nyesteventure3.travelguide.R;
import com.example.nyesteventure3.travelguide.Subactivity.Handler;

public class viewfeedback extends AppCompatActivity {

    ListView text11;
    ListAdapter2 list11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfeedback);

        text11= (ListView) findViewById(R.id.text1);

        Handler handler=new Handler(viewfeedback.this);
        Cursor cursor1=handler.feeddisplay();

        list11=new ListAdapter2(this,cursor1);
        text11.setAdapter(list11);

    }
}
