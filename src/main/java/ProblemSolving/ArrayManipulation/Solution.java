package ProblemSolving.ArrayManipulation;

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

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] result = new long[n];
        Arrays.stream(queries).parallel().forEach(query -> {
            int a = query[0];
            int b = query[1];
            int k = query[2];
//            if (k > 0)
//                IntStream.rangeClosed(a - 1, b - 1).forEach(index -> result[index] += k);
            result[a - 1] += k;
            if (b < n)
                result[b] -= k;
        });
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            sum += result[i];
            max = Math.max(max, sum);
        }
        return max;
//        return Arrays.stream(result).max().getAsLong();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
