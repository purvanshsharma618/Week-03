package com.performance.fibonaccicomputation;

public class FibonacciComputation{

    // Recursive Fibonacci (Exponential Time Complexity: O(2^N))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (Linear Time Complexity: O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void runPerformanceTest(int N) {
        System.out.println("Fibonacci Computation for N = " + N);

        // Measure Recursive Execution Time
        long startTime = System.nanoTime();
        int recursiveResult = fibonacciRecursive(N);
        long endTime = System.nanoTime();
        double recursiveTime = (endTime - startTime) / 1e6; // Convert to milliseconds
        System.out.println("Recursive Fibonacci Result: " + recursiveResult);
        System.out.println("Time taken (Recursive): " + recursiveTime + " ms");

        // Measure Iterative Execution Time
        startTime = System.nanoTime();
        int iterativeResult = fibonacciIterative(N);
        endTime = System.nanoTime();
        double iterativeTime = (endTime - startTime) / 1e6; // Convert to milliseconds
        System.out.println("Iterative Fibonacci Result: " + iterativeResult);
        System.out.println("Time taken (Iterative): " + iterativeTime + " ms");

        System.out.println();
    }

    public static void main(String[] args) {
        int[] testCases = {10, 30, 50};

        for (int N : testCases) {
            if (N <= 30) { // Avoid recursive inefficiency for large values
                runPerformanceTest(N);
            } else {
                System.out.println("Skipping Recursive Fibonacci for N = " + N + " (Too Slow)");
                System.out.println("Fibonacci Iterative Result: " + fibonacciIterative(N));
                System.out.println();
            }
        }
    }
}
