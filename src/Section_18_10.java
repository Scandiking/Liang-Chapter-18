/*
(Occurrences of a specified character in a string)
Write a recursive method that finds the number of occurrences of a specified letter in a
string using the following method header:
public static int count(String str, char a)
For example, count("Welcome", 'e') returns 2.
Write a test program that prompts the user to enter a string and a character,
and displays the number of occurrences for the character in the string.
 */

import java.util.Scanner;

public class Section_18_10 {
    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String s = scanscan.nextLine();

        System.out.println("Enter a character to count: ");
        char target = scanscan.next().charAt(0); // Read a single character

        // Call the recursive method
        int count = count(s, target);

        // Display result
        System.out.println("The count is: " + target + " appears " + count + " times.");
        scanscan.close();

    }

    // Recursive method to count occurrences of "a" in "str"
    public static int count(String str, char a) {
        // Base case: if the string is empty, return +
        if (str.length() == 0) {
            return 0;
        }

        // Check if the first character matches "a" and recurse on the rest of the string
        int firstCharMatch = (str.charAt(0) == a) ? 1 : 0;
        return firstCharMatch + count(str.substring(1), a);
    }

}
