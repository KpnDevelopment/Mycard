package com.example.mycard;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Machine_db.class},version=1,exportSchema = false)
public abstract class Mdb_datbase extends RoomDatabase {
    public abstract Machine_Dao mechine_dao();
    private static volatile Mdb_datbase Instance;
    private static final int THREADS=4;
    static final ExecutorService dbwrite= Executors.newFixedThreadPool(THREADS);
    static Mdb_datbase getdatabase(final Context context)
    {
        if (Instance==null){
            synchronized (Mdb_datbase.class){
                if (Instance==null){
                    Instance= Room.databaseBuilder(context.getApplicationContext(),Mdb_datbase.class,"Machinedatabase").build();
                }
            }
        }
        return Instance;
    }
}
