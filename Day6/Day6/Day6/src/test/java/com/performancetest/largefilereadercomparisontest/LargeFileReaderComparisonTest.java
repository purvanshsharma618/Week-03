package com.performancetest.largefilereadercomparisontest;

import java.io.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LargeFileReaderComparisonTest {
    public static void main(String[] args) {
        String[] fileSizes = {"1MB", "100MB", "500MB"};
        for (String size : fileSizes) {
            String filePath = "C:\\Users\\purva\\OneDrive\\Desktop\\Week 03\\Day6\\Day6\\Day6\\src\\main\\java\\com\\performance\\largefilereadercomparison\\LargeFile.txt" + size + ".txt";

            System.out.println("Reading a large file (" + size + ") using different methods:\n");

            // Measuring FileReader time
            long fileReaderTime = measureFileReaderTime(filePath);
            System.out.println("FileReader Time for " + size + ": " + fileReaderTime + " ms\n");

            // Measuring InputStreamReader time
            long inputStreamReaderTime = measureInputStreamReaderTime(filePath);
            System.out.println("InputStreamReader Time for " + size + ": " + inputStreamReaderTime + " ms\n");
        }
    }

    public static long measureFileReaderTime(String filePath) {
        long startTime = System.currentTimeMillis();
        try (FileReader reader = new FileReader(filePath)) {
            while (reader.read() != -1) {
                // Reading character by character (inefficient for large files)
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }

    public static long measureInputStreamReaderTime(String filePath) {
        long startTime = System.currentTimeMillis();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            while (reader.read() != -1) {
                // Reading byte-by-byte and converting to character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }

    @Test
    public void testFileReaderPerformance() {
        String[] testFileSizes = {"1MB", "100MB", "500MB"};
        for (String size : testFileSizes) {
            String testFilePath = "C:\\Users\\purva\\OneDrive\\Desktop\\Week 03\\Day6\\Day6\\Day6\\src\\main\\java\\com\\performance\\largefile_" + size + ".txt";
            long time = measureFileReaderTime(testFilePath);
            assertTrue(time > 0, "FileReader should take some time to read the " + size + " file.");
        }
    }

    @Test
    public void testInputStreamReaderPerformance() {
        String[] testFileSizes = {"1MB", "100MB", "500MB"};
        for (String size : testFileSizes) {
            String testFilePath = "C:\\Users\\purva\\OneDrive\\Desktop\\Week 03\\Day6\\Day6\\Day6\\src\\main\\java\\com\\performance\\largefile_" + size + ".txt";
            long time = measureInputStreamReaderTime(testFilePath);
            assertTrue(time > 0, "InputStreamReader should take some time to read the " + size + " file.");
        }
    }
}
