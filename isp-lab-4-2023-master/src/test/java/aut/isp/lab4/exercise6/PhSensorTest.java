package aut.isp.lab4.exercise6;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhSensorTest {
    @Test
    public void testSetValue() {
        PhSensor ps = new PhSensor();
        ps.setNumber(1F);
        assertEquals(ps.toString(), "PhSensor [number=1.0]");
    }
    @Test
    public void testGetValue() {
        PhSensor ps = new PhSensor();
        ps.setNumber(1F);
        assertEquals(1F, ps.getNumber(),0.1);
    }
}