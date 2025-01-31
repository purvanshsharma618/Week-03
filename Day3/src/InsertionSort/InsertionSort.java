package InsertionSort; // Package declaration

public class InsertionSort {

    // Method to display the employee IDs after sorting
    public static void displayIds(int[] ids){
        for(int i = 0; i < ids.length; i++){
            System.out.print(ids[i] + " "); // Print each ID followed by a space
        }
        System.out.println(); // Move to the next line after printing all IDs
    }

    public static void main(String[] args) {

        // Array of employee IDs to be sorted
        int[] ids = {101, 199, 100, 201, 550, 196};

        // Implementing Insertion Sort to sort the employee IDs in ascending order
        for(int i = 1; i < ids.length; i++){
            int current = ids[i]; // Store the current element to be inserted in the sorted part
            int j = i - 1; // Start comparing with the previous element

            // Shift elements of the sorted part to the right if they are greater than the current element
            while (j >= 0 && current < ids[j]){
                ids[j + 1] = ids[j]; // Move the larger element one position ahead
                j--; // Move backwards in the sorted part
            }
            // Place the current element at its correct position in the sorted part
            ids[j + 1] = current;
        }

        // Display the sorted IDs
        displayIds(ids);
    }
}
