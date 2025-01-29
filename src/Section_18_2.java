/*
Fibonacci numbers
Rewrite the fib method in Listing 18.2 using iterations.
Hint: To compute fib(n) without recursion, you need to obtain fib(n-2) and fib(n-1) first.
Let f0 and f1 denote the two previous Fibonacci numbers. The current Fibonacci number would then be f0 + f1.
The algorithm can be described as follows:
f0 = 0; // For fib(0)
f1 = 1; // For fib(1)
 */

import java.util.Scanner;

public class Section_18_2 {
    public static void main(String[] args) {
        // Create a new instance of a scanner
        Scanner scanscan = new Scanner(System.in);
        System.out.println("Enter an index for a Fibonacci number: ");
        // Save the user input
        int index = scanscan.nextInt();

        // Find and display the Fibonacci number
        System.out.println("The Fibonacci number at index " + index + " is " + fib(index));

        scanscan.close();
    }

    // Iterative fib method
    public static long fib(int index) {
        if (index == 0) return 0;
        if (index == 1) return 1;

        long f0 = 0; // Initial fib number
        long f1 = 1; // Second fib number
        long currentFib = 0; // Variable to store the current Fibonacci number

        for (int i = 2; i <= index; i++) {
            currentFib = f0 + f1; // Calculate the next Fibonacci number
            f0 = f1; // Move f1 to f0
            f1 = currentFib; // Update f1 to the new calculated value
        }

        return currentFib; // Return the calculated Fibonacci number
    }
}
