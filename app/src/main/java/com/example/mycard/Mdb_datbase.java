package com.example.mycard;

import androidx.room.RoomDatabase;

public abstract class Mdb_datbase extends RoomDatabase {
    public abstract Machine_Dao mechine_dao();
}
