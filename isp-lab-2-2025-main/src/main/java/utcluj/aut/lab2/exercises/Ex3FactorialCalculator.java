package utcluj.aut.lab2.exercises;

import java.util.Scanner;
/**
 * Class for calculating factorials using recursive and non-recursive approaches.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex3FactorialCalculator {

    /**
     * Calculates the factorial of n using recursion.
     *
     * @param n the number to calculate factorial for
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long recursiveFactorial(int n) {
        // TODO: Implement this method using recursion
        // 1. Validate that n is not negative, throw IllegalArgumentException if it is
        // 2. Implement the recursive algorithm for factorial
        // 3. Remember the base case (0! = 1)
        if (n<0){
            throw new IllegalArgumentException("number must be positive");
        }
        if (n==0){
            return 1;
        }
        return n*recursiveFactorial(n-1);
    }

    /**
     * Calculates the factorial of n using a non-recursive approach.
     *
     * @param n the number to calculate factorial for
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long nonRecursiveFactorial(int n) {
        // TODO: Implement this method using a loop (not recursion)
        // 1. Validate that n is not negative, throw IllegalArgumentException if it is
        // 2. Implement a loop-based algorithm for factorial
        // 3. Remember the base case (0! = 1)
        if (n<0){
            throw new IllegalArgumentException("number must be positive");
        }
        if (n==0){
            return 1;
        }

        long result=1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Compares the execution time of both factorial methods.
     *
     * @param n the number to calculate factorial for
     * @return an array with [recursiveTime, nonRecursiveTime] in nanoseconds
     */
    public long[] compareExecutionTime(int n) {

        long before=System.nanoTime();
        recursiveFactorial(n);
        long after=System.nanoTime();
        long timeRecursive =after-before;

         before=System.nanoTime();
        nonRecursiveFactorial(n);
         after=System.nanoTime();
        long timeNonRecursive=after-before;

        return new long[] {timeRecursive,timeNonRecursive};
    }

     public static void main(String[] args) {

         Ex3FactorialCalculator FactorialCalculator = new Ex3FactorialCalculator();
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter a number: ");
         int number = scanner.nextInt();
         scanner.nextLine();
         long resultRecursion= FactorialCalculator.recursiveFactorial(number);
         long resultNonRecursion= FactorialCalculator.nonRecursiveFactorial(number);
         long[] executionTime= FactorialCalculator.compareExecutionTime(number);
         System.out.println("The results calculated are "+resultRecursion+" times and "+resultNonRecursion+"\n");
         System.out.println("The execution time of the Recursive function is "+executionTime[0]+" nanoseconds.\n And the execution time of the nonRecursive function is"+executionTime[1]+" nanoseconds.");
     }
}
