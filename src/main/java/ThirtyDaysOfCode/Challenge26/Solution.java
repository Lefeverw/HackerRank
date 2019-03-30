package ThirtyDaysOfCode.Challenge26;

/**
 * @author lefeverw
 */

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        IntStream.range(0, N).forEach(number -> {
            int possiblePrime = sc.nextInt();
            System.out.println(isPrime(possiblePrime) ? "Prime" : "Not prime");
        });
        sc.close();
    }

    private static boolean isPrime(int possiblePrime) {
        if(possiblePrime==1)
            return false;
        if (possiblePrime == 2)
            return true;
        else
            return IntStream.range(2, (int) (Math.sqrt(possiblePrime) + 1)).filter(number -> possiblePrime % number == 0).count() < 1;
    }
}