package aut.isp.lab4.exercise1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AquariumControllerTest {
    @Test
    public void testSetCurrentTime() {
            AquariumController a = new AquariumController("B","2",1);
            a.setCurrentTime(123);
            assertEquals(123, a.getCurrentTime(),0.1);

            assertThrows(IllegalArgumentException.class, ()->a.setCurrentTime(-1));
    }
    @Test
    public void testTestToString() {
        AquariumController a = new AquariumController("Bosch","Model1", 12);
        assertEquals("The manufacturer is:Bosch. The model is:Model1. The current time is:12.0", a.toString());
    }

}
