package ProblemSolving.Staircase;

/**
 * @author lefeverw
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.IntStream;

public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
        IntStream.range(0,n).forEach(line->{
            IntStream.range(0,n-line-1).forEach(index-> System.out.print(" "));
            IntStream.rangeClosed(0,line).forEach(index-> System.out.print("#"));
            System.out.println();
        });

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}