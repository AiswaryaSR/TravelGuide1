package com.example.nyesteventure3.travelguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;
    Timer timer;
    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=(ProgressBar)findViewById(R.id.pro1);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        //sprogressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN);//  setProgressTintList());
        textView=(TextView)findViewById(R.id.text1);
        textView.setText("");


        final long period = 50;
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //this repeats every 100 ms
                if (i<100){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(String.valueOf(i)+"%");
                        }
                    });
                    progressBar.setProgress(i);
                    i++;
                }else{
                    //closing the timer
                    timer.cancel();
                    Intent intent =new Intent(MainActivity.this,welcome1.class);
                    startActivity(intent);
                    // close this activity
                    finish();
                }
            }
        }, 0, period);

    }
}
