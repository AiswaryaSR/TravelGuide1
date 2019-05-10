package com.example.nyesteventure3.travelguide.Fare;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nyesteventure3.travelguide.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fare_kerala extends Fragment {



    TextView auto,bus,dist,time,car;
    EditText editText1,editText2;
    Button calculate;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_frag__fare_kerala,null,false);
        getActivity().setTitle("FareKerala");






        editText1=(EditText)view.findViewById(R.id.edtfrom);
        editText2=(EditText)view.findViewById(R.id.edtto);
        calculate=(Button)view.findViewById(R.id.btn_calculate);
        auto=(TextView)view.findViewById(R.id.autofare);
        car=(TextView)view.findViewById(R.id.carfare);
        bus=(TextView)view.findViewById(R.id.busfare);
        dist=(TextView)view.findViewById(R.id.dist);
        time=(TextView)view.findViewById(R.id.time);



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                showdetailsfrom();
            }
        });
        return view;
    }

    public void showdetailsfrom(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://test.nyesteventuretech.com/kochi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService api1 = retrofit.create(GitHubService.class);

        api1.getFareDe1().enqueue(new Callback<List<FareDetails1>>() {
            @Override
            public void onResponse(Call<List<FareDetails1>> call, Response<List<FareDetails1>> response) {

                List<FareDetails1> heroList = response.body();
                String[] f1 = new String[heroList.size()];
                String[] t1 = new String[heroList.size()];
                String[] a1 = new String[heroList.size()];
                String[] c1 = new String[heroList.size()];
                String[] b1 = new String[heroList.size()];
                String[] d1 = new String[heroList.size()];
                String[] tt1 = new String[heroList.size()];

                for (int i = 0; i < heroList.size(); i++) {
                    f1[i] = heroList.get(i).getSource();
                    t1[i] = heroList.get(i).getDestination();

                 //   System.out.print(txt_from.getText().toString()+""+txt_from.getText().toString());

                    if (editText1.getText().toString().equals(f1[i])&&editText2.getText().toString().equals(t1[i]))
                  //      if (txt_from.getText().toString().equals(f1[i])&&txt_to.getText().toString().equals(t1[i]))
                    {


                        a1[i] = heroList.get(i).getAutoFare();
                        c1[i] = heroList.get(i).getCarFare();
                        b1[i] = heroList.get(i).getBusFare();
                        d1[i] = heroList.get(i).getDistance();
                        tt1[i] = heroList.get(i).getTimeDuration();

                        auto.setText(a1[i]);
                        car.setText(c1[i]);
                        bus.setText(b1[i]);
                        dist.setText(d1[i]);
                        time.setText(tt1[i]);


                    }
                    else {

                        //textView3.setText("Value is not available");

                    }


                }

                Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<FareDetails1>> call, Throwable t) {
                Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
