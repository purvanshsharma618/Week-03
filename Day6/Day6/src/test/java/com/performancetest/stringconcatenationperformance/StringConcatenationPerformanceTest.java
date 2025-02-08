package com.performancetest.stringconcatenationperformance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringConcatenationPerformanceTest {

    @Test
    void testStringConcatenation() {
        int N = 1000;
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a"; // Inefficient
        }
        assertEquals(N, str.length());
    }

    @Test
    void testStringBuilderConcatenation() {
        int N = 1000;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        assertEquals(N, sb.length());
    }

    @Test
    void testStringBufferConcatenation() {
        int N = 1000;
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append("a");
        }
        assertEquals(N, sbf.length());
    }

    @Test
    void testPerformanceStringBuilderVsString() {
        int N = 10000;

        // Measure time for String concatenation
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a"; // Inefficient
        }
        long stringTime = System.nanoTime() - startTime;

        // Measure time for StringBuilder
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        long builderTime = System.nanoTime() - startTime;

        // StringBuilder should be significantly faster
        assertTrue(builderTime < stringTime);
    }

    @Test
    void testPerformanceStringBufferVsStringBuilder() {
        int N = 10000;

        // Measure time for StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        long builderTime = System.nanoTime() - startTime;

        // Measure time for StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append("a");
        }
        long bufferTime = System.nanoTime() - startTime;

        // StringBuffer should be slightly slower than StringBuilder (due to synchronization)
        assertTrue(builderTime <= bufferTime);
    }
}

