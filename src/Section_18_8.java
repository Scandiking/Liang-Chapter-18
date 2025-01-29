/*
Let f be a function. Let l, r, and e be real numbers.
Write a recursive method that computes and returns a value v such that |f(v)|<=e, and l<v<r.
That is, a method that finds an approximation of a zero of f between l and r. We assume that f(l)f(r)<0.
 */

public class Section_18_8 {
    public static void main(String[] args) {
        double l = 1.09, r = 2.0, e = 0.0001; // Example range
        double root = findRoot(l, r, e);
        System.out.println("Approximate root: " + root);
    }

    // Recursive method to find a root using the bisection method
    public static double findRoot(double l, double r, double e) {
        double m = (l + r) / 2; // Midpoint

        // Base case: if f(m) is close enough to zero, return m
        if (Math.abs(f(m)) <= e) {
            return m;
        }

        // Determine which half contains the root
        if (f(l) * f(m) <0) {
            return findRoot(l, m, e); // Root is the left half
        } else {
            return findRoot(m, r, e); // Root is the right half
        }
    }

    // Example function f(v) = v^2 - 2 (Root is sqrt(2))
    public static double f(double v) {
        return v * v - 2;
    }
}

/*
This code tries to find sqrt(2) using f(v) = v^2 - 2
Step 1
m = (1.0 + 2.0) / 2 = 1.5
    f(1.5) = 1.5^2 - 2 = 0.25 (not close enough)
    f(1.0) * f(1.5) < 0, so go left: [1.0, 1.5]
Step 2
m = (1.0 + 1.5) / 2 = 1.25
    f(1.25) = 1.25^2 - 2 = -0.4375 (not close enough)
    f(1.25) * f(1.5) < 0, so go right: [1.25, 1.5]
(continues recursively...)
Eventually it converges to
sqrt(2) ≈ 1.4142
 */

