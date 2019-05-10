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

public class NewsFragment extends Fragment {

    Button b1;
    TextView n;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_news,null,false);
getActivity().setTitle("News");
        n=view.findViewById(R.id.newss);
        n.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        b1=(Button)view.findViewById(R.id.btn_next0);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),NewsActivity.class);
                startActivity(i);
            }
        });

        return view;

    }
}
