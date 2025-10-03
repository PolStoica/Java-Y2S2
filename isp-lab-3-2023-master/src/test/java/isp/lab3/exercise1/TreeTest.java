package isp.lab3.exercise1;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {
@Test
    public void testGrow() {
        Tree testTree=new Tree();
        testTree.grow(1);
        assertEquals(16, testTree.height);

       assertThrows(IllegalArgumentException.class, () -> testTree.grow(0), "Meters must be greater than 0");

}
@Test
    public void testToString() {
    Tree testTree2=new Tree();
    assertEquals("15", testTree2.toString());
}

}