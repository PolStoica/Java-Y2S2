package aut.isp.lab4.exercise6;

public class LevelSensor extends Sensor {
    private float value=3;

    public float getValue(){
        return value;
    }
    public void setValue(float value){
        this.value = value;
    }
    public String toString(){
        return "The value of the water currently is: "+ value + " .";
    }
}
