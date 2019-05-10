package com.example.nyesteventure3.travelguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.nyesteventure3.travelguide.admin.adminlogin;

public class StatePage extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6;
//    TextView a1;
  //  ImageButton a1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_page);

     //   a1=(ImageButton)findViewById(R.id.admin);
        b1=(Button)findViewById(R.id.kerala);
        b2=(Button)findViewById(R.id.goa);
        b3=(Button)findViewById(R.id.mumbai);
        b4=(Button)findViewById(R.id.kolkatha);
        b5=(Button)findViewById(R.id.delhi);
        b6=(Button)findViewById(R.id.banglore);

//        a1.setOnClickListener(news_data View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=news_data Intent(StatePage.this,adminlogin.class);
//                startActivity(i);
//            }
//        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(StatePage.this,HomePage1.class);
                i.putExtra("tag","kerala");
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StatePage.this,HomePage1.class);
                i.putExtra("tag","goa");
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StatePage.this,HomePage1.class);
                i.putExtra("tag","mumbai");
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StatePage.this,HomePage1.class);
                i.putExtra("tag","kolkatha");
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StatePage.this,HomePage1.class);
                i.putExtra("tag","delhi");
                startActivity(i);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StatePage.this,HomePage1.class);
                i.putExtra("tag","banglore");
                startActivity(i);
            }
        });

    }
}
