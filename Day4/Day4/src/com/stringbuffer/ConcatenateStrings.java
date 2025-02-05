package com.stringbuffer;

public class ConcatenateStrings {

    // Method to concatenate an array of strings
    public static String concatenate(String[] inputString) {
        StringBuffer strBuffer = new StringBuffer(); // StringBuffer to store the concatenated string

        // Iterate through each string in the array
        for (String str : inputString) {
            strBuffer.append(str); // Append each string to the buffer
        }

        return strBuffer.toString(); // Convert StringBuffer to String and return
    }

    public static void main(String[] args) {
        // Array of strings to be concatenated
        String[] inputString = {"Hello ", "Hii ", "Namaste ", "Salaam "};

        // Call the concatenate method and store the result
        String ans = concatenate(inputString);

        // Print the concatenated string
        System.out.println(ans);
    }
}