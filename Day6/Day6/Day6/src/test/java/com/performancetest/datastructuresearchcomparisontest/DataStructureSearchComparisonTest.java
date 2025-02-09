package com.performancetest.datastructuresearchcomparisontest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class DataStructureSearchComparisonTest {
    private int[] array;
    private HashSet<Integer> hashSet;
    private TreeSet<Integer> treeSet;
    private int searchElement;

    @BeforeEach
    void setUp() {
        int size = 10000; // Test with 10,000 elements
        Random rand = new Random();
        array = new int[size];
        hashSet = new HashSet<>();
        treeSet = new TreeSet<>();

        // Populate data structures
        for (int i = 0; i < size; i++) {
            int num = rand.nextInt(size * 10);
            array[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        // Pick a random element from the array for testing
        searchElement = array[rand.nextInt(size)];
    }

    @Test
    void testLinearSearch() {
        assertTrue(linearSearch(array, searchElement), "Element should be found in Array");
        assertFalse(linearSearch(array, -1), "Non-existent element should not be found in Array");
    }

    @Test
    void testHashSetSearch() {
        assertTrue(hashSet.contains(searchElement), "Element should be found in HashSet");
        assertFalse(hashSet.contains(-1), "Non-existent element should not be found in HashSet");
    }

    @Test
    void testTreeSetSearch() {
        assertTrue(treeSet.contains(searchElement), "Element should be found in TreeSet");
        assertFalse(treeSet.contains(-1), "Non-existent element should not be found in TreeSet");
    }

    // Linear search for Array
    private boolean linearSearch(int[] arr, int key) {
        for (int num : arr) {
            if (num == key) return true;
        }
        return false;
    }
}

