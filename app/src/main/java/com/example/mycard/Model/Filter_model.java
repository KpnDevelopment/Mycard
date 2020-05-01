package com.example.mycard.Model;

public class Filter_model {
    private String serialno,district,location,state;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Filter_model(String serialno, String district, String location, String state) {
        this.serialno = serialno;
        this.district = district;
        this.location = location;
        this.state = state;
    }
}
