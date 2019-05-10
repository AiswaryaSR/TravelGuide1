
package com.example.nyesteventure3.travelguide;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyHolder> {
    Context context;
    List<News_Club.News> news_details;

    public NewsAdapter(Context con, List<News_Club.News> news) {
        this.context = con;
        this.news_details = news;

    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_news_adapter, viewGroup, false);
        RecyclerView.ViewHolder holder = new MyHolder(view);

        return (MyHolder) holder;
    }
    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i)
    {
        String url="http://street.nyesteventuretech.com/travelguide/Admin/uploads/"+news_details.get(i).getImage();
        Glide.with(context).load(url).into(myHolder.imageView);

        myHolder.title.setText(news_details.get(i).getPlace());
        myHolder.date.setText(news_details.get(i).getDateCreated());
        myHolder.current_news.setText(news_details.get(i).getMessage());
      /*  myHolder.layout.setOnClickListener(news_data View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = news_data Intent(context,NewsActivity.class);
               // intent.putExtra("id",shop_details.get(i).getId());
               // intent.putExtra("name",shop_details.get(i).getName());
               // intent.putExtra("address",shop_details.get(i).getStreet()+","+shop_details.get(i).getCity()+","+shop_details.get(i).getDistrict());
               // intent.putExtra("phone",shop_details.get(i).getMobile());
                context.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return news_details.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        LinearLayout layout;
        AppCompatTextView title,date,current_news;

        public MyHolder(@NonNull View itemView)
        {
            super(itemView);
         imageView=itemView.findViewById(R.id.light);
         layout=itemView.findViewById(R.id.layout);
         title=itemView.findViewById(R.id.news_title);
         date=itemView.findViewById(R.id.date);
         current_news=itemView.findViewById(R.id.news);


        }


    }

}
