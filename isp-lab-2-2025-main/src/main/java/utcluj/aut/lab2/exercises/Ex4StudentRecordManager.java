package utcluj.aut.lab2.exercises;
import java.util.Objects;
import java.util.Scanner;

/**
 * Application that manages student records using only Strings and arrays.
 * The program allows users to input student records, filter them by grade,
 * and sort them by different criteria.
 * Students should implement all methods to complete the exercise.
 */
public class Ex4StudentRecordManager {

    /**
     * Main method that runs the application.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // TODO: Implement this method
        // 1. Create a scanner to read user input
        // 2. Prompt the user to enter student records (name,age,grade) on separate lines
        // 3. Read and store the records until the user indicates they're done
        // 4. Allow the user to filter records by minimum grade
        // 5. Allow the user to sort the filtered records
        // 6. Display the filtered and sorted records

        Ex4StudentRecordManager manager = new Ex4StudentRecordManager();
        Scanner scanner = new Scanner(System.in);
        //1
        System.out.println("Enter students records like this :'name,age,grade'");
        String[] records = new String[100];
        int dimension = 0;

        String input;
        while (true) {
            input = scanner.nextLine().trim();  // Read and trim the input
            if (input.isEmpty()) {
                break;  // Stop if the input is empty (or use a specific word like "done")
            }
            records[dimension++] = input;  // Store the record and increment dimension
        }

        //2
        String[][] parsedRecords = new String[dimension][3];
        for (int i = 0; i < dimension; i++) {
            parsedRecords[i] = parseStudentRecord(records[i]);
        }

        //3
        String[] filterAndSortOptions = getFilterAndSortOptions();

        //4
        String minGrade = filterAndSortOptions[0];
        String[][] filteredRecords = filterByGrade(parsedRecords, minGrade);

        //5
        String sortBy = filterAndSortOptions[1];
        boolean ascending = filterAndSortOptions[2].toLowerCase().equals("ascending");
        String[][] sortedRecords = sortRecords(filteredRecords, sortBy, ascending);

        //6
        displayRecords(sortedRecords);

    }

    /**
     * Parses a student record from a string in the format "name,age,grade".
     *
     * @param record the record string to parse
     * @return a string array with [name, age, grade] or null if invalid format
     */
    public static String[] parseStudentRecord(String record) {
        // TODO: Implement this method
        // 1. Split the record by commas
        // 2. Validate that there are exactly 3 parts
        // 3. Return a string array with [name, age, grade]
        // 4. Return null or handle invalid formats appropriately
        String[] words = record.split(",");
        if (words.length != 3) {
            throw new IllegalArgumentException("There needs to be exactly three words");
        }
        return words;
    }

    /**
     * Filters student records by a minimum grade threshold.
     *
     * @param records array of student records, each record is [name, age, grade]
     * @param minGrade the minimum grade threshold as a string
     * @return array of filtered student records
     */
    public static String[][] filterByGrade(String[][] records, String minGrade) {
        // TODO: Implement this method
        // 1. Parse the minimum grade threshold to an integer
        // 2. Count how many records meet the criteria
        // 3. Create a new array of arrays to hold the filtered records
        // 4. Add records with grade >= minGrade to the new array
        // 5. Return the filtered records

        //1
        int minGradeInt= Integer.parseInt(minGrade);
        int countRecords = 0;
        for (String[] record : records) {
            if (Integer.parseInt(record[2]) >= minGradeInt) {
                countRecords++; //2
            }
        }
        //3
        String[][] result = new String[countRecords][3];

        //4
        int index = 0;
        for (String[] record : records) {
            if (Integer.parseInt(record[2]) >= minGradeInt) {
                result[index++] = record;
            }
        }
        //5
        return result;
    }

    /**
     * Sorts student records by the given criteria.
     *
     * @param records array of student records, each record is [name, age, grade]
     * @param sortBy the sorting criteria ("name", "age", or "grade")
     * @param ascending true for ascending order, false for descending
     * @return a new array with sorted student records
     */
    public static String[][] sortRecords(String[][] records, String sortBy, boolean ascending) {
        // TODO: Implement this method
        // 1. Create a copy of the records array to avoid modifying the original
        // 2. Determine which index to sort by based on sortBy (0 for name, 1 for age, 2 for grade)
        // 3. Implement a sorting algorithm (e.g., bubble sort) to sort the records
        // 4. If ascending is false, reverse the sorting logic
        // 5. Return the sorted array

        //1
            String[][] copy = new String[records.length][];
            for (int i = 0; i < records.length; i++) {
                copy[i] = records[i].clone();
            }
            // 2. Determine which index to sort by based on sortBy (0 for name, 1 for age, 2 for grade)
            int column;
            switch (sortBy.toLowerCase()) {
                case "name":
                    column = 0;
                    break;
                case "age":
                    column = 1;
                    break;
                case "grade":
                    column = 2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid sortBy value: " + sortBy);
            }
            // 3. Bubble Sort implementation with ascending/descending logic
            for (int i = 0; i < copy.length - 1; i++) {
                for (int j = 0; j < copy.length - 1 - i; j++) {
                    int comparison;
                    if (column == 0) {
                        comparison = copy[j][column].compareTo(copy[j + 1][column]); // Compare names
                    } else {
                        comparison = Integer.parseInt(copy[j][column]) - Integer.parseInt(copy[j + 1][column]); // Compare age or grade
                    }
                    // Perform the swap based on the ascending or descending flag
                    if ((ascending && comparison > 0) || (!ascending && comparison < 0)) {
                        String[] temp = copy[j];
                        copy[j] = copy[j + 1];
                        copy[j + 1] = temp;
                    }
                }
            }
            // 5. Return the sorted array
            return copy;
        }

    /**
     * Displays student records in a formatted way.
     *
     * @param records array of student records to display
     */
    public static void displayRecords(String[][] records) {
        // TODO: Implement this method
        // 1. Check if there are any records to display
        // 2. Display a header for the output
        // 3. Iterate through each record and format it for display
        // 4. Display each record on a separate line
        if (records.length == 0) {
            throw new IllegalArgumentException("There needs to be at least one record");
        }
        System.out.println("This is the matrix:\n");
        for (String[] record : records) {
            System.out.println("name:" + record[0] + " age:" + record[1] + " grade:" + record[2] + "\n");
        }
    }

    /**
     * Prompts for and reads user input for filtering and sorting options.
     *
     * @return a string array with [minGrade, sortBy, ascending]
     */
    public static String[] getFilterAndSortOptions() {
        // TODO: Implement this method
        // 1. Create a scanner to read user input
        // 2. Prompt the user for minimum grade threshold
        // 3. Prompt the user for sorting criteria (name, age, or grade)
        // 4. Prompt the user for sorting order (ascending or descending)
        // 5. Return the options as a string array
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the minimum grade threshold:");
        String minGrade = scanner.nextLine();
        System.out.println("Please enter the sorting criteria:");
        String sortBy = scanner.nextLine();
        System.out.println("Please enter the sorting option:");
        String option = scanner.nextLine();
        return new String[] {minGrade, sortBy, option};
    }

    /**
     * Checks if a string can be parsed as an integer.
     *
     * @param str the string to check
     * @return true if the string is a valid integer, false otherwise
     */
    public static boolean isInteger(String str) {
        // TODO: Implement this method
        // 1. Try to parse the string as an integer
        // 2. Return true if successful, false if it causes an exception

            if (str == null || str.isEmpty()) {
                return false;
            }
            if (str.charAt(0) == '-') {
                str = str.substring(1);
            }
            return str.chars().allMatch(Character::isDigit);
    }
}