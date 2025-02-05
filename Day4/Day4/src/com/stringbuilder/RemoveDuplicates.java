package com.stringbuilder;

import java.util.HashSet;

public class RemoveDuplicates {

    // Method to remove duplicate characters from a string
    public static String remove(String string) {
        StringBuilder str = new StringBuilder(); // StringBuilder to store the result
        HashSet<Character> set = new HashSet<>(); // HashSet to track unique characters

        // Iterate through each character in the string
        for (char ch : string.toCharArray()) {
            // If character is not already in the set, add it to the result
            if (!set.contains(ch)) {
                str.append(ch);
                set.add(ch); // Mark character as seen
            }
        }
        return str.toString(); // Return the modified string
    }

    public static void main(String[] args) {
        String string = "sharma"; // Input string
        String ans = remove(string); // Call method to remove duplicates
        System.out.println(ans); // Output the result
    }
}