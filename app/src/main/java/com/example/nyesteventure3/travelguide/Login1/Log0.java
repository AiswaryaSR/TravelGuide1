package com.example.nyesteventure3.travelguide.Login1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nyesteventure3.travelguide.R;
import com.example.nyesteventure3.travelguide.StatePage;
import com.example.nyesteventure3.travelguide.admin.adminlogin;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Log0 extends AppCompatActivity {

    EditText e1,e2;
    TextView t1,t2;
    Button b1;
    ImageButton a1;
    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log0);

        a1=(ImageButton)findViewById(R.id.admin);
        e1=(EditText)findViewById(R.id.edt1);
        e2=(EditText)findViewById(R.id.edt66);
        b1=(Button)findViewById(R.id.login);
        t1=(TextView)findViewById(R.id.error);
        t2=(TextView)findViewById(R.id.reg);

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Log0.this,Register.class);
                startActivity(i);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                boolean flag=true;
                if (e1.getText().toString().equals("")){
                    flag=false;
                    e1.setError("Please enter valid email id");
                }
                if (e2.getText().toString().equals("")){
                    flag=false;
                    e2.setError("Please enter valid password");
                }

                if (flag) {
                    s1 = e1.getText().toString();
                    s2 = e2.getText().toString();

                    apiget();
                }

            }
        });
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Log0.this,adminlogin.class);
                startActivity(i);
            }
        });
    }

    public void apiget()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://test.nyesteventuretech.com/kochi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Git1 api1 = retrofit.create(Git1.class);

        String geturl="http://test.nyesteventuretech.com/kochi/guide/displayuser.php";


        api1.getUserDe1().enqueue(new Callback<List<ExampleLog>>() {

            @Override
            public void onResponse(Call<List<ExampleLog>> call, Response<List<ExampleLog>> response) {


                if (response.isSuccessful()){

                    boolean flag=false;
                    List<ExampleLog> heroList = response.body();
                    String[] heroes = new String[heroList.size()];
                    for (int i = 0; i < heroList.size(); i++) {
                        String user1 = heroList.get(i).getEmail();
                        String pass1=heroList.get(i).getPassword();

                        if (e1.getText().toString().equals(user1)&&e2.getText().toString().equals(pass1))
                        {
                            flag=true;
//                            Intent intent=news_data Intent(Log0.this,StatePage.class);
//                            startActivity(intent);

                        }
                        else{
                           // flag=false;

                        }

                    }
                    if (flag)
                    {
                        Intent intent=new Intent(Log0.this,StatePage.class);
                        startActivity(intent);
                        e1.setText("");
                        e2.setText("");
                       // Toast.makeText(getApplicationContext(),"successfully login",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        t1.setText("Please enter valid username and password");
                        t1.setGravity(Gravity.CENTER);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<ExampleLog>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Turn on mobile data",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
