package com.example.nyesteventure3.travelguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MapsFragt extends Fragment {
    Button b1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_maps_demo0,null,false);
getActivity().setTitle("Map");

        b1=(Button)view.findViewById(R.id.btn_next0);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),MapsActivity.class);
                startActivity(i);
            }
        });

        return view;

    }
}
