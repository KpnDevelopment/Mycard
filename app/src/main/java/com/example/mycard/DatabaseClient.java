package com.example.mycard;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {
    private  Context mctx;
    private static DatabaseClient mInstance;

    //app database object
    private Mdb_datbase mdb_datbase;

    public DatabaseClient(Context mctx) {
        this.mctx = mctx;
        mdb_datbase= Room.databaseBuilder(mctx,Mdb_datbase.class,"Mechine").build();

    }
    public static synchronized DatabaseClient getInstance(Context context){
        if (mInstance==null){
            mInstance=new DatabaseClient(context);
        }
        return mInstance;
    }
    public Mdb_datbase getAppdatbase(){
        return mdb_datbase;
    }

}
