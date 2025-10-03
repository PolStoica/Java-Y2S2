package isp.lab5.exercise3;

public class PressureSensor extends Sensor {
    private double pressure;

    public PressureSensor(String installLocation, String sensorName, double pressure) {
        super.setInstallLocation(installLocation);
        super.setName(sensorName);
        this.pressure = pressure;
    }

    public double getPressure() {
        return pressure;
    }
}
