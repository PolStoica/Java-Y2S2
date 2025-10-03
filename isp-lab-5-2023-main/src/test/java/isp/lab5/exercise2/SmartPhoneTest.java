package isp.lab5.exercise2;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartPhoneTest extends TestCase {
    @Test
    public void testCharge() {
        SmartPhone sw = new SmartPhone();
        sw.charge(10);
        assertEquals(10,sw.getBatteryCharge());
        assertThrows(IllegalArgumentException.class, () -> sw.charge(-1));
    }
}