package utcluj.aut.lab2.demo;

public class StaticMethodDemo {

    // Static method with void return type
    public static void printMessage() {
        System.out.println("Hello, this is a static method!");
    }

    // Static method that returns an integer
    public static int addNumbers(int a, int b) {
        return a + b;
    }

    // Static method that processes an array of strings and returns a concatenated string
    public static String concatenateStrings(String[] words) {
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append(" ");
        }
        return result.toString().trim();
    }

    // Static method that splits a string by ":" and returns an array of strings
    public static String[] splitStringByColon(String input) {
        return input.split(":");
    }

    // Validates number is positive
    public static void validateNumberIsPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
    }

    public static void main(String[] args) {
        // Calling the static method with void return type
        printMessage();

        // Calling the static method that returns a value
        int sum = addNumbers(5, 10);
        System.out.println("Sum: " + sum);

        // Calling the static method that works with an array
        String[] words = {"Java", "static", "methods", "are", "useful"};
        String sentence = concatenateStrings(words);
        System.out.println("Concatenated String: " + sentence);

        // Calling the static method that splits a string
        String input = "apple:banana:cherry:date";
        String[] splitArray = splitStringByColon(input);

        System.out.println("Split Array:");
        for (String part : splitArray) {
            System.out.println(part);
        }

        // Call validate positive number
        validateNumberIsPositive(-10);
    }
}
