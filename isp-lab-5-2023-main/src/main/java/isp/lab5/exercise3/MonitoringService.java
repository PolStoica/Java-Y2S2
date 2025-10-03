package isp.lab5.exercise3;

public class MonitoringService {
    private Sensor[] sensors = new Sensor[10];

    public void setSensors(Sensor[] sensors) {
        if (sensors.length != 0) {
            if (sensors.length > 10) {
                throw new IllegalArgumentException("too many sensors");
            }
            this.sensors = new Sensor[sensors.length];
            System.arraycopy(sensors, 0, this.sensors, 0, sensors.length);
        } else {
            System.out.println("No sensors found");
        }

    }

    public double getAverageTemperature() {
        if (sensors.length != 0) {
            double sum = 0;
            for (Sensor sensor : sensors) {
                if (sensor instanceof TemperatureSensor) {
                    sum += ((TemperatureSensor) sensor).getTemperature();
                }
            }
            return sum / sensors.length;
        }
        return 0;
    }

    public double getAverageAllSensors() {
        if (sensors.length!=0) {
            double sum=0;
            for (Sensor sensor : sensors) {
                if (sensor instanceof TemperatureSensor) {
                    sum+=((TemperatureSensor) sensor).getTemperature();
                }else{
                    sum+=((PressureSensor) sensor).getPressure();
                }
            }
          return sum/sensors.length;
        }
        return 0;
    }
}