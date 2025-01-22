import java.util.Scanner;

public class ComputeFibonacci {
    public static void main(String[] args) {
        // Create a scanner
        Scanner scanscan = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = scanscan.nextInt();

        // Find and display the Fibonacci number
        System.out.println("The Fibonacci number at index " + index + " is " + fib(index));
    }

    // Method to find the Fibonacci number
    public static long fib(long index) {
        if (index == 0) // Base case
            return 0;
        else // Reduction and recursive calls
        // You will probably get a StackOverflowError from this (it recomputes the fibo values repeatedly in the
            // recursive calls which quicly leads to a massive number of calls for larger indices (exponential growth)
            return fib(index - 1) + fib(index - 2);
    }
}

/*
The "considerable amount of work" is mentioned in the book, but does not mention any technical solutions so let's
leave it as is.
 */
