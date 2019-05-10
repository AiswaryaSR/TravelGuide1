package com.example.nyesteventure3.travelguide;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class WeatherFragment extends Fragment {

    Button b1;
    TextView w;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_weather_fragment,null,false);
        w=view.findViewById(R.id.weatherr);
        w.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        getActivity().setTitle("Weather");
        b1=(Button)view.findViewById(R.id.btn_next0);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),WeatherActivity.class);
                startActivity(i);
            }
        });

        return view;

    }
}
