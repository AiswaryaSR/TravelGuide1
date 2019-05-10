package com.example.nyesteventure3.travelguide.Fare;

import com.example.nyesteventure3.travelguide.admin.datassetto;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GitHubService {

    @GET("guide/displayfared.php")
    Call<List<FareDetails1>> getFareDe1();

    @POST("guide/addfare.php")
    @FormUrlEncoded
    Call<datassetto> create1(@FieldMap HashMap<String,String> hashMap);

}
