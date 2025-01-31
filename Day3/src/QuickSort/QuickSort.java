package QuickSort;

import java.util.Arrays;

public class QuickSort {

    // Method to perform Quick Sort
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            // Find partition index
            int partitionIndex = partition(prices, low, high);

            // Recursively sort elements before and after partition
            quickSort(prices, low, partitionIndex - 1);
            quickSort(prices, partitionIndex + 1, high);
        }
    }

    // Partition method to place pivot at the correct position
    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // Choosing the last element as pivot
        int i = low - 1; // Index for smaller elements

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (prices[j] <= pivot) {
                i++;
                // Swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap pivot element with the element at i+1
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1; // Return partition index
    }

    public static void main(String[] args) {
        int[] productPrices = {1200, 500, 1500, 700, 1000};

        // Applying Quick Sort
        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println( Arrays.toString(productPrices));
    }
}