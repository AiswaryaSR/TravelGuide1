package com.example.nyesteventure3.travelguide.news;

import com.example.nyesteventure3.travelguide.News_Club;
import com.example.nyesteventure3.travelguide.admin.Example;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface News_retrofit
{
    @POST("service/index.php?tag=getNews")
    Call<News_Club> getNews();

}
