package com.example.beta;

public class Tenant {
    private String tUsername, tPassword, tBlock, tUnit;
    private String tMFees;
    public Tenant(){

    }

    public Tenant(String tUsername, String tPassword){
        this.tUsername = tUsername;
        this.tPassword = tPassword;
        this.tBlock = tBlock;
        this.tUnit = tUnit;
    }

    public String getTUsername(){ return tUsername; }

    public String getTPassword(){ return tPassword; }
    public String getTBlock(){
        return tBlock;
    }

    public String getTUnit(){
        return tUnit;
    }

    public void setTUsername(String tUsername){
        this.tUsername = tUsername;
    }

    public void setTPassword(String tPassword){
        this.tPassword = tPassword;
    }
    public void setTBlock(String tBlock){
        this.tBlock = tBlock;
    }
    public void setTUnit  (String tUnit){
        this.tUnit = tUnit;
    }

    public String getTMFees(){ return tMFees; }
    public void setTMFees(String tMFees){ this.tMFees = tMFees; }

}