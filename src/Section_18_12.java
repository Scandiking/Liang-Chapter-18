/*
(Print the characters in a string reversely)
Rewrite programming exercise 18.9 using a helper method to pass the substring high index to the method. The helper method header is:
public static void reverseDisplay(String value, int high)
 */

// Instead of using substring(), we pass an index(high) to track the current character. This avoids unnecessary string operations, making it faster.

import java.util.Scanner;

public class Section_18_12 {
    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter a string to reverse: ");
        String input = scanscan.nextLine();

        // Display the reversed string using recursion
        System.out.print("Reversed string: ");
        reverseDisplay(input, input.length() - 1);
        System.out.println();

        scanscan.close();
    }

    // Helper recursive method to print a string in revese
    public static void reverseDisplay(String value, int high) {
        // Base case: Stop when index is out of bounds
        if (high < 0) {
            return;
        }

        // Print the current character
        System.out.print(value.charAt(high));

        // Recursive call with the next lower index
        reverseDisplay(value, high - 1);
    }
}
