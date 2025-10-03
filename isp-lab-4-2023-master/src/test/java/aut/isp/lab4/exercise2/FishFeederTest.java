package aut.isp.lab4.exercise2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FishFeederTest {
    @Test
    public void testFeed() {
        FishFeeder feeder = new FishFeeder();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        feeder.feed();
        System.setOut(originalOut);
        assertEquals("The feeder is empty, you have to fillUp\n", outputStream.toString());
        feeder.fillUp();

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        feeder.feed();
        System.setOut(originalOut);
        assertEquals("A meal has been disbursed, there are 13 meals left in the tank.\n", outputStream.toString());
    }
@Test
    public void testFillUp() {
    FishFeeder feeder = new FishFeeder();
    feeder.fillUp();
    assertEquals(14,feeder.getMeals(),0.01);
    }
@Test
    public void testTestToString() {
    FishFeeder feeder = new FishFeeder();
    feeder.fillUp();
    feeder.feed();
    assertEquals("The manufacturere of the FishFeeder is: None. The model is: None . And it has : 13 meals left to disburst.",feeder.toString());
    }
}