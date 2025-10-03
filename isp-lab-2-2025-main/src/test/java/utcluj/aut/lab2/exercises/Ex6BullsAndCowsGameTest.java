package utcluj.aut.lab2.exercises;
// Exercise 6 Unit Test
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class Ex6BullsAndCowsGameTest {
    private Ex6BullsAndCowsGame game;

    @BeforeEach
    public void setup() {
        // Initialize with a fixed secret number for testing
        game = new Ex6BullsAndCowsGame("1234");
    }

    @Test
    public void testGenerateSecretNumber() {
        // Test generating a secret number
        String secret = Ex6BullsAndCowsGame.generateSecretNumber();
        assertEquals(4, secret.length(), "Secret number should be 4 digits long");

        // Check for no repeated digits
        for (int i = 0; i < secret.length(); i++) {
            char digit = secret.charAt(i);
            assertEquals(1, secret.chars().filter(c -> c == digit).count(),
                    "Secret number should have no repeated digits");
        }

        // Test generating multiple numbers - should be different
        String secret2 = Ex6BullsAndCowsGame.generateSecretNumber();
        int attempts = 0;
        while (secret.equals(secret2) && attempts < 10) {
            secret2 = Ex6BullsAndCowsGame.generateSecretNumber();
            attempts++;
        }
        assertNotEquals(secret, secret2, "Generated secret numbers should be random");
    }

    @Test
    public void testEvaluateGuess() {
        // Test various guesses against secret "1234"
        int[] result = game.evaluateGuess("1234");
        assertEquals(4, result[0], "Should have 4 bulls for correct guess");
        assertEquals(0, result[1], "Should have 0 cows for correct guess");

        result = game.evaluateGuess("4321");
        assertEquals(0, result[0], "Should have 0 bulls");
        assertEquals(4, result[1], "Should have 4 cows");

        result = game.evaluateGuess("1243");
        assertEquals(2, result[0], "Should have 2 bulls");
        assertEquals(2, result[1], "Should have 2 cows");

        result = game.evaluateGuess("5678");
        assertEquals(0, result[0], "Should have 0 bulls");
        assertEquals(0, result[1], "Should have 0 cows");

        result = game.evaluateGuess("1235");
        assertEquals(3, result[0], "Should have 3 bulls");
        assertEquals(0, result[1], "Should have 0 cows");
    }

    @Test
    public void testInvalidGuesses() {
        // Test too short guess
        assertThrows(IllegalArgumentException.class, () -> game.evaluateGuess("123"),
                "Should throw exception for too short guess");

        // Test too long guess
        assertThrows(IllegalArgumentException.class, () -> game.evaluateGuess("12345"),
                "Should throw exception for too long guess");

        // Test non-numeric guess
        assertThrows(IllegalArgumentException.class, () -> game.evaluateGuess("123a"),
                "Should throw exception for non-numeric guess");

        // Test guess with repeated digits
        assertThrows(IllegalArgumentException.class, () -> game.evaluateGuess("1123"),
                "Should throw exception for guess with repeated digits");
    }

    @Test
    public void testGameplay() {
        // Test full game with fixed secret "1234"
        String[] guesses = {"5678", "1590", "1234"};
        int attempts = game.playTestGame(guesses);
        assertEquals(3, attempts, "Game should take 3 attempts");

        // Test another game sequence
        guesses = new String[]{"9876", "5432", "1678", "1234"};
        attempts = game.playTestGame(guesses);
        assertEquals(4, attempts, "Game should take 4 attempts");
    }
}