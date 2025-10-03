package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise5.TemperatureSensor;
import junit.framework.TestCase;

public class TemperatureSensorTest extends TestCase {

    public void testTestToString() {
        TemperatureSensor sensor = new TemperatureSensor();
        sensor.setValue(5);
        assertEquals("The temperature inside is: 5 .",sensor.toString());
    }
}