/*
Wrute a recursive method public static int pos(int[] a, int l, int r) that positions a[l] at its rank if the array a were sorted between l and r, and that returns this rank. That is, we assume that a is an unsorted array of int, l and r are int such that 0>=1 > = r < a.length, after this call : k = pos(a, l, r); a contains the same elements before anf after this call, but it is such that a[k] >= a[i] for all i in [l, k-1] and a[k] 6 a[j] for all j in [k+1, r].
For instance, consider this fragment:
int[] a = {8, 7, 4, 1, 9, 6, 2, 5, 3, 0};
System.out.println(Arrays.toString(a));
// [8, 7, 4, 1, 9, 6, 2, 5, 3, 0]
pos(a, 2, 7); // a[2..7] = {4, 1, 9, 6, 2, 5}
System.out.println(Arrays.toString(a));
/*[8, 7, 1, 2, 4, 6, 5, 9, 3, 0] is possible because 4 >= 2, 4 >= 1, 4 < 6, 4 < 5, 4 < 9.
But it could also be [8, 7, 2, 1, 4, 6, 5, 9, 3, 0], or [8, 7, 2, 1, 4, 9, 5, 6, 3, 0] /*
 */

import java.util.Arrays;

public class Section_18_16 {
    public static void main(String[] args) {
        int[] a = {8, 7, 4, 1, 9, 6, 2, 5, 3, 0};

        System.out.println("Before: " + Arrays.toString(a));

        int k = pos(a, 2, 7); // Partitioning subarray a [2...7]

        System.out.println("After: " + Arrays.toString(a));
        System.out.println("Position of pivot: " + k);
    }

    public static int pos(int[] a, int l, int r) {
        int pivot = a[l]; // Use first element as pivot
        int left = l + 1;
        int right = r;

        while (left <= right) {
            // Find an element greater than the pivot on the left
            while (left <= right && a[left] <= pivot) {
                left++;
            }

            // Find an element smaller than the pivot on the right
            while (left <= right && a[right] > pivot) {
                right--;
            }
        }

        // Swap pivot into its correct place
        swap(a, l, right);

        return right;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
