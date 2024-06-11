package com.example.demo.profile.practical;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Day1HackerRank {
	
    public static void main(String[] args) {
        int i = 4;	
        double d = 4.0;
        String s = "HackerRank ";
		
        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int i1=0; double d1=0.0; String s1="";

        // Note: If you have trouble reading the entire String, please go back
        // and review the Tutorial closely.
        
        /* Read and save an integer, double, and String to your variables.*/
        try {
        	System.out.println("Please enter a Integer number");
        	i1 = Integer.valueOf(scan.nextInt());
        } catch(InputMismatchException ex)	{
        	System.out.println("Not a valid Integer number");
        }
        
        try {
        	System.out.println("Please enter a Double number");
        	d1 = Double.valueOf(scan.nextDouble());
        } catch(InputMismatchException ex)	{
        	System.out.println("Not a valid Double number");
        }
        
        System.out.println("Please enter a valid string");
        while(scan.hasNext())  {
            s1 = s1.concat(scan.next()).concat(" ");
        }

        /* Print the sum of both integer variables on a new line. */
        System.out.println(i+i1);
        
        /* Print the sum of the double variables on a new line. */
		System.out.println(String.format("%.1f", d+d1));
        
        /* Concatenate and print the String variables on a new line; 
        	the 's' variable above should be printed first. */
        System.out.println(s.concat(s1));

        scan.close();
    }
}