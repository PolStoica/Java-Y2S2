package aut.isp.lab4.exercise6;

import junit.framework.TestCase;

public class ActuatorTest extends TestCase {

    public void testTurnOn() {
        Actuator actuator = new Actuator();
        actuator.turnOn();
        assertTrue(actuator.getIsOn());
    }

    public void testTurnOff() {
        Actuator actuator = new Actuator();
        actuator.turnOff();
        assertFalse(actuator.getIsOn());
    }

    public void testTestToString() {
        Actuator actuator = new Actuator();
        actuator.turnOff();
        assertEquals("The actuator is: off .", actuator.toString());
        actuator.turnOn();
        assertEquals("The actuator is: on .", actuator.toString());
    }
}