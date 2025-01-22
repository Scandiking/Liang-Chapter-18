public class RecursiveSelectionSort {
    public static void sort(double[] list) {
        // Call the private recursive sort method to sort the entire list
        sort(list, 0, list.length - 1);
    }


    // Private method that sorts a portion of the list recursively
    private static void sort(double[] list, int low, int high) {
        // Base case: if the current range has less than two elements, it is already sorted
        if (low < high) {
            // Find the smallest element and its index in the range list [low...high]
            int indexOfMin = low; // Assume the first element is the smallest
            double min = list[low]; // Store the value of the smallest element

            // Loop through the rest of the range to find the actual smallest element
            for (int i = low + 1; i <= high; i++) {
                if (list[i] < min) {
                    min = list[i]; // Update the smallest value
                    indexOfMin = i; // Update the index of the smallest element
                }
            }

            // Swap the smallest in list[low...high] with list[low]
            list[indexOfMin] = list[low]; // Move the current first element to the position of the smallest
            list[low] = min; // Move the smallest element to the front of the range

            // Recursively sort the remaining part of the list (excluding the already sorted part)
            sort(list, low + 1, high);
        }
    }
}
