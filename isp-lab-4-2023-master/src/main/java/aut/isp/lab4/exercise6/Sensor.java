package aut.isp.lab4.exercise6;

public class Sensor {
    private String manufacturer;
    private String model;
    private String unitOfMeasurement;

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }
    public String toString(){
        return "The unit of measurement is: " + unitOfMeasurement;
    }
}
