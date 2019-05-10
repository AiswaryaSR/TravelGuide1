package com.example.nyesteventure3.travelguide.Guide;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nyesteventure3.travelguide.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Frag_call extends Fragment {

    ListView listView101;
    String num;
    String[] heroes;
    String lat,lon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_call_for__guide, null, false);

        getActivity().setTitle("Guide");
        listView101 = (ListView) view.findViewById(R.id.listdata);

        datafromdb();

        return view;
    }

    public void datafromdb() {

        String url = "http://test.nyesteventuretech.com/kochi/guide/displayguided.php";
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
                String[] array1 = new String[heroList.size()];
                String loc = null;
                int j = 0;


                for (int i = 0; i < heroList.size(); i++) {


                    loc = heroList.get(i).getGuideLoc();
                    //if (loc.equals("Kerala"))


                    heroes[i] = heroList.get(i).getGuideName() + " " + heroList.get(i).getGuidePh() + " " + loc;


                }


                listView101.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, heroes));

                //}

            }

            @Override
            public void onFailure(Call<List<GuideValues>> call, Throwable t) {
                Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();
            }
        });

        listView101.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                num = heroes[position];
                System.out.println("Number" + " " + num);

                int space = num.indexOf(" ");

                System.out.println("space" + " " + space);


                final String sub = num.substring(space + 1, space + 11);
                System.out.println("Number13" + " " + sub);


                String[] colors = {"Share location", "Call Guide"};
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Select option");
                builder.setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {

                            final Button getLoc, shareLoc;
                            final TextView location12;
                            final ProgressBar progressBar;

                            Dialog dialog1 = new Dialog(getActivity());
                            dialog1.setContentView(R.layout.dialogue_sharelocation);
                            getLoc = dialog1.findViewById(R.id.button1);
                            shareLoc = dialog1.findViewById(R.id.button2);
                            location12 = dialog1.findViewById(R.id.locate);
                            progressBar = dialog1.findViewById(R.id.progress);

                            shareLoc.setEnabled(false);

                            getLoc.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    LocationManager locationManager =
                                            (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
// Define a listener that responds to location updates
                                    LocationListener locationListener = new LocationListener() {
                                        public void onLocationChanged(Location location) {
// Called when a new location is found by the network location provider.
                                            lat = Double.toString(location.getLatitude());
                                            lon = Double.toString(location.getLongitude());
                                            location12.setText("Latitude:" + lat + "  Longitude:" + lon);
                                            progressBar.setVisibility(View.GONE);

                                            shareLoc.setEnabled(true);
                                        }


                                        public void onStatusChanged(String provider, int status, Bundle extras) {
                                        }

                                        public void onProviderEnabled(String provider) {
                                        }

                                        public void onProviderDisabled(String provider) {
                                        }
                                    };
// Register the listener with the Location Manager to receive location updates
                                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                        // TODO: Consider calling
                                        //    ActivityCompat#requestPermissions
                                        // here to request the missing permissions, and then overriding
                                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                        //                                          int[] grantResults)
                                        // to handle the case where the user grants the permission. See the documentation
                                        // for ActivityCompat#requestPermissions for more details.
                                        return;
                                    }
                                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);


                                }
                            });
                            shareLoc.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    GetAddress(lat, lon, sub,location12);


                                }
                            });

                            dialog1.show();

                        }

                        else
                        {
                            if(!TextUtils.isEmpty(sub)) {
                                String dial = "tel:" + sub;
                                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                            }
                            else
                                {

                            }

                        }

                        // the user clicked on colors[which] } }); builder.show();
                    }
                    });

                builder.show();
                // ListModel dataModel= dataModels.get(position);

                //Snackbar.make(view, dataModel.getName()+"\n"+dataModel.getType()+" API: "+dataModel.getVersion_number(), Snackbar.LENGTH_LONG)
                //      .setAction("No action", null).show();
            }
        });

    }

    public String GetAddress(String lat, String lon, String sub, TextView location12)
    {
        Geocoder geocoder = new Geocoder(getActivity(), Locale.ENGLISH);
        String ret = "";
        try {
            List<Address> addresses = geocoder.getFromLocation(Double.parseDouble(lat), Double.parseDouble(lon), 1);
            if(addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("Address:\n");
                strReturnedAddress.append(returnedAddress.getAddressLine(0)).append("\n");
                strReturnedAddress.append("Latitude:"+returnedAddress.getLatitude()).append("\n");
                strReturnedAddress.append("Longitude:"+returnedAddress.getLongitude()).append("\n");


                ret = strReturnedAddress.toString();
                location12.setText(ret);
                SmsManager sm = SmsManager.getDefault();
                sm.sendTextMessage(sub,null,ret,null,null);
            }
            else{
                ret = "No Address returned!";
            }
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
            ret = "Can't get Address!";
        }
        return ret;
    }

}
