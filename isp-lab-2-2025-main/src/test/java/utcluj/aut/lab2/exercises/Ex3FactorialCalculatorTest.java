package utcluj.aut.lab2.exercises;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

public class Ex3FactorialCalculatorTest {
    private Ex3FactorialCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Ex3FactorialCalculator();
    }

    @Test
    public void testRecursiveFactorial() {
        // Test factorial calculations for various inputs
        assertEquals(1, calculator.recursiveFactorial(0), "0! should be 1");
        assertEquals(1, calculator.recursiveFactorial(1), "1! should be 1");
        assertEquals(2, calculator.recursiveFactorial(2), "2! should be 2");
        assertEquals(6, calculator.recursiveFactorial(3), "3! should be 6");
        assertEquals(24, calculator.recursiveFactorial(4), "4! should be 24");
        assertEquals(120, calculator.recursiveFactorial(5), "5! should be 120");
        assertEquals(3628800, calculator.recursiveFactorial(10), "10! should be 3628800");
    }

    @Test
    public void testNonRecursiveFactorial() {
        // Test factorial calculations for various inputs
        assertEquals(1, calculator.nonRecursiveFactorial(0), "0! should be 1");
        assertEquals(1, calculator.nonRecursiveFactorial(1), "1! should be 1");
        assertEquals(2, calculator.nonRecursiveFactorial(2), "2! should be 2");
        assertEquals(6, calculator.nonRecursiveFactorial(3), "3! should be 6");
        assertEquals(24, calculator.nonRecursiveFactorial(4), "4! should be 24");
        assertEquals(120, calculator.nonRecursiveFactorial(5), "5! should be 120");
        assertEquals(3628800, calculator.nonRecursiveFactorial(10), "10! should be 3628800");
    }

    @Test
    public void testNegativeInput() {
        // Test with negative input
        assertThrows(IllegalArgumentException.class, () -> calculator.recursiveFactorial(-1),
                "Should throw exception for negative input in recursive method");
        assertThrows(IllegalArgumentException.class, () -> calculator.nonRecursiveFactorial(-1),
                "Should throw exception for negative input in non-recursive method");
    }

    @Test
    public void testPerformanceComparison() {
        // This test checks if both methods produce the same result
        // and that non-recursive method doesn't time out for larger values
        int n = 15;

        // Test that both methods give the same result
        assertEquals(calculator.recursiveFactorial(n), calculator.nonRecursiveFactorial(n),
                "Both methods should give the same result for " + n + "!");

        // Test that non-recursive method can handle larger values
        assertTimeout(Duration.ofMillis(100), () -> calculator.nonRecursiveFactorial(20),
                "Non-recursive method should be fast for n=20");
    }

}
