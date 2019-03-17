package ProblemSolving.BreakingTheRecords;

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

public class Solution {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        final int[] minimum = {scores[0]};
        final int[] maximum = {scores[0]};
        int minimumBreak =(int) Arrays.stream(scores).filter(score -> {
            if (score < minimum[0]) {
                minimum[0] = score;
                return true;
            }
            return false;
        }).count();
        int maximumBreak =(int) Arrays.stream(scores).filter(score -> {
            if (score > maximum[0]) {
                maximum[0] = score;
                return true;
            }
            return false;
        }).count();
return new int[]{maximumBreak,minimumBreak};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
