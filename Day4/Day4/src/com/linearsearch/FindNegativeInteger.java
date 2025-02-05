package com.linearsearch;

import java.util.*;

public class FindNegativeInteger {

    //Method to find index of negative integer present in the given array
    public static int findNegativeInteger(int[] values){

        //Traverse the array
        for(int i=0;i< values.length;i++){

            //Condition to check whether the array element is less than zero i.e. negative
            if(values[i] < 0) {

                return i; //Return the index of negative integer
            }
        }
        return -1; // Return -1 if no negative integer is present
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Taking size of array as user input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        //Declaring array that contains integers
        int[] values = new int[n];

        //Taking array elements as user input
        for(int i=0;i<values.length;i++){
            values[i] = sc.nextInt();
        }

        //Calling method that finds the index of the negative integer present in the array
        int ans = findNegativeInteger(values);
        System.out.println("Negative number is found at index: " + ans);

    }
}