/*
Find the largest number in an array
Write a recursive method that returns the largest integer in an array.
Write a test program that prompts the user to enter a list of eight integers and displays the largest element.
 */

// Recursive approach

import java.util.Scanner;

public class Section_18_13 {
    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);

        // Prompt user input
        System.out.println("Enter 8 integers: ");
        int[] array = new int[8];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanscan.nextInt();
        }

        // Call the recursive method
        int max = findMax(array, 0);

        // Display result
        System.out.println("The largest number is: " + max);

        scanscan.close();
    }

    // Recursive method to find the largest number in an array
    public static int findMax(int[] arr, int index) {
        // Base case: if we reach the last element, return it
        if (index == arr.length - 1) {
            return arr[index];
        }

        // Find the maximum between current element and the maximum of the rest
        return Math.max(arr[index], findMax(arr, index + 1));
    }
}
