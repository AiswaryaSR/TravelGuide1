package com.example.nyesteventure3.travelguide.Subactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nyesteventure3.travelguide.R;

public class Fragabout extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("AboutUs");
        View view=inflater.inflate(R.layout.activity_frag_about1,null,false);
        return view;
    }
}
