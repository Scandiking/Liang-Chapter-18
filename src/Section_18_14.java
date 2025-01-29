/*
Assume that you are not able to perform other operations on an int value than to decrement it and
compare it with zero and one.
Write two methods odd(int x) and even(int x) that respectively return if x is odd or even.
We assume that x>=0.
 */

import java.util.Scanner;

public class Section_18_14 {
    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);

        // Prompt user input
        System.out.println("Enter a non-negative integer: ");
        int x = scanscan.nextInt();

        // Check if the number is odd or even using recursion
        if (even(x)) {
            System.out.println(x + " is even.");
        } else {
            System.out.println(x + " is odd.");
        }

        scanscan.close();


    }

    // Recursive method to check if a number is even
    public static boolean even(int x) {
        if (x == 0) return true; // Base case: 0 is even
        if (x == 1) return false; // Base case: 1 is odd
        return odd(x-1); // Recursively check x -1
    }

    // Recursive method to check if a number is odd
    public static boolean odd(int x) {
        if (x == 0) return false; // Base case: 0 is even
        if (x == 1) return true; // Base case: 1 is odd
        return even(x-1); // Recursively check x1
    }

}
