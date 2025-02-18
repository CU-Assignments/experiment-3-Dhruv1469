/*
Chapter-3 (Exception Handing)(Experiment 3)	Introduction to Exceptions.
Difference between error and exception. Use of try, catch and throw. 
Difference between throw and throws. Types of Exceptions, Exception handling in Java
Problem Statement: Write a Java program to calculate the square root of a number entered by the user. 
Use try-catch to handle invalid inputs (e.g., negative numbers or non-numeric values).
Input Example:
Enter a number: -16
Output Example:
Error: Cannot calculate the square root of a negative number.
 */

import java.util.Scanner;

public class exp31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");

        try {
            double number = scanner.nextDouble();
            if (number < 0) {
                throw new IllegalArgumentException("Error: Cant calculate the square root of a negative number.");
            }
            System.out.printf("Square root: %.2f%n", Math.sqrt(number));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } finally {
            scanner.close();
        }
    }
}
