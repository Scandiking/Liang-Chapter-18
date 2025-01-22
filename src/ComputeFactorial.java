/*
Recursion is a technique that leads to elegant solutions to problems that are difficult to program using simple loops
(Liang, 2020, p. 742)

In this program we let the user input a non-negative integer. If n > 0, the function calculates the factorial by multiplying n by the factorial of (n-1).
When n reaches 0, the function hits the stop condition and returns 1. This acts as the "bottom" of the recursion.
Each recursive call now starts returning values back up the call stack. For example, if n = 3, the calls would look like:
factorial(3) = 3 * factorial(2)
factorial(2) = 2 * factorial(1)
factorial(1) = 1 * factorial(0)
factorial(0) = 1 (base case) // and stops




 */

import java.util.Scanner;

public class ComputeFactorial {
    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = scanscan.nextInt();

        // Display factorial
        System.out.print("Factorial of " + n + " is: " + factorial(n));
    }

    public static long factorial(int n) {
        if (n == 0) // base case that prevents infinte recursion
            return 1;
        else
            return n * factorial(n - 1); // Recursive call
    }

}
