package aut.isp.lab4.exercise6;

public class PhSensor extends Sensor {

    private float number;

    public void setNumber(float value) {
        this.number = value;
    }
    public float getNumber() {
        return number;
    }
    public String toString() {
        return "PhSensor [number=" + number + "]";
    }
}
