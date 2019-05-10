package com.example.nyesteventure3.travelguide.Login1;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.nyesteventure3.travelguide.R;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity
{

    EditText e1,e2,e3,e4,e5,e6;
    Button b1;
    RadioGroup ra;
    String s1,s2,s3,s4,s5,s6,gender="Male";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        e1 = (EditText) findViewById(R.id.edt11);
        e2 = (EditText) findViewById(R.id.edt22);
        e3 = (EditText) findViewById(R.id.edt33);
        e4 = (EditText) findViewById(R.id.edt44);
        e5 = (EditText) findViewById(R.id.edt66);
        e6 = (EditText) findViewById(R.id.edt77);
        ra = (RadioGroup) findViewById(R.id.ra1);

        b1 = (Button) findViewById(R.id.register);


        ra.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if (checkedId == R.id.male) {
                    gender = "Male";
                } else if (checkedId == R.id.female) {

                    gender = "Female";

                }
            }

        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = true;

                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                s3 = e3.getText().toString();
                s4 = e4.getText().toString();
                s5 = e5.getText().toString();
                s6 = e6.getText().toString();


                if (s1 != null && s1.length() < 3) {
                    e1.setError("name should contain atleast 3 characters");
                    flag = false;

                }
                if (s2 != null && s2.length() > 2) {
                    e2.setError("Please enter a valid age");
                    flag = false;

                }


                if (s3 != null && s3.length() < 3) {
                    e3.setError("address should contain atleast 3 characters");
                    flag = false;

                }
                if (isValidMail(e4.getText().toString())) {
                    s4 = e4.getText().toString();

                } else {
                    e4.setError("Invalid Email Id");
                }

                if (!isValidPassword(s5)) {
                    e5.setError("password must contain integer,special characters, upper and lower case letters");
                    flag = false;
                }
                if (s6 != null && s6.length() < 10) {
                    e6.setError("Please enter a valid mobile number");
                }


                if (flag) {

                    ContentValues cv = new ContentValues();


                    String url = "http://test.nyesteventuretech.com/kochi/guide/adduser.php";

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://test.nyesteventuretech.com/kochi/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    HashMap<String, String> hashmap = new HashMap<>();
                    hashmap.put("name", s1);
                    hashmap.put("age", s2);
                    hashmap.put("address", s3);
                    hashmap.put("email", s4);
                    hashmap.put("gender", gender);
                    hashmap.put("password", s5);
                    hashmap.put("phone", s6);

                    Git1 retro = retrofit.create(Git1.class);
                    retro.apicreate(hashmap).enqueue(new Callback<Example123>() {
                        @Override
                        public void onResponse(Call<Example123> call, Response<Example123> response) {


                            Toast.makeText(getApplicationContext(), "successfully saved", Toast.LENGTH_SHORT).show();
                            e1.setText("");
                            e2.setText("");
                            e3.setText("");
                            e4.setText("");
                            e5.setText("");
                            e6.setText("");

                            Toast.makeText(getApplicationContext(), "Club registration Successfull,Please use the email and password to login", (Toast.LENGTH_LONG)).show();
                            Intent intent = new Intent(Register.this, Log0.class);
                            startActivity(intent);
                            finish();

                        }


                        @Override
                        public void onFailure(Call<Example123> call, Throwable t) {

                        }
                    });
                }


            }


            public boolean isValidMail(String email) {

                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }

            public boolean isValidPassword(final String password) {

                Pattern pattern;
                Matcher matcher;

                final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";

                pattern = Pattern.compile(PASSWORD_PATTERN);
                matcher = pattern.matcher(password);

                return matcher.matches();

            }

        });
    }
}