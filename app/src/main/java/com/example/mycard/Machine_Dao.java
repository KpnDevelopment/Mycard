package com.example.mycard;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface Machine_Dao {
    @Query("SELECT * FROM Machine_db")
    LiveData<List<Machine_db>>getAll();
    //@Query("SELECT * FROM Machine_db WHERE ")
    @Insert
    void insert(Machine_db machine_db);
    @Delete
    void delete(Machine_db machine_db);
    @Update
    void update(Machine_db machine_db);



}
