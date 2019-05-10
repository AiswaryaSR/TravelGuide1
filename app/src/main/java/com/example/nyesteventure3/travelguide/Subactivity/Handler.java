package com.example.nyesteventure3.travelguide.Subactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class Handler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "details.db";

    Context context;

    public Handler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1="CREATE TABLE feed_db(_id INTEGER PRIMARY KEY AUTOINCREMENT,emailid TEXT,msg TEXT);";

        db.execSQL(query1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS feed_db");
        onCreate(db);
    }
    public void add(String email22,String msg22)
    {
        ContentValues values=new ContentValues();
        values.put("emailid",email22);
        values.put("msg",msg22);


        SQLiteDatabase sq=getWritableDatabase();
        sq.insert("feed_db",null,values);


        Log.d("email", email22);
        Log.d("message",msg22);
        Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();

    }
    public Cursor feeddisplay()
    {
        SQLiteDatabase sq=getReadableDatabase();
        String q1="SELECT * FROM feed_db";
        Cursor cur=sq.rawQuery(q1,null);
        return cur;
    }

}
