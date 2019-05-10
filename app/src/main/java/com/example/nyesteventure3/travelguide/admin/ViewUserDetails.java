package com.example.nyesteventure3.travelguide.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nyesteventure3.travelguide.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewUserDetails extends AppCompatActivity {

    ListView listView101;
    String num;
    String[] heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_details);

        listView101 = (ListView) findViewById(R.id.listdata1);

        datafromdb();
    }

    public void datafromdb() {

        String url="http://test.nyesteventuretech.com/kochi/guide/displayuser.php";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://test.nyesteventuretech.com/kochi/")
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Git1Service api123 = retrofit.create(Git1Service.class);


        //Call<List<GuideValues>> call = api.getguidevalues();

        api123.getUserDe1().enqueue(new Callback<List<Exampleget>>() {
            @Override
            public void onResponse(Call<List<Exampleget>> call, Response<List<Exampleget>> response) {


                List<Exampleget> heroList = response.body();
                heroes = new String[heroList.size()];
//                String[] array1 = news_data String[heroList.size()];
//                String loc = null;
//                int j = 0;


                for (int i = 0; i < heroList.size(); i++) {


                    //loc = heroList.get(i).getGuideLoc();
                    //if (loc.equals("Kerala"))


                    heroes[i] = heroList.get(i).getName() + " " + heroList.get(i).getEmail() + " " + heroList.get(i).getAge()+" "+heroList.get(i).getPhone();


                }


                listView101.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes));

                //}

            }

            @Override
            public void onFailure(Call<List<Exampleget>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

