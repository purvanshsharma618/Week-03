package com.performance.stringconcatenationperformance;

public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int N : sizes) {
            System.out.println("Dataset Size: " + N);

            // Using String
            long startTime = System.currentTimeMillis();
            String str = "";
            for (int i = 0; i < N; i++) {
                str += "a"; // Inefficient
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken with String: " + (endTime - startTime) + "ms");

            // Using StringBuilder
            startTime = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append("a");
            }
            endTime = System.currentTimeMillis();
            System.out.println("Time taken with StringBuilder: " + (endTime - startTime) + "ms");

            // Using StringBuffer
            startTime = System.currentTimeMillis();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < N; i++) {
                sbf.append("a");
            }
            endTime = System.currentTimeMillis();
            System.out.println("Time taken with StringBuffer: " + (endTime - startTime) + "ms");

            System.out.println("---------------------------------");
        }
    }
}
