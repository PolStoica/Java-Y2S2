package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise5.Sensor;
import junit.framework.TestCase;

public class SensorTest extends TestCase {

    public void testTestToString() {
    Sensor sensor = new Sensor();
    sensor.setUnitOfMeasurement("m");
    assertEquals("The unit of measurement is: m", sensor.toString());
    }
}