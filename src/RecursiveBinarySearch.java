public class RecursiveBinarySearch {
    public static int binarySearch(int[] list, int key) {
        int low = 0; // Start the search from the beginning of the array
        int high = list.length - 1; // End the search at the last index of the array
        return binarySearch(list, key, low, high); // Call the recursive method
    }

    // Private method to perform the recursive binary search
    private static int binarySearch(int[] list, int key, int low, int high) {
        // Base case: if the range is invalid (low > high), the key is not found
        if (low > high)
            return -low - 1; // Return a negative value to indicate key is not found

        int mid = (low + high) / 2; // Calculate the middle index
        if (key < list[mid])
            // If the key is smaller than the middle value, search the left half
            return binarySearch(list, key, low, mid - 1);
        else if (key == list[mid])
            // If the key matches the middle value, return the middle index
            return mid;
        else
            // If the key is greater than the middle value, search the right half
            return binarySearch(list, key, mid + 1, high);

    }

    // main method added
    public static void main(String[] args) {
        ///  Example sorted array
        int[] array={1, 3, 5, 7, 9, 11};

        // Test the search with a key that exists in the array
        int key1=7;
        System.out.println("Index of " + key1 + ": " + binarySearch(array, key1)); // (Index of 7: 3)

        // Test the search with a key that does not exist in the array
        int key2 =4;
        System.out.println("Index of " + key2 + ": " + binarySearch(array, key2)); // (Index of 4: -3 (not found, can be inserted at index 2)

        // Test the search with the first element in the array
        int key3=1;
        System.out.println("Index of " + key3 + ": " + binarySearch(array, key3)); // Index of 1: 0
    }
}

