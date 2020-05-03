package com.example.mycard;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Machine_db  {
    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "serialno")
    private String serialno;

    @ColumnInfo(name = "district")
    private String district;

    @ColumnInfo(name = "state")
    private String state;

    @ColumnInfo(name = "location")
    private String location;

    public Machine_db( String serialno, String district, String state, String location) {
//        this.id = id;
        this.serialno = serialno;
        this.district = district;
        this.state = state;
        this.location = location;
    }

    //getetr & setter


//    public int getId() {
//        return id;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }

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
