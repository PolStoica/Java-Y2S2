package utcluj.aut;

import java.util.Scanner;

/**
 * MyFirstExample class is a simple class that demonstrates the usage of Java.
 */

public class MyFirstExample {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        //read from console and print
        System.out.println("Enter two numbers: ");
        Scanner scanner = new Scanner(System.in); //tastatura
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Sum is: " + add(a, b));
        System.out.println("Difference is: " + subtract(a, b));
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

}