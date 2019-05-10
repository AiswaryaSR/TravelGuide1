package com.example.nyesteventure3.travelguide;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.nyesteventure3.travelguide.Fare.Fare_banglore;
import com.example.nyesteventure3.travelguide.Fare.Fare_delhi;
import com.example.nyesteventure3.travelguide.Fare.Fare_goa;
import com.example.nyesteventure3.travelguide.Fare.Fare_kerala;
import com.example.nyesteventure3.travelguide.Fare.Fare_kolkatha;
import com.example.nyesteventure3.travelguide.Fare.Frag_mumbai;
import com.example.nyesteventure3.travelguide.Favorite.FragDestination_banglore;
import com.example.nyesteventure3.travelguide.Favorite.FragDestination_delhi;
import com.example.nyesteventure3.travelguide.Favorite.FragDestination_goa;
import com.example.nyesteventure3.travelguide.Favorite.FragDestination_kerala;
import com.example.nyesteventure3.travelguide.Favorite.FragDestination_kolkatha;
import com.example.nyesteventure3.travelguide.Favorite.FragDestination_mumbai;
import com.example.nyesteventure3.travelguide.Guide.Frag_call;
import com.example.nyesteventure3.travelguide.Guide.Frag_call_banglore;
import com.example.nyesteventure3.travelguide.Guide.Frag_call_delhi;
import com.example.nyesteventure3.travelguide.Guide.Frag_call_goa;
import com.example.nyesteventure3.travelguide.Guide.Frag_call_kolkatha;
import com.example.nyesteventure3.travelguide.Guide.Frag_call_mumbai;
import com.example.nyesteventure3.travelguide.Subactivity.Frag_Feed;
import com.example.nyesteventure3.travelguide.Subactivity.Frag_Index;
import com.example.nyesteventure3.travelguide.Subactivity.Frag_language;
import com.example.nyesteventure3.travelguide.Subactivity.Fragabout;
import com.example.nyesteventure3.travelguide.Subactivity.Mapdemo;

public class HomePage1 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String tag;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page1);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(tag.equals("kerala"))
                {
                    Frag_call fragmentf1=new Frag_call();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentf1).commit();
                }
                if(tag.equals("goa"))
                {
                    Frag_call_goa fragmentf2=new Frag_call_goa();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentf2).commit();
                }
                if(tag.equals("mumbai"))
                {
                    Frag_call_mumbai fragmentf3=new Frag_call_mumbai();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentf3).commit();
                }
                if(tag.equals("kolkatha"))
                {
                    Frag_call_kolkatha fragmentf4=new Frag_call_kolkatha();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentf4).commit();
                }
                if(tag.equals("delhi"))
                {
                    Frag_call_delhi fragmentf5=new Frag_call_delhi();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentf5).commit();
                }
                if(tag.equals("banglore"))
                {
                    Frag_call_banglore fragmentf6=new Frag_call_banglore();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentf6).commit();
                }



//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tag=getIntent().getStringExtra("tag");

        if(savedInstanceState==null)
        {
            Frag_Index fragmentc0=new Frag_Index();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentc0).commit();
        }



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_lang)
        {
            Frag_language fragmentf1=new Frag_language();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentf1).commit();


        } else if (id == R.id.nav_cost)
        {

            if(tag.equals("kerala"))
            {
                //Fare_kerala fragmentf1=news_data Fare_kerala();
                Fare_kerala fragmentf1=new Fare_kerala();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentf1).commit();
            }
            if(tag.equals("goa"))
            {
                Fare_goa fragmentf2=new Fare_goa();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentf2).commit();
            }
            if(tag.equals("mumbai"))
            {
                Frag_mumbai fragmentf3=new Frag_mumbai();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentf3).commit();
            }
            if(tag.equals("kolkatha"))
            {
                Fare_kolkatha fragmentf4=new Fare_kolkatha();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentf4).commit();
            }
            if(tag.equals("delhi"))
            {
                Fare_delhi fragmentf5=new Fare_delhi();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentf5).commit();
            }
            if(tag.equals("banglore"))
            {
                Fare_banglore fragmentf6=new Fare_banglore();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentf6).commit();
            }


        } else if (id == R.id.nav_dest)
        {


            if(tag.equals("kerala"))
            {
                FragDestination_kerala fragmenttt=new FragDestination_kerala();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmenttt).commit();
            }
            if(tag.equals("goa"))
            {
                FragDestination_goa fragmenttt1=new FragDestination_goa();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmenttt1).commit();
            }
            if(tag.equals("mumbai"))
            {
                FragDestination_mumbai fragmenttt2=new FragDestination_mumbai();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmenttt2).commit();
            }
            if(tag.equals("kolkatha"))
            {
                FragDestination_kolkatha fragmenttt3=new FragDestination_kolkatha();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmenttt3).commit();
            }
            if(tag.equals("delhi"))
            {
                FragDestination_delhi fragmenttt4=new FragDestination_delhi();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmenttt4).commit();
            }
            if(tag.equals("banglore"))
            {
                FragDestination_banglore fragmenttt5=new FragDestination_banglore();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmenttt5).commit();
            }



        } else if (id == R.id.nav_map) {

           // Mapdemo fragmentc=news_data Mapdemo();
            MapsFragt fragmentc=new MapsFragt();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentc).commit();


        }else if (id==R.id.news)
        {
            NewsFragment fragmentNews=new  NewsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentNews).commit();
        }
        else if(id==R.id.weather)
        {
         WeatherFragment fragmentWeather=new WeatherFragment();
         getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragmentWeather).commit();
        }
        else if (id == R.id.nav_about) {

            Fragabout frag=new Fragabout();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,frag).commit();

        }
        else if (id == R.id.feed) {

            Frag_Feed frag1=new Frag_Feed();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,frag1).commit();

        }
        else if (id == R.id.nav_exit) {


            AlertDialog.Builder builder1=new AlertDialog.Builder(HomePage1.this);
            builder1.setTitle("Travel Guide Says!");
            builder1.setMessage("Do you want to Exit");
            builder1.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finishAffinity();
                    System.exit(0);
                }
            });
            builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder1.show();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
