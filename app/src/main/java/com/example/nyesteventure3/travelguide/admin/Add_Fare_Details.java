package com.example.nyesteventure3.travelguide.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nyesteventure3.travelguide.Fare.GitHubService;
import com.example.nyesteventure3.travelguide.R;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Add_Fare_Details extends AppCompatActivity {

    EditText tfrom,tto,tauto,tcar,tbus,tdis,ttime;
    String from,to,auto,car,bus,distance,time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__fare__details);

        tfrom=(EditText)findViewById(R.id.efrom);
        tto=(EditText)findViewById(R.id.eto);
        tauto=(EditText)findViewById(R.id.eauto);
        tcar=(EditText)findViewById(R.id.ecar);
        tbus=(EditText)findViewById(R.id.ebus);
        tdis=(EditText)findViewById(R.id.edistance);
        ttime=(EditText)findViewById(R.id.etime);

        Button button=(Button)findViewById(R.id.save);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean flag=true;

                if (tfrom.getText().toString().equals(""))
                {
                    flag=false;
                    tfrom.setError("Please Enter from");
                }
                if (tto.getText().toString().equals(""))
                {
                    flag=false;
                    tto.setError("Please Enter the destination");
                }
                if (tauto.getText().toString().equals(""))
                {
                    flag=false;
                    tauto.setError("Please Enter auto charge");
                }if (tcar.getText().toString().equals(""))
                {
                    flag=false;
                    tcar.setError("Please Enter car charge");
                }if (tbus.getText().toString().equals(""))
                {
                    flag=false;
                    tbus.setError("Please Enter bus charge");
                }
                if (tdis.getText().toString().equals(""))
                {
                    flag=false;
                    tdis.setError("Please Enter the distance");
                }
                if (ttime.getText().toString().equals(""))
                {
                    flag=false;
                    ttime.setError("Please Enter the time duration");
                }





                if (flag) {
                    from = tfrom.getText().toString();
                    to = tto.getText().toString();
                    auto = tauto.getText().toString();
                    car = tcar.getText().toString();
                    bus = tbus.getText().toString();
                    distance = tdis.getText().toString();
                    time = ttime.getText().toString();

                    Adddetails(from, to, auto, car, bus, distance, time);
                }
            }
        });
    }
    public void Adddetails(String from1,String to1,String auto1,String car1,String bus1,String distance1,String time1){

        String url="http://test.nyesteventuretech.com/kochi/guide/displayfared.php";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://test.nyesteventuretech.com/kochi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HashMap<String,String> hashmap = new HashMap<>();
        hashmap.put("fto",from1);
        hashmap.put("ffrom", to1);
        hashmap.put("afare", auto1);
        hashmap.put("cfare", car1);
        hashmap.put("bfare", bus1);
        hashmap.put("fdistance", distance1);
        hashmap.put("ftime", time1);



        GitHubService service = retrofit.create(GitHubService.class);

        service.create1(hashmap).enqueue(new Callback<datassetto>() {
            @Override
            public void onResponse(Call<datassetto> call, Response<datassetto> response) {

                  if (response.isSuccessful()){
                //DummyRes res=response.body();
                // int success=res.getSuccess();

                Toast.makeText(getApplicationContext(),"successfully saved",Toast.LENGTH_SHORT).show();
                tfrom.setText("");
                tto.setText("");
                tauto.setText("");
                tbus.setText("");
                tcar.setText("");
                tdis.setText("");
                ttime.setText("");


                }
            }

            @Override
            public void onFailure(Call<datassetto> call, Throwable t) {
                //Toast.makeText(getApplicationContext(),"fa",Toast.LENGTH_SHORT).show();

            }
        });
    }




}
