package ProblemSolving.BalancedBrackets;

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

    static Stack<Character> stack = new Stack<>();

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        if(s.length()==0 && stack.empty())
            return "YES";
        if(s.length()==0 && !stack.empty())
            return "NO";
        if (s.length() > 2 && (s.substring(0, 2).equals("{}") || s.substring(0, 2).equals("()") || s.substring(0, 2).equals("[]"))) {
            return isBalanced(s.substring(2));
        }
        char firstCharacter = s.charAt(0);
        if (doesMatch(firstCharacter, '{')) {
            stack.push('}');
            return isBalanced(s.substring(1));
        } else if (doesMatch(firstCharacter, '(')) {
            stack.push(')');
            return isBalanced(s.substring(1));
        } else if (doesMatch(firstCharacter, '[')) {
            stack.push(']');
            return isBalanced(s.substring(1));
        } else {
            if (stack.size() == 0)
                return "NO";
            if (doesMatch(firstCharacter, stack.peek())) {
                stack.pop();
                if (s.length() == 1)
                    return "YES";
                return isBalanced(s.substring(1));
            }
            return "NO";
        }
    }

    private static boolean doesMatch(char parts, char s) {
        return parts==s;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
