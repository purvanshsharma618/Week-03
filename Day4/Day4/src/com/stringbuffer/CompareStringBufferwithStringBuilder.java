package com.stringbuffer;

public class CompareStringBufferwithStringBuilder {

    // Method to measure time taken by StringBuffer for concatenation
    public static long concatenateUsingBuffer() {
        StringBuffer strBuffer = new StringBuffer();
        long start = System.nanoTime(); // Start time

        for (int i = 1; i <= 1_000_000; i++) {
            strBuffer.append("hello");
        }

        return System.nanoTime() - start; // Return elapsed time
    }

    // Method to measure time taken by StringBuilder for concatenation
    public static long concatenateUsingBuilder() {
        StringBuilder strBuilder = new StringBuilder();
        long start = System.nanoTime(); // Start time

        for (int i = 1; i <= 1_000_000; i++) {
            strBuilder.append("hello");
        }

        return System.nanoTime() - start; // Return elapsed time
    }

    public static void main(String[] args) {
        // Measure time taken by StringBuffer
        long timeForStringBuffer = concatenateUsingBuffer();
        System.out.println("Time taken by StringBuffer: " + timeForStringBuffer + " ns");

        // Measure time taken by StringBuilder
        long timeForStringBuilder = concatenateUsingBuilder();
        System.out.println("Time taken by StringBuilder: " + timeForStringBuilder + " ns");

        //Comparision
        if (timeForStringBuffer > timeForStringBuilder) {
            System.out.println("StringBuffer takes more time compared to StringBuilder.");
        } else {
            System.out.println("StringBuilder takes more time compared to StringBuffer.");
        }
    }
}
