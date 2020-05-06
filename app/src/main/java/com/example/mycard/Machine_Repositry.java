package com.example.mycard;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Machine_Repositry {
    private Machine_Dao machine_dao;
    private LiveData<List<Machine_db>>machine;
    private LiveData<List<Machine_db>>machinefil;
    private List<Machine_db>updatefil;

    Machine_Repositry(Application application){
        Mdb_datbase mdb_datbase=Mdb_datbase.getdatabase(application);
        machine_dao=mdb_datbase.mechine_dao();
        machine=machine_dao.getAll();
    }
    LiveData<List<Machine_db>>getMechine(){
        return machine;
    }
    LiveData<List<Machine_db>>getMachinefil(String s){
        machinefil=machine_dao.getfilter(s);
        return machinefil;
    }
    List<Machine_db>getupdate(String st){                //
        updatefil=machine_dao.getupdate(st);
        return updatefil;
    }
    void insertdata(final Machine_db machine_db){
        Mdb_datbase.dbwrite.execute(()->{
            machine_dao.insert(machine_db);

        });
    }
}
