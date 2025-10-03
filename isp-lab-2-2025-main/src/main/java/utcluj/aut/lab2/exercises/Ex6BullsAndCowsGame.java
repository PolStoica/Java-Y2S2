package utcluj.aut.lab2.exercises;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Class implementing the Bulls and Cows number guessing game.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex6BullsAndCowsGame {
    private String secretNumber;

    /**
     * Creates a new game with a random secret number.
     */
    public Ex6BullsAndCowsGame() {
        this.secretNumber = generateSecretNumber();
    }

    /**
     * Creates a new game with the specified secret number (for testing).
     *
     * @param secretNumber the secret number to use
     */
    public Ex6BullsAndCowsGame(String secretNumber) {
        this.secretNumber = secretNumber;
    }

    /**
     * Generates a random 4-digit number with no repeated digits.
     *
     * @return a string representing the 4-digit number
     */
    public static String generateSecretNumber() {
        // TODO: Implement this method
        // 1. Generate 4 unique random digits (no repeats)
        // 2. Concatenate them into a string
        // 3. Return the string
        Random random = new Random();
        StringBuilder number = new StringBuilder();

        int[] appArray= new int[10] ; //vector de aparitie
        for (int i = 0; i < 10; i++) {
            appArray[i]= 0;
        }
        for (int i = 0; i < 4; i++) {
            int k= random.nextInt(0,10);
            while(appArray[k]!=0) {
                k= random.nextInt(0,10);
            }
            appArray[k]++;
            number.append(k);
        }

        return number.toString();
    }

    /**
     * Evaluates a guess against the secret number.
     *
     * @param guess the guess to evaluate
     * @return an array with [bulls, cows]
     * @throws IllegalArgumentException if the guess is invalid
     */
    public int[] evaluateGuess(String guess) {
        // TODO: Implement this method
        // 1. Validate the guess (4 digits, no repeats)
        // 2. Count bulls (correct digit in correct position)
        // 3. Count cows (correct digit in wrong position)
        // 4. Return both counts as an array [bulls, cows]
        int[] result=new int[2];

        // Ensure guess is exactly 4 characters
        if (guess.length() != 4) {
            throw new IllegalArgumentException("The Guess must be exactly 4 digits long.");
        }

        // Ensure guess contains only digits
        if (!guess.matches("\\d{4}")) {
            throw new IllegalArgumentException("The Guess must contain only numeric digits.");
        }
           for (int i = 0; i < 4; i++) {
               for (int j = i+1; j < 4; j++) {
                   if (guess.charAt(i) == guess.charAt(j)) {
                       throw new IllegalArgumentException("The Guess entered is not valid");
                   }
               }
           }

            for (int i = 0; i < 4; i++) {
                if (guess.charAt(i) == secretNumber.charAt(i) ) {
                    result[0]++;
                }else if (secretNumber.contains(String.valueOf(guess.charAt(i)))) {
                    result[1]++;
                }
            }
        return result;
    }

    /**
     * Plays the game with a predetermined list of guesses (for testing).
     *
     * @param guesses the list of guesses to try
     * @return the number of attempts needed to guess correctly
     */
    public int playTestGame(String[] guesses) {
        // TODO: Implement this method
        // 1. Iterate through each guess
        // 2. Evaluate the guess
        // 3. If all bulls, return the number of attempts
        // 4. If no correct guess, return the number of guesses
         for (int i = 0; i < guesses.length; i++) {
             if (evaluateGuess(guesses[i])[0] == 4){
                 return i+1;
             };
              if (evaluateGuess(guesses[i])[1] == 0 && evaluateGuess(guesses[i])[0]== 0){
                  return guesses.length;
              }
         }
         return guesses.length;
    }

    /**
     * Plays an interactive game with user input.
     */
    public void play() {
        // TODO: Implement this method
        // 1. Create a scanner for user input
        // 2. Loop until the user guesses correctly
        // 3. Validate and evaluate each guess
        // 4. Display the number of bulls and cows
        // 5. Track the number of attempts
        // 6. Display the final result
        // 1. Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        int attempts = 0;
        boolean guessedCorrectly = false;
        while (!guessedCorrectly) {
            System.out.print("Enter your guess (4 digits): ");
            String guess = scanner.nextLine();
            attempts++;
            int[] result = evaluateGuess(guess);
            System.out.println("Bulls: " + result[0] + ", Cows: " + result[1]);
            if (result[0] == 4) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number.");
                System.out.println("It took you " + attempts + " attempts.");
            }
        }
    }
    public static void main(String[] args) {
        Ex6BullsAndCowsGame ex6BullsAndCowsGame = new Ex6BullsAndCowsGame();
        ex6BullsAndCowsGame.play();
    }
}
