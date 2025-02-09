package com.performancetest.searchtargettest;

import com.performance.searchtarget.SearchTarget;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SearchTargetTest {

    @Test
    void testLinearSearch_Found() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(2, SearchTarget.linearSearch(arr, 5));
    }

    @Test
    void testLinearSearch_NotFound() {
        int[] arr = {2, 4, 6, 8, 10};
        assertEquals(-1, SearchTarget.linearSearch(arr, 7));
    }

    @Test
    void testBinarySearch_Found() {
        int[] arr = {2, 4, 6, 8, 10};
        assertEquals(3, SearchTarget.binarySearch(arr, 8));
    }

    @Test
    void testBinarySearch_NotFound() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(-1, SearchTarget.binarySearch(arr, 2));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        int[] arr = {};
        assertEquals(-1, SearchTarget.binarySearch(arr, 5));
    }

    @Test
    void testLinearSearch_EmptyArray() {
        int[] arr = {};
        assertEquals(-1, SearchTarget.linearSearch(arr, 5));
    }

    @Test
    void testBinarySearch_SingleElementFound() {
        int[] arr = {10};
        assertEquals(0, SearchTarget.binarySearch(arr, 10));
    }

    @Test
    void testBinarySearch_SingleElementNotFound() {
        int[] arr = {10};
        assertEquals(-1, SearchTarget.binarySearch(arr, 5));
    }

    @Test
    void testBinarySearch_RandomArray() {
        int[] arr = new Random().ints(100, 1, 1000).toArray();
        Arrays.sort(arr);
        int target = arr[arr.length / 2]; // Pick a middle element
        assertTrue(SearchTarget.binarySearch(arr, target) >= 0);
    }

    @Test
    void testLinearSearch_RandomArray() {
        int[] arr = new Random().ints(100, 1, 1000).toArray();
        int target = arr[arr.length / 2]; // Pick a middle element
        assertTrue(SearchTarget.linearSearch(arr, target) >= 0);
    }
}


