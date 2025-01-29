/*
Write a recursive method public static void dec2b(double x, int b, int n) that displays x, where 0<=x<1 in
base b with at most n digits after the decimal point. For instance, dec2b(0.625, 2, 10) should return 0.101,
and dec2b(0.625, 3, 10) should return 0.1212121212.
 */

public class Section_18_3 {
    public static void main(String[] args) {
        System.out.print("0.");
        dec2b(0.625, 2, 10); // Expected output: 0.101
        System.out.println();

        System.out.print("0.");
        dec2b(0.625, 3, 10); // Expected output: 0.1212121212
        System.out.println();
    }

    // Recursive method to convert a decimal fraction to base b
    public static void dec2b(double x, int b, int n) {
        // Base case: stop when n digits have been displayed or x becomes 0
        if (n==0 || x == 0) {
            return;
        }

        // Multiplay x by base b
        double result = x * b;
        int digit=(int) result; // Get the integer part (this is the next digit in base b)

        System.out.print(digit);

        // Recursive call with the remaining fraction part
        dec2b(result-digit, b, n-1);
    }
}
