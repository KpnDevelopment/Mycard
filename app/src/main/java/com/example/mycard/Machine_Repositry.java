package com.example.mycard;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Machine_Repositry {
    private Machine_Dao machine_dao;
    private LiveData<List<Machine_db>>machine;

    Machine_Repositry(Application application){
        Machine_db machine_db=Machine_db.getdatabase(application);
        machine_dao=machine_db.machine_dao();
        machine=machine_dao.getMechine();
    }
    LiveData<List<Machine_db>>getMechine(){
        return machine;
    }
    void insertdata(final Machine_db machine_db){
        Machine_db.databasewrite.execute(()->{
            machine_dao.insert(machine_db);
        });
    }
}
