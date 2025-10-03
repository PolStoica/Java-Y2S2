package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise3.FishFeeder;

public class AquariumController {

    FishFeeder feeder= new FishFeeder();
    Lights light = new Lights();
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private float lightOnTime;
    private float lightOffTime;


    public AquariumController(String manufacturer, String model, float currentTime, float feedingTime, float lightOnTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.lightOnTime = lightOnTime;
        this.lightOffTime = 24-lightOnTime;
    }

    public AquariumController(String manufacturer, String model, float currentTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
    }

    public AquariumController() {
        this.manufacturer = "None";
        this.model = "None";
        this.currentTime = 0;
        this.feedingTime = 0.1F;
        this.lightOnTime = 0;
        this.lightOffTime = 17;
    }

    public AquariumController(String bosch, String model1, float v, float v1, float v2, int i) {
    }

    public void setCurrentTime(float currentTime) {
        if (currentTime>=0){
            this.currentTime = currentTime;
            if (currentTime == feedingTime){
                feeder.feed();
            }
            if (lightOffTime == 17){
                light.turnOn();
                lightOffTime = 0;
            }
            if (lightOnTime == 7){
                light.turnOff();
                lightOnTime = 0;
            }
        }
        else {
            throw new IllegalArgumentException("Time cannot be negative");
        }
    }

    public  void setFeedingTime(float feedingTime) {
        if (feedingTime>=0) {
            this.feedingTime = feedingTime;
        }else{
            throw new IllegalArgumentException("Time cannot be negative");
        }
    }

    public float getFeedingTime(){
        return feedingTime;
    }

    public float getCurrentTime() {
        return currentTime;
    }

    public String toString(){
        return "The manufacturer is:"+ manufacturer+ ". The model is:"+ model+". The current time is:"+ currentTime+ ". The feeding time is:"+
                feedingTime+ ". The light has been on for:"+lightOnTime+". The light has been off for:"+lightOffTime ;
    }
}