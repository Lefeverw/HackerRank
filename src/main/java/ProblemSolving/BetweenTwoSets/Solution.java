package ProblemSolving.BetweenTwoSets;

/**
 * @author lefeverw
 */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.regex.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */
        List<Integer> firstList = IntStream.rangeClosed(1, b[0]).filter(numberCanBeDevidedByDevisors(a)).boxed().collect(Collectors.toList());
        List<Integer> secondList = IntStream.rangeClosed(1, b[0]).filter(numberIsDevisorOf(b)).boxed().collect(Collectors.toList());
        return (int)  firstList.stream().filter(element->secondList.contains(element)).count();
    }

    private static IntPredicate numberIsDevisorOf(int[] b) {
        return value->Arrays.stream(b).allMatch(ElementOfB-> ElementOfB%value==0);
    }

    private static IntPredicate numberCanBeDevidedByDevisors(int[] a) {
        return value -> Arrays.stream(a).allMatch(ElementOfA -> value % ElementOfA == 0);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}
