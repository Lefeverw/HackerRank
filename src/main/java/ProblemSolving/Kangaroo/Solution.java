package ProblemSolving.Kangaroo;

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

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        int jump=0;
        while(true){
            int firstKangaroo=x1+jump*v1;
            int secondKangaroo = x2 + jump*v2;
            System.out.println(firstKangaroo+" "+secondKangaroo);
            if(firstKangaroo==secondKangaroo)
                return "YES";
            if(v2>=v1 && secondKangaroo>firstKangaroo)
                return "NO";

            if(v1>=v2 && firstKangaroo>secondKangaroo)
                return "NO";
            jump++;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
