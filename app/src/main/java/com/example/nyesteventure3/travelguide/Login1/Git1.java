package com.example.nyesteventure3.travelguide.Login1;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Git1 {

    @POST("guide/adduser.php")
    @FormUrlEncoded
    Call<Example123> apicreate(@FieldMap HashMap<String,String> hashMap);



    @GET("guide/displayuser.php")
    Call<List<ExampleLog>> getUserDe1();
}
