package isp.lab5.exercise3;

public class TemperatureSensor extends Sensor {
    private double temperature;
    public double getTemperature() {
        return temperature;
    }

    public TemperatureSensor(String installLocation, String sensorName, double temperature) {
        super.setInstallLocation(installLocation);
        super.setName(sensorName);
        this.temperature = temperature;
    }
}
