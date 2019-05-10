package com.example.nyesteventure3.travelguide.Guide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class Frag_call_banglore extends Fragment {

    ListView listView101;
    String num;
    String[] heroes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_call_for__guide,null,false);

        getActivity().setTitle("Guide");
        listView101=(ListView)view.findViewById(R.id.listdata);

        datafromdb();

        return view;
    }

    public void datafromdb(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://test.nyesteventuretech.com/kochi/")
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Git api123 = retrofit.create(Git.class);

        //Call<List<GuideValues>> call = api.getguidevalues();

        api123.getguidevalues().enqueue(new Callback<List<GuideValues>>() {
            @Override
            public void onResponse(Call<List<GuideValues>> call, Response<List<GuideValues>> response) {



                List<GuideValues> heroList = response.body();
                 heroes = new String[heroList.size()];


                for (int i = 0; i < heroList.size(); i++) {
                    String loc=heroList.get(i).getGuideLoc();
//                    if (loc.equals("Banglore"))
//                    {
                        heroes[i] = heroList.get(i).getGuideName() + " " + heroList.get(i).getGuidePh()+" "+loc;
                    //}
//                    else {
//                        heroes[i]="No Contacts";
//                    }
                }



                listView101.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, heroes));


            }

            @Override
            public void onFailure(Call<List<GuideValues>> call, Throwable t) {
                Toast.makeText(getContext(),"Failure", Toast.LENGTH_SHORT).show();
            }
        });
        listView101.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                num=heroes[position];
                System.out.println("Number"+" "+num);

                int space=num.indexOf(" ");

                System.out.println("space"+" "+space);


                String sub=num.substring(space+1,space+11);
                System.out.println("Number13"+" "+sub);

                if(!TextUtils.isEmpty(sub)) {
                    String dial = "tel:" + sub;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }
                else {

                }


                // ListModel dataModel= dataModels.get(position);

                //Snackbar.make(view, dataModel.getName()+"\n"+dataModel.getType()+" API: "+dataModel.getVersion_number(), Snackbar.LENGTH_LONG)
                //      .setAction("No action", null).show();
            }
        });


    }

}
