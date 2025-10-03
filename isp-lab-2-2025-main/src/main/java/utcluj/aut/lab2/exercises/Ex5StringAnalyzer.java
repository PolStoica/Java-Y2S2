package utcluj.aut.lab2.exercises;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class for analyzing strings.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex5StringAnalyzer {

    /**
     * Parses the input string into an array of strings, splitting by semicolons.
     *
     * @param input the input string to parse
     * @return an array of strings
     */
    public String[] parseInput(String input) {
        // TODO: Implement this method
        // 1. Split the input by semicolons
        // 2. Return the resulting array of strings
        String[] result = input.split(";");
        return result;
    }

    /**
     * Finds the longest string(s) in the array.
     * If multiple strings have the same length, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of the longest strings
     */
    public String[] findLongest(String[] strings) {
        // TODO: Implement this method
        // 1. Find the maximum string length in the array
        // 2. Collect all strings with that length
        // 3. Return the array of longest strings
        int minLength = -1;
        int counter = 0;
        //1,2
        for (String word : strings) {
            if (word.length() > minLength) {
                minLength = word.length();
                counter = 1;
            } else if (word.length() == minLength) {
                counter++;
            }
        }
        //3
        int k=0;
        String[] maxLenStrings = new String[counter];
        for (String word : strings) {
           if (word.length() == minLength) {
               maxLenStrings[k++]=word;
           }
        }
        return maxLenStrings;
    }

    /**
     * Finds the shortest string(s) in the array.
     * If multiple strings have the same length, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of the shortest strings
     */
    public String[] findShortest(String[] strings) {
        // TODO: Implement this method
        // 1. Find the minimum string length in the array
        // 2. Collect all strings with that length
        // 3. Return the array of shortest strings
        int minLength =Integer.MAX_VALUE;
        int counter = 0;
        for (String word : strings) {
            if (word.length() < minLength) {
                minLength = word.length();
                counter = 1;
            } else if (word.length() == minLength) {
                counter++;
            }
        }
        int k=0;
        String[] minLengthString = new String[counter];
        for (String word : strings) {
            if (word.length() == minLength) {
                minLengthString[k++]=word;
            }
        }
        return minLengthString;
    }

    /**
     * Counts the number of vowels in each string.
     *
     * @param strings the array of strings to analyze
     * @return a map from string to vowel count
     */
    public int[] countVowels(String[] strings) {
        // TODO: Implement this method
        // 1. Create a map to store the counts
        // 2. For each string, count the vowels (a, e, i, o, u)
        // 3. Store the counts in the map
        // 4. Return the map
        String vowels = "aeiouAEIOU";
        int[]  noVowels= new int[strings.length];

        for (int i=0; i < strings.length;i++){
            noVowels[i] = 0;
            String word = strings[i];
            for (int j=0; j < word.length(); j++){
                char letter = word.charAt(j);
                if ( vowels.indexOf(letter) != -1){
                    noVowels[i]++;
                }
            }
        }

        return noVowels;
    }

    /**
     * Counts the number of consonants in each string.
     *
     * @param strings the array of strings to analyze
     * @return an array of integers representing the consonant count for each string
     */
    public int[] countConsonants(String[] strings) {
        // TODO: Implement this method
        // 1. Create an array to store the counts
        int[] consonantCounts = new int[strings.length];
        // 2. For each string, count the consonants (non-vowels that are letters)
        for (int i = 0; i < strings.length; i++) {
            int count = 0;
            for (char c : strings[i].toCharArray()) {
                if (Character.isLetter(c) && "aeiouAEIOU".indexOf(c) == -1) {
                    count++;
                }
            }
            consonantCounts[i] = count;
        }
        // 3. Return the array
        return consonantCounts;
    }

    /**
     * Finds the string(s) with the most vowels.
     * If multiple strings have the same number of vowels, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of strings with the most vowels
     */
    public String[] findMostVowels(String[] strings) {
        // TODO: Implement this method
        // 1. Count vowels in each string
        // 2. Find the maximum vowel count
        // 3. Collect all strings with that count
        // 4. Return the array
        int[] noVowels= countVowels(strings);
        int maxVowelCount = -1;
        int noStrings=0;
        for (int i=0; i<strings.length; i++) {
            if ( noVowels[i] > maxVowelCount ) {
                maxVowelCount = noVowels[i];
            }else if (noVowels[i] == maxVowelCount) {
                noStrings++;
            }
        }

        String[] maxVowelStrings= new String[noStrings];

        int k=0;
        for ( int i=0; i<noVowels.length; i++){
            if ( maxVowelCount == noVowels[i] ) {
                maxVowelStrings[k++]=strings[i];
            }
        }

        return maxVowelStrings;
    }

    /**
     * Finds the string(s) with the most consonants.
     * If multiple strings have the same number of consonants, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of strings with the most consonants
     */
    public String[] findMostConsonants(String[] strings) {
        // TODO: Implement this method
        // 1. Count consonants in each string
        // 2. Find the maximum consonant count
        // 3. Collect all strings with that count
        // 4. Return the array
        int[] noConsonants= countConsonants(strings);
        int maxConsonantsCount = -1;
        int noStrings=0;
        for (int i=0; i<strings.length; i++) {
            if ( noConsonants[i] > maxConsonantsCount ) {
                maxConsonantsCount = noConsonants[i];
            }else if (noConsonants[i] == maxConsonantsCount) {
                noStrings++;
            }
        }

        String[] maxConsonantsString= new String[noStrings];

        int k=0;
        for ( int i=0; i<noConsonants.length; i++){
            if ( maxConsonantsCount == noConsonants[i] ) {
                maxConsonantsString[k++]=strings[i];
            }
        }

        return maxConsonantsString;
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of StringAnalyzer
        // 2. Parse the input string into an array of strings
        // 3. Find and print the longest and shortest strings
        // 4. Count and print the number of vowels and consonants in each string
        // 5. Find and print the strings with the most vowels and consonants

        Ex5StringAnalyzer stringAnalyzer = new Ex5StringAnalyzer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list separated by \";\" ");
        String input = scanner.nextLine();
        String[] strings = stringAnalyzer.parseInput(input);

        System.out.println("Longest string:");
        String[] longestStrings = stringAnalyzer.findLongest(strings);
        System.out.println(Arrays.toString(longestStrings));

        System.out.println("shortest string:");
        String[] shortestStrings = stringAnalyzer.findShortest(strings);
        System.out.println(Arrays.toString(shortestStrings));

        System.out.println("Most Vowels:");
        String[] mostVowels = stringAnalyzer.findMostVowels(strings);
        System.out.println(Arrays.toString(mostVowels));

        System.out.println("Most Consonants:");
        String[] mostConsonants = stringAnalyzer.findMostConsonants(strings);
        System.out.println(Arrays.toString(mostConsonants));
    }
}