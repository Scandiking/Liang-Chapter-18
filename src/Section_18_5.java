/*
The previous method is probably not efficient if you wrote it exactly as its recursive definition.
It is not because the method is recursive but because it has not been well-written.
It is quite east to verify that there is another recurrent definition of C(n, p), which is C(n, 0) = C(n, n) = 1,
otherwise C(n, p) = C(n, p-1) * (n-p+1)/p. Keeping this in mind, write the previous method.

Using C(n, p-1) * ((n-p+1)/(p))
 */



public class Section_18_5 {
    public static void main(String[] args) {
        long n = 5;
        long p = 2;
        System.out.println("C(" + n + "," + p + ") = " + C(n, p)); // Should print 10
    }

    public static long C(long n, long p) {
        // Base case
        if (p == 0 || p == n) {
            return 1;
        }

        // use the optimized recurrence relation
        return C(n, p - 1) * (n - p + 1) / p;
    }
}
