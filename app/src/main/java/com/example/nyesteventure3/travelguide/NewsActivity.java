package com.example.nyesteventure3.travelguide;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.nyesteventure3.travelguide.news.News_retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news2);

        final RecyclerView recyclerView=findViewById(R.id.my_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(NewsActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://street.nyesteventuretech.com/travelguide/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        News_retrofit news_retrofit= retrofit.create(News_retrofit.class);
        news_retrofit.getNews().enqueue(new Callback<News_Club>() {
            @Override
            public void onResponse(Call<News_Club> call, Response<News_Club> response)
            {
                NewsAdapter newsAdapter=new NewsAdapter(NewsActivity.this,response.body().getNews());
                recyclerView.setAdapter(newsAdapter);
            }

            @Override
            public void onFailure(Call<News_Club> call, Throwable t) {

            }
        });

    }
}
