package com.example.mycard;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

public class Machine_ViewModel extends AndroidViewModel {
    private Machine_Repositry repositry;
    private LiveData<List<Machine_db>>getmachine;
    private LiveData<List<Machine_db>>getfilter;
    private List<Machine_db>getup;
    private MutableLiveData<String>mutableLiveData=new MutableLiveData<>();


    public Machine_ViewModel(@NonNull Application application) {
        super(application);
         repositry = new Machine_Repositry(application);
         getmachine = repositry.getMechine();
         getfilter= Transformations.switchMap(mutableLiveData,c->repositry.getMachinefil(c)); // c is the searching object
    }
    public LiveData<List<Machine_db>>getmachine() {
        return getmachine;
    }
    public void insert(Machine_db machine_db){ repositry.insertdata(machine_db);}
    void pass(String st){
        mutableLiveData.setValue(st);
    }
    public LiveData<List<Machine_db>>reMechine(){
        return getfilter;

    }
}


