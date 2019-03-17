package ThirtyDaysOfCode.Challenge12;

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

    // Complete the hourglassSum function below.
    static void hourglassSum(int[][] arr) {
        final int[] maxHourGlassSum = {Integer.MIN_VALUE};
        IntStream.range(1,arr.length-1).forEach(
                x->{IntStream.range(1,arr.length-1).forEach(
                        y->{
                            int hourGlassSum = arr[x-1][y-1]+arr[x-1][y]+arr[x-1][y+1]+arr[x][y]+arr[x+1][y-1]+arr[x+1][y]+arr[x+1][y+1];
                            if(hourGlassSum> maxHourGlassSum[0])
                                maxHourGlassSum[0] =hourGlassSum;
                        }
                );}
        );
        System.out.println(maxHourGlassSum[0]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        hourglassSum(arr);
        scanner.close();
    }
}

