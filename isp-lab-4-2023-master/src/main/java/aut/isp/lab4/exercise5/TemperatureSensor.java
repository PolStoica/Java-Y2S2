package aut.isp.lab4.exercise5;

public class TemperatureSensor extends Sensor {
    private int value=23;

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String toString(){
        return "The temperature inside is: " + value+" .";
    }
}
