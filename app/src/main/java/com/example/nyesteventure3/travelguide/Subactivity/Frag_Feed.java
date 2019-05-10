package com.example.nyesteventure3.travelguide.Subactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nyesteventure3.travelguide.R;

public class Frag_Feed extends Fragment {
    EditText editText11,editText22;
    Button button11;
    String email2,msg2;

    private RatingBar ratingBar;

    private TextView tvRateCount,tvRateMessage;

    private float ratedValue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Feedback");
        View view=inflater.inflate(R.layout.activity_feedback,null,false);

        editText11=(EditText)view.findViewById(R.id.email1);
        editText22=(EditText)view.findViewById(R.id.msg);
        button11=(Button)view.findViewById(R.id.save11);

        ratingBar = (RatingBar)view.findViewById(R.id.ratingbar);

        tvRateCount = (TextView)view.findViewById(R.id.ratingcount);

        tvRateMessage = (TextView)view.findViewById(R.id.ratingmessage);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override

            public void onRatingChanged(RatingBar ratingBar, float rating,

                                        boolean fromUser) {

                ratedValue = ratingBar.getRating();

                tvRateCount.setText("Your Rating : "

                        + ratedValue + "/5.");

                if(ratedValue<1){

                    tvRateMessage.setText("ohh ho...");

                }else if(ratedValue<2){

                    tvRateMessage.setText("Ok.");

                }else if(ratedValue<3){

                    tvRateMessage.setText("Not bad.");

                }else if(ratedValue<4){

                    tvRateMessage.setText("Nice");

                }else if(ratedValue<5){

                    tvRateMessage.setText("Very Nice");

                }else if(ratedValue==5){

                    tvRateMessage.setText("Thank you..!!!");

                }

            }

        });


        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savefeedback();
            }
        });
        return view;
    }
    public void savefeedback()
    {

        boolean flag=true;
        if(editText11.getText().toString().equals(""))
        {
            flag=false;
            editText11.setError("Enter the name");
        }
        if(editText22.getText().toString().equals(""))
        {
            flag=false;
            editText22.setError("Enter the password");
        }


        if(flag==true)
        {


            email2=editText11.getText().toString();
            msg2=editText22.getText().toString();





            Handler hd=new Handler(getContext());
            hd.add(email2,msg2);


           editText11.setText(" ");
           editText22.setText(" ");

        }

    }
}
