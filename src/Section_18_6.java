/*
Write a recursive method public static void randomFillSortedArray(int[] x, int l, int r, int a, int b) that
fills the array x between l and r with random values between a and b such that x is sorted.
 */

import java.util.Scanner;
import java.util.Random;

public class Section_18_6 {
    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        int arraySize = scanscan.nextInt();

        System.out.print("Enter the lower bound (a): ");
        int a = scanscan.nextInt();
        System.out.print("Enter the upper bound (b): ");
        int b = scanscan.nextInt();

        int[] array = new int[arraySize];

        // Fill the array recursively
        randomFillSortedArray(array, 0, arraySize - 1, a, b);

        // Print the sorted array
        System.out.println("Generated sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanscan.close();
    }

    public static void randomFillSortedArray(int[] x, int l, int r, int a, int b) {
        // Base case: if left index exceeds right, stop
        if (l > r) {
            return;
        }

        Random rand = new Random();

        // If l == 0, pick a random number between a and b freely
        if (l == 0) {
            x[l] = rand.nextInt(b - a + 1) + a;
        } else {
            // Ensure the next value is at least as large as the previous value
            int minValue = x[l-1];
            // Generate a random number that is at least x[l-1] to maintain order
            x[1] = rand.nextInt(b -x[l-1]+1)+x[l-1];
        }

        // Recursive call for the next index
        randomFillSortedArray(x, l+1, r, a, b);
    }
}
