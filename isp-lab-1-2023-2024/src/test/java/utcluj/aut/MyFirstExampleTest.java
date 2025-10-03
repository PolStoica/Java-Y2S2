package utcluj.aut;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyFirstExampleTest {
    
    @Test
    public void testAdd() {
        assertEquals(5, MyFirstExample.add(2, 3));
        assertEquals(0, MyFirstExample.add(-1, 1));
        assertEquals(-3, MyFirstExample.add(-1, -2));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, MyFirstExample.subtract(3, 2));
        assertEquals(-2, MyFirstExample.subtract(-1, 1));
        assertEquals(1, MyFirstExample.subtract(-1, -2));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, MyFirstExample.multiply(2, 3));
        assertEquals(-1, MyFirstExample.multiply(-1, 1));
        assertEquals(2, MyFirstExample.multiply(-1, -2));
    }
}
