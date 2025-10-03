package aut.isp.lab4.exercise4;

import junit.framework.TestCase;

public class LightsTest extends TestCase {

    public void testTurnOn() {
        Lights lights = new Lights();
        lights.turnOn();
        assertTrue(lights.getIsOn());
    }

    public void testTurnOff() {
        Lights lights = new Lights();
        lights.turnOff();
        assertFalse(lights.getIsOn());
    }
}