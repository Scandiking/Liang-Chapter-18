/*
A recursive method is said to be tail recursive if there are no pending operations to be performed on return from a recursive call.
 */

public class ComputeFactorialTailRecursion {
    // Return the factorial for a specified number
    public static long factorial(int n) {
        return factorial(n, 1); // Call aux method
    }

    // Aux tail-recursive method for factorial
    private static long factorial(int n, int result) {
        if (n==0)
            return result;
        else
            return factorial(n-1, n*result); // Recursive call
    }
}
