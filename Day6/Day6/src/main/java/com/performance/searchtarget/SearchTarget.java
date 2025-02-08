package com.performance.searchtarget;

import java.util.Arrays;
import java.util.Random;

public class SearchTarget {

    // Linear Search Implementation
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return index if found
            }
        }
        return -1; // Return -1 if not found
    }

    // Binary Search Implementation
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void runSearchTest(int N) {
        int[] dataset = new int[N];
        Random random = new Random();

        // Fill the dataset with random numbers
        for (int i = 0; i < N; i++) {
            dataset[i] = random.nextInt(N);
        }

        int target = dataset[random.nextInt(N)]; // Random target from dataset

        // Measure Linear Search time
        long startTime = System.nanoTime();
        int linearResult = linearSearch(dataset, target);
        long endTime = System.nanoTime();
        double linearTime = (endTime - startTime) / 1e6; // Convert to milliseconds

        // Sort the array for Binary Search
        Arrays.sort(dataset);

        // Measure Binary Search time
        startTime = System.nanoTime();
        int binaryResult = binarySearch(dataset, target);
        endTime = System.nanoTime();
        double binaryTime = (endTime - startTime) / 1e6; // Convert to milliseconds

        // Print results
        System.out.println("Dataset Size: " + N);
        System.out.println("Linear Search Time: " + linearTime + " ms");
        System.out.println("Binary Search Time: " + binaryTime + " ms");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};

        for (int N : datasetSizes) {
            runSearchTest(N);
        }
    }
}