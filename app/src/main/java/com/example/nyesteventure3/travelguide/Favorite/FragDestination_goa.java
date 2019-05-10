package com.example.nyesteventure3.travelguide.Favorite;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nyesteventure3.travelguide.R;
import com.example.nyesteventure3.travelguide.details.goadetails;

public class FragDestination_goa extends Fragment {

    ListView listView;
    String[] list={"Baga Beach","Calangute Beach","Palolem beach","Anjuna beach","Basilica of Bom Jesus","Cruise","Dudhsagar Waterfalls","Fort Aguada"};
    TextView viewGoa;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_favorite__destination,null,false);
        getActivity().setTitle("Favorite Destinations in Goa");

        listView=(ListView)view.findViewById(R.id.list_fav_kerala);
        viewGoa=(TextView)view.findViewById(R.id.view_kerala);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, android.R.id.text1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getContext(),goadetails.class);
                String mess=list[position];
                intent.putExtra("value1",mess);
                startActivity(intent);
            }
        });
        viewGoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n=new Intent(getContext(),goadetails.class);
                startActivity(n);
            }
        });
        return view;
    }
}
