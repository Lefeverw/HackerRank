package JavaProficiency.Strings.JavaStringReverse;

/**
 * @author lefeverw
 */
import java.io.*;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(IntStream.rangeClosed(0, A.length() / 2).allMatch(checkLetter(A))?"Yes":"No");
    }

    private static IntPredicate checkLetter(String a) {
            return value->a.substring(value,value+1).equals(a.substring(a.length()-1-value,a.length()-value));

    }


}

