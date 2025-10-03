package isp.lab5.exercise2;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LaptopTest extends TestCase {

    @Test
    public void testCharge() {
        Laptop sw = new Laptop();
        sw.charge(1000);
        assertEquals(100,sw.getBatteryCharge());
        assertThrows(IllegalArgumentException.class, () -> sw.charge(-1));
    }
}