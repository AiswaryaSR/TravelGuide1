package com.example.nyesteventure3.travelguide.admin;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.nyesteventure3.travelguide.R;

public class ListAdapter2  extends CursorAdapter {


    TextView email,msg;
    String email3,msg3;
    public ListAdapter2(Context c, Cursor cor)

    {
        super(c,cor);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.list,null);
        return view;
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        email=(TextView)view.findViewById(R.id.name3);
        msg=(TextView)view.findViewById(R.id.pass3);


        email3=cursor.getString(cursor.getColumnIndexOrThrow("emailid"));
        msg3=cursor.getString(cursor.getColumnIndexOrThrow("msg"));

        email.setText(email3);
        msg.setText(msg3);

    }
}

