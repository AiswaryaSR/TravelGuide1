package com.example.nyesteventure3.travelguide.Guide;

import com.example.nyesteventure3.travelguide.admin.Example;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Git {

//    String url="http://test.nyesteventuretech.com/kochi/guide/addgd.php";
//    String url1="http://test.nyesteventuretech.com/kochi/guide/displayguided.php";
//
@GET("guide/displayguided.php")
Call<List<GuideValues>> getguidevalues();

    @POST("guide/addgd.php")
    @FormUrlEncoded
    Call<Example> createguide(@FieldMap HashMap<String,String> hashMap);



}
