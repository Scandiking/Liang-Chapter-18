/*
Print the characters in a string reversely
Write a recursive method that displays a string reversely on the console using the following header:
public static void reverseDisplay (String value)
For example, reverseDisplay("abcd") displays dcba. Write a test program that prompts the user to enter a string and displays its reversal.
 */

import java.util.Scanner;

public class Section_18_9 {
    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);

        // Prompt user input
        System.out.println("Enter a string to reverse: ");
        String input = scanscan.nextLine();

        // Display the reversed string using recursion
        System.out.print("Reversed string: ");
        reverseDisplay(input);
        System.out.println(); // Newline for formatting

        scanscan.close();
    }

    // Recursive method to print a string in reverse
    public static void reverseDisplay(String value) {
        // Base case: Stop if string is empty
        if (value.length() == 0) {
            return;
        }

        // Print the last character
        System.out.print(value.charAt(value.length() - 1));

        // Recursive call with the substring excluding the last character
        reverseDisplay(value.substring(0, value.length() - 1));
    }
}
