package aut.isp.lab4.exercise1;

public class AquariumController {

    private String manufacturer;
    private String model;
    private float currentTime;

    public AquariumController(String manufacturer, String model, float currentTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
    }

    public void setCurrentTime(float currentTime) {
        if (currentTime>=0){
            this.currentTime = currentTime;
        }
        else {
            throw new IllegalArgumentException("Time cannot be negative");
        }
    }

    public float getCurrentTime() {
        return currentTime;
    }

    public String toString(){
        return "The manufacturer is:"+ manufacturer+". The model is:"+ model+". The current time is:"+ currentTime;
    }
}
