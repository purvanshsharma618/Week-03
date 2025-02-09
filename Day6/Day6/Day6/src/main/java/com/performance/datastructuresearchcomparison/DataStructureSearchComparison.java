package com.performance.dataStructuresearchcomparison;

import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1_000, 100_000, 1_000_000};

        for (int size : sizes) {
            System.out.println("Dataset Size: " + size);

            // Generate random data
            Random rand = new Random();
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                int num = rand.nextInt(size * 10);
                array[i] = num;
                hashSet.add(num);
                treeSet.add(num);
            }

            // Pick a random element to search
            int searchElement = array[rand.nextInt(size)];

            // Measure time for Array search (O(N))
            long start = System.nanoTime();
            boolean foundArray = linearSearch(array, searchElement);
            long arrayTime = System.nanoTime() - start;

            // Measure time for HashSet search (O(1))
            start = System.nanoTime();
            boolean foundHashSet = hashSet.contains(searchElement);
            long hashSetTime = System.nanoTime() - start;

            // Measure time for TreeSet search (O(log N))
            start = System.nanoTime();
            boolean foundTreeSet = treeSet.contains(searchElement);
            long treeSetTime = System.nanoTime() - start;

            // Print results
            System.out.printf("Array Search (O(N)): %d ns, Found: %b\n", arrayTime, foundArray);
            System.out.printf("HashSet Search (O(1)): %d ns, Found: %b\n", hashSetTime, foundHashSet);
            System.out.printf("TreeSet Search (O(log N)): %d ns, Found: %b\n", treeSetTime, foundTreeSet);
            System.out.println();
        }
    }

    // Linear search for Array
    private static boolean linearSearch(int[] arr, int key) {
        for (int num : arr) {
            if (num == key) return true;
        }
        return false;
    }
}

