package SelectionSort; // Package declaration

public class SelectionSort {

    // Method to display the scores after sorting
    public static void displayScores(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " "); // Print each score followed by a space
        }
        System.out.println(); // Move to the next line after printing all scores
    }

    public static void main(String[] args) {

        // Scores of the students to be sorted
        int[] scores = {74, 99, 87, 80, 64, 79};

        // Implementing Selection Sort to sort the students' scores in ascending order
        for (int i = 0; i < scores.length - 1; i++) { // Outer loop selects the current position
            int smallest = i; // Assume the first unsorted element is the smallest

            // Find the smallest element in the remaining unsorted part
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[smallest] > scores[j]) {
                    smallest = j; // Update index of the smallest element
                }
            }

            // Swap the found smallest element with the element at index 'i'
            int temp = scores[smallest];
            scores[smallest] = scores[i];
            scores[i] = temp;
        }

        // Display the sorted scores
        displayScores(scores);
    }
}
