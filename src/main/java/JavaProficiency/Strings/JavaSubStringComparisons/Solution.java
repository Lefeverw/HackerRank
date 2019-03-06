package JavaProficiency.Strings.JavaSubStringComparisons;

/**
 * @author lefeverw
 */
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        final String[] smallest = {s.substring(0, k)};
        final String[] largest = {s.substring(0, k)};

        // Complete the functionw
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        int bound = s.length() - k + 1;
        for (int index = 1; index < bound; index++) {
            String substring = s.substring(index, index + k);
            if (substring.compareTo(smallest[0]) < 0)
                smallest[0] = substring;
            if (substring.compareTo(largest[0]) > 0)
                largest[0] = substring;
        }

        return smallest[0] + "\n" + largest[0];
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
