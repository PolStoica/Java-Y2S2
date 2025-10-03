package utcluj.aut.lab2.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ex1ArrayAnalyzerTest {

    @Test
    public void testArraySizeAndRange() {
        // Testing the ArrayAnalyzer class implementation
        Ex1ArrayAnalyzer analyzer = new Ex1ArrayAnalyzer();
        int[] array = analyzer.generateArray();

        // Test array size is between 25 and 150
        assertTrue(array.length >= 25 && array.length <= 150,
                "Array size should be between 25 and 150, but was " + array.length);

        // Test all values are between -100 and 100
        for (int value : array) {
            assertTrue(value >= -100 && value <= 100,
                    "Array value " + value + " outside allowed range [-100, 100]");
        }
    }

    @Test
    public void testAverageCalculation() {
        // Create a known array for testing
        int[] testArray = {10, 20, 30, 40, 50};
        Ex1ArrayAnalyzer analyzer = new Ex1ArrayAnalyzer();

        // Test average calculation
        double average = analyzer.calculateAverage(testArray);
        assertEquals(30.0, average, 0.001, "Average calculation is incorrect");

        // Test counting values above/below average
        int[] counts = analyzer.countAboveBelowAverage(testArray, average);
        assertEquals(2, counts[0], "Count of values above average is incorrect");
        assertEquals(2, counts[1], "Count of values below average is incorrect");
    }

    @Test
    public void testEmptyOrSingleElementArray() {
        Ex1ArrayAnalyzer analyzer = new Ex1ArrayAnalyzer();

        // Test empty array
        int[] emptyArray = {};
        assertEquals(0.0, analyzer.calculateAverage(emptyArray), 0.001,
                "Average of empty array should be 0");

        // Test single element array
        int[] singleElementArray = {42};
        assertEquals(42.0, analyzer.calculateAverage(singleElementArray), 0.001,
                "Average of single element array is incorrect");
        int[] counts = analyzer.countAboveBelowAverage(singleElementArray, 42.0);
        assertEquals(0, counts[0], "Count of values above average is incorrect for single element");
        assertEquals(0, counts[1], "Count of values below average is incorrect for single element");
    }
}
