/*
Fibonacci series
Modify listing 18.2, ComputeFibonacci.java, so that the program find the number of times the fib method is called.
(Hint: use a static variable and increment it every time the method is called.
 */

import java.util.Scanner;

public class Section_18_7 {
    // Static variable to count the number of calls
    private static int callCount = 0;

    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = scanscan.nextInt();

        // Reset the call count before computing Fibonaacci
        callCount = 0;

        // Compute the Fibonacci number
        long result = fib(index);

        // Display the results
        System.out.println("The Fibonacci number at index " + index + " is " + result);
        System.out.println("The fib method was called " + callCount + " times");

        scanscan.close();
    }

    // Recursive Fibonacci method with call counter
    public static long fib(long index) {
        // Increment call counter everytime fib() is called
        callCount++;

        // Base cases
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        }

        // Recursive case
        return fib(index - 1) + fib(index - 2);
    }
}