package isp.lab5.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        MonitoringService monitoringService = new MonitoringService();
        Sensor[] sensors = {
                new TemperatureSensor("Bucatarie", "TempSensor1", 22.5),
                new TemperatureSensor("Dormitor", "TempSensor2", 17.0),
                new PressureSensor("Laborator", "PressureSensor1", 1013.2),
                new TemperatureSensor("Debara", "TempSensor3", 10.0),
                new TemperatureSensor("Bucatarie2", "TempSensor4", 22.5),
                new TemperatureSensor("Dormitor2", "TempSensor5", 17.0),
                new PressureSensor("Laborator2", "PressureSensor2", 1013.2),
                new TemperatureSensor("Debara2", "TempSensor6", 10.0),
                new TemperatureSensor("Bucatarie3", "TempSensor3", 22.5),
                new TemperatureSensor("Dormitor3", "TempSensor7", 17.0),
        };
        monitoringService.setSensors(sensors); // A method to set sensors
        System.out.println("Average Temperature: " + monitoringService.getAverageTemperature());
        System.out.println("Average all sensors: " + monitoringService.getAverageAllSensors());
    }
}