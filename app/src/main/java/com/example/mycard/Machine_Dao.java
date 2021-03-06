package com.example.mycard;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao

public interface Machine_Dao {
    @Query("SELECT * FROM Machine_db")
    LiveData<List<Machine_db>>getAll();
    @Query("SELECT * FROM Machine_db WHERE serialno=:string OR district=:string OR state=:string OR location=:string OR warranty=:string OR working=:string")
    LiveData<List<Machine_db>> getfilter(String string);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Machine_db machine_db);
    @Delete
    void delete(Machine_db machine_db);
    @Update
    void update(Machine_db machine_db);
    
    @Query("SELECT * FROM Machine_db WHERE serialno=:st") //
    List<Machine_db>getupdate(String st);

    @Query("UPDATE Machine_db SET location=:locate,district=:dist,state=:stat,warranty=:war,working=:work WHERE serialno=:slno")
    void updateVal(String locate,String dist,String stat,String slno,String war,String work);
    @Query("DELETE FROM Machine_db WHERE serialno=:slno")
    void deleteVal(String slno);



}
