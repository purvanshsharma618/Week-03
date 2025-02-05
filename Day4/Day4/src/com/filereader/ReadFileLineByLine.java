package com.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine {

    public static void main(String[] args) {
        // Creating a FileReader object to read the specified file
       try {

           // Creating a FileReader object to read the specified file
           FileReader file = new FileReader("C:\\Users\\purva\\OneDrive\\Desktop\\Week 03\\Day4\\Day4\\src\\com\\filereader\\File1.txt");

           // Wrapping FileReader with BufferedReader for efficient reading
           BufferedReader bufferedReader = new BufferedReader(file);

           String line; // Variable to store each line read from the file

           while ((line = bufferedReader.readLine()) != null) {
               System.out.println(line);
           }

           //Close the Buffer Reader
           bufferedReader.close();
       }
       catch (IOException e){

           // Handling file reading exceptions and printing the stack trace
           e.printStackTrace();
       }

    }
}
