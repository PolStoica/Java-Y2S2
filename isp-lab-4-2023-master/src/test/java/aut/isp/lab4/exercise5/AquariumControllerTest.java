package aut.isp.lab4.exercise5;
import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumControllerTest {
    @Test
    public void testSetCurrentTime() {
        AquariumController a = new AquariumController("Bosch","Model1", 12F,13F,2F,25);
        a.setCurrentTime(123);
        assertEquals(123, a.getCurrentTime(),0.1);

        assertThrows(IllegalArgumentException.class, ()->a.setCurrentTime(-1));
    }
    @Test
    public void testSetFeedingTime() {
        AquariumController a = new AquariumController("Bosch","Model1", 12F,13F,2F,25);
        a.setFeedingTime(123);
        assertEquals(123, a.getFeedingTime(),0.1);
        assertThrows(IllegalArgumentException.class, ()->a.setCurrentTime(-1));
    }

    @Test
    public void testCheckTemperature() {
        AquariumController a = new AquariumController();
        System.out.println(a.getPresetTemperature());
        assertEquals(24, a.getPresetTemperature(),0.1);
        a.checkTemperature();
        Actuator h=a.getHeater();
        assertTrue(h.getIsOn());
    }

    @Test
    public void testCheckWaterLevel() {
        AquariumController controller = new AquariumController();
        System.out.println(controller.getPresetLevel());
        assertEquals(2, controller.getPresetLevel(),0.1);
        Actuator actuator=controller.getAlarm();
        controller.checkWaterLevel();
        assertTrue(actuator.getIsOn());
    }

    @Test
    public void testTestToString() {
        AquariumController a= new AquariumController("Bosch","Model1", 12F,13F,2F,25);
        assertEquals("The manufacturer is: Bosch. The model is: Model1. The current time is: 12.0, the feeding time is: 13.0," +
                " the preset water level is: 2.0 and the temperature is 25.", a.toString());
    }
}