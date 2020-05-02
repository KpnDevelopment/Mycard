package com.example.mycard;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class Machine_ViewModel extends AndroidViewModel {
    private Machine_Repositry repositry;
    private LiveData<List<Machine_db>>getmachine;


    public Machine_ViewModel(@NonNull Application application) {
        super(application);
         repositry = new Machine_Repositry(application);
         getmachine = repositry.getMechine();
    }
    public LiveData<List<Machine_db>>getmachine() {
        return getmachine;
    }
    public void insert(Machine_db machine_db){ repositry.insertdata(machine_db);}
}


