/*
Occurrences of a specified character in a string
Rewrite programming exercise 18.10 using a helper method to pass the substring high index to the method. The helper method header is:
public static int count(String str, char a, int high)
 */

import java.util.Scanner;

public class Section_18_15 {
    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);

        // Prompt for user input
        System.out.print("Enter a string: ");
        String input = scanscan.nextLine();

        System.out.println("Enter a character to count: ");
        char target = scanscan.next().charAt(0); // Read a single character

        // Call the recursive helper method
        int count = count(input, target, input.length() - 1);

        // Display result
        System.out.println("The character '" + target + "' appears " + count + " times.");

        scanscan.close();
    }

    // Helper recursive method to count occurences of 'a' in 'str' using high index
    public static int count(String str, char a, int high) {
        // Base case: if index is negative, stop recursion
        if (high < 0) {
            return 0;
        }

        // Check if the current character matches 'a'
        int currentMatch = (str.charAt(high) == a) ? 1: 0;

        // Recursive call with the next lower index
        return currentMatch + count(str, a, high - 1);
    }
}
