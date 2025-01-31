package CountingSort;

import java.util.Arrays;

public class CountingSort{

    // Method to perform Counting Sort
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Count occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Compute cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in sorted order
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted elements back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 15, 14, 10, 18, 13, 17, 16, 12, 14};

        // Applying Counting Sort
        countingSort(studentAges, 10, 18);

        System.out.println(Arrays.toString(studentAges));
    }
}
