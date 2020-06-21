package com.example.beta;

public class Feedback {
    private String tFeedback, tUsername;

    public Feedback(){

    }

    public Feedback(String tFeedback, String tUsername){
        this.tFeedback = tFeedback;
        this.tUsername = tUsername;
    }

    public String getTUsername(){
        return tUsername;
    }
    public String getTFeedback(){
        return tFeedback;
    }
    public void setTUsername(String tUsername){
        this.tUsername = tUsername;
    }
    public void setTFFeedback(String tFeedback){
        this.tFeedback = tFeedback;
    }
}
