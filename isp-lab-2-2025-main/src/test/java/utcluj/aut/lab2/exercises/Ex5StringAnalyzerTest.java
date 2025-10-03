package utcluj.aut.lab2.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ex5StringAnalyzerTest {

    @Test
    public void testParseInput() {
        String input = "apple;banana;cherry";
        String[] expected = {"apple", "banana", "cherry"};
        assertArrayEquals(expected, new Ex5StringAnalyzer().parseInput(input));
    }

    @Test
    public void testFindLongest() {
        String[] strings = {"apple", "banana", "cherry", "date"};
        String[] expected = {"banana", "cherry"};
        assertArrayEquals(expected, new Ex5StringAnalyzer().findLongest(strings));
    }

    @Test
    public void testFindShortest() {
        String[] strings = {"apple", "banana", "cherry", "date"};
        String[] expected = {"date"};
        assertArrayEquals(expected, new Ex5StringAnalyzer().findShortest(strings));
    }

    @Test
    public void testCountVowels() {
        String[] strings = {"apple", "banana", "cherry"};
        int[] expected = {2, 3, 2};
        assertArrayEquals(expected, new Ex5StringAnalyzer().countVowels(strings));
    }

    @Test
    public void testCountConsonants() {
        String[] strings = {"apple", "banana", "cherry"};
        int[] expected = {3, 3, 5};
        assertArrayEquals(expected, new Ex5StringAnalyzer().countConsonants(strings));
    }

    @Test
    public void testFindMostVowels() {
        String[] strings = {"apple", "banana", "cherry"};
        String[] expected = {"banana"};
        assertArrayEquals(expected, new Ex5StringAnalyzer().findMostVowels(strings));
    }

    @Test
    public void testFindMostConsonants() {
        String[] strings = {"apple", "banana", "cherry"};
        String[] expected = {"cherry"};
        assertArrayEquals(expected, new Ex5StringAnalyzer().findMostConsonants(strings));
    }
}