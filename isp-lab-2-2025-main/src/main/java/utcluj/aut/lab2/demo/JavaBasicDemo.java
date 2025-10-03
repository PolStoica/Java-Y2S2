package utcluj.aut.lab2.demo;

import java.util.*;

public class JavaBasicDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading an integer from the console
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over after the number itself
        System.out.println("You entered: " + num);

        // Reading a line of text from the console
        System.out.print("Enter a line of text: ");
        String text = scanner.nextLine();
        System.out.println("You entered: " + text);

        // Working with arrays: Creating, filling, and iterating
        int[] numbers = new int[5];
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Array elements:");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();

        // Working with Strings
        String example = "Hello, Java!";
        System.out.println("Uppercase: " + example.toUpperCase());
        System.out.println("Lowercase: " + example.toLowerCase());
        System.out.println("Substring (first 5 chars): " + example.substring(0, 5));

        // Splitting a string by comma
        String csv = "apple,banana,orange,grape";
        String[] fruits = csv.split(",");
        System.out.println("Split string into substrings:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Comparing two strings
        String str1 = "Java";
        String str2 = "java";
        System.out.println("Comparing with equals: " + str1.equals(str2));
        System.out.println("Comparing with equalsIgnoreCase: " + str1.equalsIgnoreCase(str2));

        // Generating a random number
        Random random = new Random();
        int randomNumber = random.nextInt(126) + 25; // Between 25 and 150
        System.out.println("Random number: " + randomNumber);

        scanner.close();
    }
}

