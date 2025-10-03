package aut.isp.lab4.exercise5;

public class AquariumController {

    private FishFeeder feeder= new FishFeeder();
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private int presetTemperature;
    private float presetLevel;
    private LevelSensor lvlSensor= new LevelSensor();
    private TemperatureSensor tempSensor = new TemperatureSensor();
    private Actuator alarm = new Actuator();
    private Actuator heater = new Actuator();

    public AquariumController( String manufacturer, String model, float currentTime,
                               float feedingTime, float presetLevel, int presetTemperature) {
        this.presetLevel = presetLevel;
        this.presetTemperature = presetTemperature;
        this.feedingTime = feedingTime;
        this.currentTime = currentTime;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public AquariumController(String nume){

    }

    public AquariumController() {
        this.presetLevel = 2;
        this.presetTemperature = 24;
        this.feedingTime = 0;
        this.currentTime = 0;
        this.model = "Model";
        this.manufacturer = "Manufacturer";
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

    public int getPresetTemperature() {
        return presetTemperature;
    }

    public float getPresetLevel() {
        return presetLevel;
    }

    public void checkTemperature(){
        if(tempSensor.getValue()<presetTemperature){
            heater.turnOn();
        }
        if(tempSensor.getValue()==presetTemperature){
            heater.turnOff();
        }
    }
    public Actuator getHeater() {
        return heater;
    }
    public void checkWaterLevel(){
        if(lvlSensor.getValue()>presetLevel){
            alarm.turnOn();
        }
        if(lvlSensor.getValue()==presetLevel){
            alarm.turnOff();
        }
    }
    public Actuator getAlarm() {
        return alarm;
    }

    public String toString(){
        return "The manufacturer is: "+manufacturer + ". The model is: " + model + ". The current time is: " + currentTime + ", the feeding time is: " + feedingTime + "," +
                " the preset water level is: " + presetLevel + " and the temperature is " + presetTemperature+".";
    }
}