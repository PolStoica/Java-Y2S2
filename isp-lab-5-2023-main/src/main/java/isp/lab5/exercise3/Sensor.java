package isp.lab5.exercise3;

public abstract class Sensor  {
    private String installLocation;
    private String name;

    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation;
    }

    public void setName(String name) {
        this.name = name;
    }
}
