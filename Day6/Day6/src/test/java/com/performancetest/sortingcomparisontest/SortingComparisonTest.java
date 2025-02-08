package com.performancetest.sortingcomparisontest;

import static org.junit.jupiter.api.Assertions.*;

import com.performance.sortingcomparison.SortingComparison;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

public class SortingComparisonTest {
    private int[] unsortedArray;
    private int[] sortedArray;

    @BeforeEach
    void setUp() {
        // Generate a random array for testing
        unsortedArray = SortingComparison.generateRandomArray(1000); // Use 1000 elements for testing
        sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Arrays.sort(sortedArray); // Sort using Java's built-in sort for comparison
    }

    @Test
    void testBubbleSort() {
        int[] testArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingComparison.bubbleSort(testArray);
        assertArrayEquals(sortedArray, testArray, "Bubble Sort failed!");
    }

    @Test
    void testMergeSort() {
        int[] testArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingComparison.mergeSort(testArray);
        assertArrayEquals(sortedArray, testArray, "Merge Sort failed!");
    }

    @Test
    void testQuickSort() {
        int[] testArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingComparison.quickSort(testArray, 0, testArray.length - 1);
        assertArrayEquals(sortedArray, testArray, "Quick Sort failed!");
    }

    @Test
    void testSortingEmptyArray() {
        int[] emptyArray = {};
        SortingComparison.bubbleSort(emptyArray);
        SortingComparison.mergeSort(emptyArray);
        SortingComparison.quickSort(emptyArray, 0, 0);
        assertArrayEquals(new int[]{}, emptyArray, "Sorting empty array should work!");
    }

    @Test
    void testSortingSingleElementArray() {
        int[] singleElementArray = {42};
        SortingComparison.bubbleSort(singleElementArray);
        SortingComparison.mergeSort(singleElementArray);
        SortingComparison.quickSort(singleElementArray, 0, 0);
        assertArrayEquals(new int[]{42}, singleElementArray, "Sorting single-element array should work!");
    }

    @Test
    void testSortingAlreadySortedArray() {
        int[] alreadySortedArray = Arrays.copyOf(sortedArray, sortedArray.length);
        SortingComparison.bubbleSort(alreadySortedArray);
        SortingComparison.mergeSort(alreadySortedArray);
        SortingComparison.quickSort(alreadySortedArray, 0, alreadySortedArray.length - 1);
        assertArrayEquals(sortedArray, alreadySortedArray, "Sorting an already sorted array should not change it!");
    }

    @Test
    void testSortingReverseSortedArray() {
        int[] reverseSortedArray = Arrays.copyOf(sortedArray, sortedArray.length);
        for (int i = 0, j = reverseSortedArray.length - 1; i < j; i++, j--) {
            int temp = reverseSortedArray[i];
            reverseSortedArray[i] = reverseSortedArray[j];
            reverseSortedArray[j] = temp;
        }
        SortingComparison.bubbleSort(reverseSortedArray);
        SortingComparison.mergeSort(reverseSortedArray);
        SortingComparison.quickSort(reverseSortedArray, 0, reverseSortedArray.length - 1);
        assertArrayEquals(sortedArray, reverseSortedArray, "Sorting reverse sorted array should work!");
    }
}

