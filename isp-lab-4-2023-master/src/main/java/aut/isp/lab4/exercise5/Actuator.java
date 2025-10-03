package aut.isp.lab4.exercise5;

public class Actuator {
    private String manufacturer;
    private String model;
    private boolean isOn;

    public boolean getIsOn() {
        return isOn;
    }

    public void turnOn(){
        isOn = true;
    }
    public void turnOff(){
        isOn = false;
    }
    public String toString(){
        if (isOn){
            return "The actuator is: on .";
        }else {
            return "The actuator is: off .";
        }
    }
}
