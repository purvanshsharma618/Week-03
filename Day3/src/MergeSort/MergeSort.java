package MergeSort; // Package declaration

public class MergeSort {

    // Method to merge two sorted subarrays into a single sorted array
    public static void conquer(int[] bookPrices, int si, int mid, int ei) {
        int[] merged = new int[ei - si + 1]; // Temporary array to store merged elements
        int idx1 = si; // Pointer for the left subarray
        int idx2 = mid + 1; // Pointer for the right subarray
        int x = 0; // Index for merged array

        // Merge the two sorted subarrays
        while (idx1 <= mid && idx2 <= ei) {
            if (bookPrices[idx1] <= bookPrices[idx2]) {
                merged[x++] = bookPrices[idx1++];
            } else {
                merged[x++] = bookPrices[idx2++];
            }
        }

        // Copy remaining elements from the left subarray, if any
        while (idx1 <= mid) {
            merged[x++] = bookPrices[idx1++];
        }

        // Copy remaining elements from the right subarray, if any
        while (idx2 <= ei) {
            merged[x++] = bookPrices[idx2++];
        }

        // Copy sorted elements back to the original array
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            bookPrices[j] = merged[i];
        }
    }

    // Recursive method to divide the array into two halves
    public static void divide(int[] bookPrices, int si, int ei) {
        if (si >= ei) {
            return; // Base condition: when there is only one element left
        }

        int mid = si + (ei - si) / 2; // Calculate the middle index
        divide(bookPrices, si, mid); // Recursively divide the left half
        divide(bookPrices, mid + 1, ei); // Recursively divide the right half
        conquer(bookPrices, si, mid, ei); // Merge the sorted halves
    }

    public static void main(String[] args) {
        // Array of book prices to be sorted
        int[] bookPrices = {200, 150, 425, 500, 100, 160};
        int n = bookPrices.length;

        // Call the divide function to initiate merge sort
        divide(bookPrices, 0, n - 1);

        // Display the sorted book prices
        for (int i = 0; i < n; i++) {
            System.out.print(bookPrices[i] + " "); // Print each price followed by a space
        }
        System.out.println(); // Move to the next line after printing all prices
    }
}
