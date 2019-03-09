package ThirtyDaysOfCode.Challenge6;

/**
 * @author lefeverw
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.IntPredicate;
import java.util.regex.*;
import java.util.stream.IntStream;

public class Solution {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        IntStream.range(0, n).forEach(lineNumber -> {
            String s = scanner.nextLine();
            IntStream.range(0, s.length())
                    .filter(isEven())
                    .forEach(number -> System.out.print(s.charAt(number)));
            System.out.print(" ");
            IntStream.range(0, s.length())
                    .filter(isOdd())
                    .forEach(number -> System.out.print(s.charAt(number)));
            System.out.println();
        });

        scanner.close();
    }

    private static IntPredicate isOdd() {
        return value -> value % 2 != 0;
    }

    private static IntPredicate isEven() {
        return value -> value % 2 == 0;
    }
}
