package aut.isp.lab4.exercise4;

public class Lights {
    private Boolean isOn;

    public Lights() {
        this.isOn = false;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public void turnOn(){
        isOn = true;
    }
    public void turnOff(){
        isOn = false;
    }
}