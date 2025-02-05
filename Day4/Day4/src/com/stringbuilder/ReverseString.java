package com.stringbuilder;

public class ReverseString {

    // Method to reverse a given string using StringBuilder
    public static String reverse(String input) {
        StringBuilder strBuilder = new StringBuilder(input); // Initialize StringBuilder with input
        return strBuilder.reverse().toString(); // Reverse and convert to string
    }

    public static void main(String[] args) {
        String input = "hello"; // Example input
        String reversedString = reverse(input); // Call the reverse method
        System.out.println("Reversed String: " + reversedString); // Output result
    }
}
