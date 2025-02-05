package com.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccuranceOfWord {
    public static void main(String[] args) {
        // Creating a FileReader object to read the specified file
        try {

            // Creating a FileReader object to read the specified file
            FileReader file = new FileReader("C:\\Users\\purva\\OneDrive\\Desktop\\Week 03\\Day4\\Day4\\src\\com\\filereader\\File1.txt");

            // Wrapping FileReader with BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(file);
            String target = "my";
            String line; // Variable to store each line read from the file
            int count =0;
            while ((line = bufferedReader.readLine()) != null) {
                for(String str: line.split(" ")){
                    if(str.equalsIgnoreCase(target)){
                        count++;
                    }
                }
            }
            System.out.println(count);

            //Close the Buffer Reader
            bufferedReader.close();
        }
        catch (IOException e){

            // Handling file reading exceptions and printing the stack trace
            e.printStackTrace();
        }

    }
}
