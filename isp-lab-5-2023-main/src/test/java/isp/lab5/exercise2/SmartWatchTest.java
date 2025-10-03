package isp.lab5.exercise2;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SmartWatchTest extends TestCase {

    @Test
    public void testCharge() {
        SmartWatch sw = new SmartWatch();
        sw.charge(10);
        assertEquals(20,sw.getBatteryCharge());
        assertThrows(IllegalArgumentException.class, () -> sw.charge(-1));
    }
}