package isp.lab3.exercise3;

public class Vehicle
{
    private String model;
    private String type;
    private int speed;
    private char fuelType;
    static int counter = 0;

    public Vehicle(String model, String type, int speed, char fuelType) {
        this.model = model;
        this.type = type;
        this.speed = speed;
        if (fuelType == 'D' || fuelType == 'B'){
            this.fuelType = fuelType;
        }else {
            throw new IllegalArgumentException("Invalid fuel type");
        }
        counter++;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public char getFuelType() {
        return fuelType;
    }
    public void setFuelType(char fuelType) {
        if (fuelType == 'D' || fuelType == 'B'){
            this.fuelType = fuelType;
        }else {
            throw new IllegalArgumentException("Invalid fuel type");
        }
    }

    public int getCounter() {
        return counter;
    }

    public String toString() {
        return model +" ("  + type +  ") speed "+ String.valueOf(speed)  + " fuel Type "+ fuelType;
    }
}