package com.example.nyesteventure3.travelguide.admin;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Git1Service {


    @POST("guide/addgd.php")
    @FormUrlEncoded
    Call<Example> crguidede(@FieldMap HashMap<String,String> hashMap);

    @GET("guide/displayuser.php")
    Call<List<Exampleget>> getUserDe1();

}
