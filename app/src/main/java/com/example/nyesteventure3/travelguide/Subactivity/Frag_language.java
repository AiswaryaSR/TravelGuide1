package com.example.nyesteventure3.travelguide.Subactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.nyesteventure3.travelguide.R;

public class Frag_language extends Fragment {
    ImageButton tr_camera,tr_voice;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getActivity().setTitle("Linguistic Translator");

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        View view=inflater.inflate(R.layout.activity_language_translator,null,false);
        tr_camera=(ImageButton)view.findViewById(R.id.tr_camera);
        tr_voice=(ImageButton)view.findViewById(R.id.tr_voice);

        tr_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Camera started");
                Intent i2=new Intent(getContext(), Ocractivity.class);
                startActivity(i2);
            }
        });
        tr_voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(getContext(),Speech1.class);
                startActivity(i2);
            }
        });

        return view;
    }
}
