package com.example.mycard;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Machine_db  {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "serialno")
    private String serialno;

    @ColumnInfo(name = "district")
    private String district;

    @ColumnInfo(name = "state")
    private String state;

    @ColumnInfo(name = "location")
    private String location;

    @ColumnInfo(name = "warranty" )
    private String warranty;

    @ColumnInfo(name = "working")
    private String working;

    public Machine_db( String serialno, String district, String state, String location,String warranty,String working) {
//        this.id = id;
        this.serialno = serialno;
        this.district = district;
        this.state = state;
        this.location = location;
        this.warranty=warranty;
        this.working=working;
    }

//    getetr & setter


    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getWorking() {
        return working;
    }

    public void setWorking(String working) {
        this.working = working;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
