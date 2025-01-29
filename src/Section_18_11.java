/*
Write a recursive method that displays all permutations of a given array of integers.
Here is a sample run:
Enter the array size: 3
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
 */


import java.util.Scanner;
import java.util.Arrays;

public class Section_18_11 {
    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);

        // Get the size of the array
        System.out.print("Enter the array size: ");
        int size = scanscan.nextInt();

        // Create and fill the array
        int[] array = new int[size];
        for (int i =0; i < size; i++) {
            array[i] = i + 1; // Filling the awrray with 1, 2, 3, ... n
        }

        // Print all permutations
        System.out.println("Permutations: ");
        generatePermutations(array, 0);

        scanscan.close();
    }

    // Recursive method to generate all permutations
    public static void generatePermutations(int[] array, int index) {
        // Base case: if we reached the end, print the permutation
        if (index == array.length - 1) {
            System.out.println(Arrays.toString(array));
            return;
        }

        // Swap each element with the current index and recurse
        for (int i = index; i < array.length; i++) {
            swap(array, index, i); // Swap elements
            generatePermutations(array, index + 1); // Recursive call
            swap(array, index, i); // Backtrack (undo the swap)
        }
    }

    // Helper method to swap elements in the array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
