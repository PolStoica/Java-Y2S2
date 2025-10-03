package utcluj.aut.lab2.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class Ex2PalindromeFinderTest {
    private Ex2PalindromeFinder finder;

    @BeforeEach
    public void setup() {
        finder = new Ex2PalindromeFinder();
    }

    @Test
    public void testIsPalindromic() {
        // Test various numbers for palindromic property
        assertTrue(finder.isPalindromic(121), "121 should be palindromic");
        assertTrue(finder.isPalindromic(1331), "1331 should be palindromic");
        assertTrue(finder.isPalindromic(95459), "95459 should be palindromic");
        assertTrue(finder.isPalindromic(0), "0 should be palindromic");
        assertTrue(finder.isPalindromic(7), "7 should be palindromic");

        assertFalse(finder.isPalindromic(123), "123 should not be palindromic");
        assertFalse(finder.isPalindromic(1234), "1234 should not be palindromic");
        assertFalse(finder.isPalindromic(12345), "12345 should not be palindromic");
    }

    @Test
    public void testFindPalindromes() {
        // Test finding palindromes in various ranges
        int[] palindromes = finder.findPalindromes(10, 200);

        // Expected palindromes between 10 and 200
        int[] expected = {11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111, 121, 131, 141, 151, 161, 171, 181, 191};
        assertArrayEquals(expected, palindromes, "Palindromes between 10 and 200 are incorrect");

        // Test smaller range
        palindromes = finder.findPalindromes(100, 150);
        expected = new int[]{101, 111, 121, 131, 141};
        assertArrayEquals(expected, palindromes, "Palindromes between 100 and 150 are incorrect");

        // Test range with no palindromes
        palindromes = finder.findPalindromes(12, 16);
        assertEquals(0, palindromes.length, "There should be no palindromes between 12 and 16");
    }

}

