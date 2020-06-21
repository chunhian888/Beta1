package com.example.beta;

public class Management {
    private String mLocation, mName, mPassword, mUsername;

    public Management(){

    }

    public Management(String mUsername, String mPassword){
        this.mUsername = mUsername;
        this.mPassword = mPassword;
        this.mLocation = mLocation;
        this.mName = mName;
    }

    public String getMUsername(){ return mUsername; }

    public String getMPassword(){ return mPassword; }
    public String getMLocation(){
        return mLocation;
    }

    public String getMName(){
        return mName;
    }

    public void setMUsername(String mUsername){
        this.mUsername = mUsername;
    }

    public void setMPassword(String mPassword){
        this.mPassword = mPassword;
    }
    public void setMLocation(String mLocation){
        this.mLocation = mLocation;
    }
    public void setMName  (String mName){
        this.mName = mName;
    }

}
