package com.performancetest.fibonaccicomputationtest;



import com.performance.fibonaccicomputation.FibonacciComputation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciComputationTest {

    @Test
    void testFibonacciRecursive() {
        assertEquals(0, FibonacciComputation.fibonacciRecursive(0));
        assertEquals(1, FibonacciComputation.fibonacciRecursive(1));
        assertEquals(1, FibonacciComputation.fibonacciRecursive(2));
        assertEquals(2, FibonacciComputation.fibonacciRecursive(3));
        assertEquals(3, FibonacciComputation.fibonacciRecursive(4));
        assertEquals(5, FibonacciComputation.fibonacciRecursive(5));
        assertEquals(55, FibonacciComputation.fibonacciRecursive(10));
        assertEquals(832040, FibonacciComputation.fibonacciRecursive(30));
    }

    @Test
    void testFibonacciIterative() {
        assertEquals(0, FibonacciComputation.fibonacciIterative(0));
        assertEquals(1, FibonacciComputation.fibonacciIterative(1));
        assertEquals(1, FibonacciComputation.fibonacciIterative(2));
        assertEquals(2, FibonacciComputation.fibonacciIterative(3));
        assertEquals(3, FibonacciComputation.fibonacciIterative(4));
        assertEquals(5, FibonacciComputation.fibonacciIterative(5));
        assertEquals(55, FibonacciComputation.fibonacciIterative(10));
        assertEquals(832040, FibonacciComputation.fibonacciIterative(30));
    }

    @Test
    void testPerformance() {
        int n = 30; // Reasonable limit for recursive
        long startTime = System.nanoTime();
        FibonacciComputation.fibonacciRecursive(n);
        long endTime = System.nanoTime();
        double recursiveTime = (endTime - startTime) / 1e6; // Convert to milliseconds
        System.out.println("Recursive Fibonacci for N = " + n + " took: " + recursiveTime + " ms");

        n = 50; // Reasonable limit for iterative
        startTime = System.nanoTime();
        FibonacciComputation.fibonacciIterative(n);
        endTime = System.nanoTime();
        double iterativeTime = (endTime - startTime) / 1e6; // Convert to milliseconds
        System.out.println("Iterative Fibonacci for N = " + n + " took: " + iterativeTime + " ms");
    }
}