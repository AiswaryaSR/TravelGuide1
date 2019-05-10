package com.example.nyesteventure3.travelguide.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nyesteventure3.travelguide.Fare.GitHubService;
import com.example.nyesteventure3.travelguide.Guide.Git;
import com.example.nyesteventure3.travelguide.Guide.GuideValues;
import com.example.nyesteventure3.travelguide.R;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Add_Guide_details extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText tname,tlic,tgender,tage,taddress,temail,tphone;
    String name,lic,gender,age,address,email,phone,loc2,loc3;
    String[] location={"Select a location","Kerala","Goa","Mumbai","Banglore","Kolkatha","Delhi"};
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__guide_details);


        tname=(EditText)findViewById(R.id.ename);
        tlic=(EditText)findViewById(R.id.eproof);
        tgender=(EditText)findViewById(R.id.egender);
        tage=(EditText)findViewById(R.id.eage);
        taddress=(EditText)findViewById(R.id.eaddress);
        temail=(EditText)findViewById(R.id.eemail);
        tphone=(EditText)findViewById(R.id.ephone);
        spin=(Spinner)findViewById(R.id.eloc1);

        spin.setOnItemSelectedListener(this);
             ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,location);
             aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             spin.setAdapter(aa);



        Button button=(Button)findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean flag=true;

                if (tname.getText().toString().equals(""))
                {
                    flag=false;
                    tname.setError("Please enter the name");
                }
                if (tlic.getText().toString().equals(""))
                {
                    flag=false;
                    tlic.setError("Please enter any proof(Driving license,voter ID,Adhar ID)");
                }
                if (tgender.getText().toString().equals(""))
                {
                    flag=false;
                    tgender.setError("Please enter the gender");
                }
                if (tage.getText().toString().equals(""))
                {
                    flag=false;
                    tage.setError("Please enter the age");
                }
                if (taddress.getText().toString().equals(""))
                {
                    flag=false;
                    taddress.setError("Please enter the address");
                }
                if (temail.getText().toString().equals(""))
                {
                    flag=false;
                    temail.setError("Please enter the email");
                }
                if (tphone.getText().toString().equals(""))
                {
                    flag=false;
                    tphone.setError("Please enter the Phone number");
                }
//                if (loc2.getText().toString().equals(""))
//                {
//                    flag=false;
//                    tname.setError("Please enter the name");
//                }

                if (flag) {
                    name = tname.getText().toString();
                    lic = tlic.getText().toString();
                    gender = tgender.getText().toString();
                    age = tage.getText().toString();
                    address = taddress.getText().toString();
                    email = temail.getText().toString();
                    phone = tphone.getText().toString();
                    loc3 = loc2;

                    System.out.println(lic + " " + name + "" + gender + "" + age + "" + address + "" + email + "" + phone + "" + loc3);


                    AddGuidedetails11(lic, name, gender, age, address, email, phone, loc3);
                }
            }
        });

    }

    public void AddGuidedetails11(String lic1,String name1,String gender1,String age1,String address1,String email1,String phone1,String loc1){



       // System.out.println(lic+" "+name1+""+gender1+""+age1+""+address1+""+email1+""+phone1+""+loc1+"\n");

String url="http://test.nyesteventuretech.com/kochi/guide/addgd.php";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://test.nyesteventuretech.com/kochi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HashMap<String,String> hashmap = new HashMap<>();
        hashmap.put("glic",lic1);
        hashmap.put("gname", name1);
        hashmap.put("ggender", gender1);
        hashmap.put("gage", age1);
        hashmap.put("gaddress", address1);
        hashmap.put("gemail", email1);
        hashmap.put("gphone", phone1);
        hashmap.put("gloc", loc1);


        //System.out.println(hashmap);

        Git1Service service = retrofit.create(Git1Service.class);

        System.out.println("Git");
        service.crguidede(hashmap).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                System.out.println("Git service started");

                  if (response.isSuccessful()) {
                      //DummyRes res=response.body();
                      // int success=res.getSuccess();
                      System.out.println("Git service started in condition");
                      Example ex=response.body();
                      int success=ex.getSuccess();
                      System.out.println("Git service started in condition from service");
                      if(success==1) {

                          Toast.makeText(getApplicationContext(), "successfully saved", Toast.LENGTH_SHORT).show();
                          tlic.setText("");
                          tname.setText("");
                          tgender.setText("");
                          tage.setText("");
                          taddress.setText("");
                          temail.setText("");
                          tphone.setText("");

                          //tloc.setText("");
                      }
                      else{
                          Toast.makeText(getApplicationContext(), "Not saved", Toast.LENGTH_SHORT).show();
                      }
                  }
                //}
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Turn on mobile data/wifi",Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        loc2=location[position];

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
