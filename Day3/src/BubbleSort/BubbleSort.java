package BubbleSort; // Package declaration

public class BubbleSort {

    // Method to display the marks after sorting
    public static void displayMarks(int[] marks) {
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " "); // Print each mark followed by a space
        }
        System.out.println(); // Move to the next line after printing all marks
    }

    public static void main(String[] args) {

        // Marks of the students to be sorted
        int[] marks = {74, 99, 87, 80, 64, 79};

        // Implementing Bubble Sort to sort the student marks in ascending order
        for (int i = 0; i < marks.length - 1; i++) { // Outer loop controls passes
            for (int j = 0; j < marks.length - i - 1; j++) { // Inner loop for comparisons
                // Compare adjacent elements and swap if they are in the wrong order
                if (marks[j] > marks[j + 1]) {
                    // Swap the elements
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }

        // Display the sorted marks
        displayMarks(marks);
    }
}
