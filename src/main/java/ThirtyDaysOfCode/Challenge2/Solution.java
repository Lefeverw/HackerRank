package ThirtyDaysOfCode.Challenge2;

/**
 * @author lefeverw
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int second_integer = scan.nextInt();
        double second_double = scan.nextDouble();
        String second_string = scan.nextLine();
        second_string = scan.nextLine();
        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.

        /* Print the sum of both integer variables on a new line. */
        System.out.printf("%d\n",i+second_integer);
        /* Print the sum of the double variables on a new line. */
        System.out.printf("%f\n",d+second_double);
        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
        System.out.printf("%s %s\n",s,second_string);
        scan.close();
    }
}
