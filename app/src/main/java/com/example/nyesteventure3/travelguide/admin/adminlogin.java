package com.example.nyesteventure3.travelguide.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nyesteventure3.travelguide.R;

public class adminlogin extends AppCompatActivity {

    EditText e1,e2;
    TextView t1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        e1=(EditText)findViewById(R.id.edt1);
        e2=(EditText)findViewById(R.id.edt2);
        b1=(Button)findViewById(R.id.login);
    t1=(TextView)findViewById(R.id.error);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((e1.getText().toString().equals("admin"))||(e2.getText().toString().equals("admin")))
                {

                    Intent i=new Intent(adminlogin.this,adminhome.class);
                    startActivity(i);
                    e1.setText("");
                    e2.setText("");
                }
                else {
                        t1.setText("Username and password not match");
                }

            }
        });
    }
}
