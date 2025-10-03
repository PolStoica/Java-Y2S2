# Laboratory 2

This project is a collection of exercises for lab 2 assignment, focusing on different programming tasks. Each exercise is encapsulated in a separate class, and the project is organized to facilitate the implementation and testing of these classes.

## Expected Workflow for Students

1. **Understand the Problem Statement:** Carefully read the description of each exercise and understand the problem you need to solve.
2. **Plan Your Solution:** Before writing any code, plan your approach to solving the problem. Consider the methods you need to implement and how they will interact.
3. **Write the Code:** Implement the methods as described in the project structure. Follow the TODO comments and write the necessary code.
4. **Test Your Code:** Use the provided test classes to test and validate your solution is implemented according to the requirements.
5. **Debug and Refine:** If your tests fail, debug your code to find and fix the issues. Refine your solution to improve performance and readability.
6. **Submit Your Work:** Once you are confident that your code works correctly, submit your work as per the submission guidelines.

## Implementaiton note

Guided skeleton classes do not make use of Java features with regard to storing and managing arrays of data. This is done to keep the exercises focused on the core java features (if-else, loops, arrays, variables) and not touching aspects related to object oriented programing where collections are normally used. In a real-world scenario, and starting with next laboratories you will use Java collections or other data structures to manage data more efficiently.

## Exercise 1
Generate a random number between 25 and 150 and create an array of that size. Fill the array with random integers between -100 and 100. Calculate the average value of all elements and count how many elements are above and below this average.

## Exercise 2
Write a program that reads two integers _a_ and _b_ from the keyboard, where _a_ is less than _b_. The program should find all palindromic numbers between _a_ and _b_, inclusive. A palindromic number reads the same backward as forward (e.g., 121, 1331). Display all the palindromic numbers found and their count.

## Exercise 3
Write a program that takes an integer _n_ as input and calculates the factorial of _n_ using recursion. Additionally, implement a non-recursive solution and compare the execution time of both approaches for various values of _n_.

## Exercise 4
Implement an application that allows the user to filter and sort a list of student records. First, the user is asked to input student records in the format "name,age,grade" on separate lines (e.g., "John,19,85"). After entering all records, the user can filter students by minimum grade threshold and sort the results by name, age, or grade in ascending or descending order.

## Exercise 5
Write a program that reads a list of strings from the user, on one line, separated by semicolons. The program should then analyze the strings and display: the longest string, the shortest string, the string with the most vowels, and the string with the most consonants. If there are ties, display all strings that tie for each category.

## Exercise 6
Create a number guessing game where the computer thinks of a 4-digit number with no repeated digits. The player tries to guess the number, and after each guess, the computer tells the player how many digits are correct and in the right position (bulls) and how many digits are correct but in the wrong position (cows). The game continues until the player guesses the number correctly. Display the number of attempts needed to win the game.