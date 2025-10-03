package utcluj.aut.lab2.exercises;

import java.util.Random;

/**
 * Class for generating and analyzing arrays of random integers.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex1ArrayAnalyzer {

    /**
     * Generates an array of random size between 25 and 150,
     * filled with random integers between -100 and 100.
     *
     * @return an array of random integers
     */
    public int[] generateArray() {
        // TODO: Implement this method
        // 1. Generate a random size between 25 and 150
        // 2. Create an array of that size
        // 3. Fill the array with random integers between -100 and 100
        // 4. Return the array
        Random random = new Random(); //instantiere obiectul random
        int arrayLength= random.nextInt(126)+25; //intre 25 si 150 incl
        int[] randomArray= new int [arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            randomArray[i]= random.nextInt(-100,101); //intre -100 si 100
        }
        return randomArray;
    }

    /**
     * Calculates the average value of all elements in the given array.
     *
     * @param array the array to analyze
     * @return the average value of all elements
     */
    public double calculateAverage(int[] array) {
        // TODO: Implement this method
        // 1. Calculate the sum of all elements in the array
        // 2. Return the average (sum divided by length)
        // 3. Handle edge case of empty array
        int sum=0;
        for(int number : array){  //for each
            sum+=number;
        }
        int arrayLength=array.length;  //atributul length
        if (arrayLength == 0  ) {
            System.out.println("Array is empty");
            return 0;
        }
        return (double) sum / arrayLength ;
    }

    /**
     * Counts how many elements are above and below the given average.
     *
     * @param array the array to analyze
     * @param average the average value to compare against
     * @return an array of 2 integers: [countAbove, countBelow]
     */
    public int[] countAboveBelowAverage(int[] array, double average) {
        // TODO: Implement this method
        // 1. Count elements above the average
        // 2. Count elements below the average
        // 3. Return both counts as an array [countAbove, countBelow]
        int countAbove=0;
        int countBelow=0;
        for(int number : array) {
            if (number > average) {
                countAbove++;
            } else if (number < average) {
                countBelow++;
            }
        }
        return new int[] {countAbove,countBelow}; //ca si cand creeaza o 'variabila'; o instanta defapt
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of ArrayAnalyzer
        // 2. Generate a random array
        // 3. Calculate the average of the array
        // 4. Count elements above and below the average
        // 5. Print the results

        Ex1ArrayAnalyzer arrayAnalyzer = new Ex1ArrayAnalyzer();
        int [] array = arrayAnalyzer.generateArray();
        double average = arrayAnalyzer.calculateAverage(array);
        int[] count = arrayAnalyzer.countAboveBelowAverage(array, average);
        System.out.println("Number of bellow average: " + count[1]);
        System.out.println("Number of above average: " + count[0]);

    }
}
