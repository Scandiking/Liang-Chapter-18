/*
Decimal to hex
Write a recursive method that converts a decimal number into a hex number as a string. The method header is:
public static string dec2Hex(int value)
Write a test program that prompts the user to enter a decimal number and displays its hex equivalent.
 */


import java.util.Scanner;

public class Section_18_22 {
    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);

        // Prompt user for decimal input
        System.out.println("Enter a decimal number: ");
        int decimal = scanscan.nextInt();

        // Convert decimal to hex
        System.out.println("Hexadecimal: " + dec2Hex(decimal));

        scanscan.close();
    }

    // Recursive method to convert decimal to hexadecimal
    public static String dec2Hex(int value) {
        if (value == 0) return "0"; // Edge case
        return dec2HexHelper(value);
    }

    private static String dec2HexHelper(int value) {
        if (value == 0) return ""; // base case stop when no more divisions
        int remainder = value % 16;
        char hexChar = (remainder < 10) ? (char) ('0' + remainder) : (char) ('A' + remainder - 10);
        return dec2HexHelper(value/16) + hexChar; // Recursive call + remainder as hex
    }
}
