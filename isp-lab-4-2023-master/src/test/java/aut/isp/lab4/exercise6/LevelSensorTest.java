package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise5.LevelSensor;
import junit.framework.TestCase;

public class LevelSensorTest extends TestCase {

    public void testTestToString() {
        LevelSensor sensor = new LevelSensor();
        sensor.setValue(5);
        assertEquals("The value of the water currently is: 5.0 .", sensor.toString());
    }
}