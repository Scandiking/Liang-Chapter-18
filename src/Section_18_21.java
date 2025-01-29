/*
Decimal to binary
Write a recursive method that convers a decimal number into a binary number as a string. The method header is
public static String dec2Bin(int value)
Write a test program that prompts the user to enter a binary string and displays its decimal equivalent.
 */

import java.util.Scanner;

public class Section_18_21 {
    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);

        // Convert decimal to binary
        System.out.print("Enter a decimal number: ");
        int decimal = scanscan.nextInt();
        System.out.println("Binary: " + dec2Bin(decimal));

        scanscan.close();
    }

    // Recursive method to convert decimal to binary
    public static String dec2Bin(int value) {
        if (value == 0) return "0"; // Edge case
        return dec2BinHelper(value);
    }

    private static String dec2BinHelper(int value) {
        if (value == 0) return ""; // Base case: No more divisions

        return dec2BinHelper(value / 2) + (value % 2); // Append remainder recursively
    }


    private static int bin2DecHelper(String binary, int index) {
        if (index == binary.length()) return 0; // Base case: Stop at end of string

        int digit = binary.charAt(index) - '0'; // Convert char to int (0 or 1)
        return (digit << (binary.length() - index - 1)) + bin2DecHelper(binary, index + 1);
    }
}
