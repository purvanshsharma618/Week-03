package com.performance.sortingcomparison;

import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int size : sizes) {
            System.out.println("Dataset Size: " + size);
            int[] data = generateRandomArray(size);

            // Measure Bubble Sort (Skipped for large N due to inefficiency)
            if (size <= 10000) {
                int[] bubbleData = Arrays.copyOf(data, data.length);
                long start = System.currentTimeMillis();
                bubbleSort(bubbleData);
                long end = System.currentTimeMillis();
                System.out.println("Bubble Sort: " + (end - start) + " ms");
            } else {
                System.out.println("Bubble Sort: Unfeasible");
            }

            // Measure Merge Sort
            int[] mergeData = Arrays.copyOf(data, data.length);
            long start = System.currentTimeMillis();
            mergeSort(mergeData);
            long end = System.currentTimeMillis();
            System.out.println("Merge Sort: " + (end - start) + " ms");

            // Measure Quick Sort
            int[] quickData = Arrays.copyOf(data, data.length);
            start = System.currentTimeMillis();
            quickSort(quickData, 0, quickData.length - 1);
            end = System.currentTimeMillis();
            System.out.println("Quick Sort: " + (end - start) + " ms");

            System.out.println("--------------------------");
        }
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000000); // Random numbers up to 1 million
        }
        return array;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

