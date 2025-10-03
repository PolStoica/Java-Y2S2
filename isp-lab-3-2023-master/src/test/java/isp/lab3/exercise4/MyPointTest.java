package isp.lab3.exercise4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyPointTest {

    @Test
    void distance() {
        MyPoint point1 = new MyPoint(1,1,1);
        MyPoint point2 = new MyPoint(2,2,2);
        assertEquals(point1.distance(point2), point2.distance(point1));
    }

    @Test
    void testDistance() {
        MyPoint point1 = new MyPoint(1,2,3);
        assertEquals(point1.distance(0,0,0),"(1,2,3)");
    }
}