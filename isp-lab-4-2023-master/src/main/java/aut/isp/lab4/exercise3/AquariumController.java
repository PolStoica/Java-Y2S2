package aut.isp.lab4.exercise3;

public class AquariumController {

    FishFeeder feeder= new FishFeeder();
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;


    public AquariumController(String manufacturer, String model, float currentTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
    }

    public void setCurrentTime(float currentTime) {
        if (currentTime>=0){
            this.currentTime = currentTime;
            if (currentTime == feedingTime){
                feeder.feed();
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
        return "The manufacturer is:"+ manufacturer+". The model is:"+ model+". The current time is:"+ currentTime;
    }
}