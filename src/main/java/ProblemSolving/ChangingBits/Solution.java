package ProblemSolving.ChangingBits;

/**
 * @author lefeverw
 */

//TODO: REDO

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'changeBits' function below.
     *
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     *  3. STRING_ARRAY queries
     */

    public static void changeBits(String a, String b, List<String> queries) {
        // Write your code here
        long start = System.currentTimeMillis();
        final String[] a_string = {a};
        final String[] b_string = {b};
//        System.out.println(a);
//        System.out.println(b);
        AtomicInteger leftover = new AtomicInteger();
        final ArrayList<Integer>[] c = new ArrayList[]{new ArrayList<>()};
        ArrayList<Integer>toOutput = new ArrayList<>();
        queries.stream().forEach(line -> {
            System.out.println("Time: "+(System.currentTimeMillis()-start)/1000.);
            String[] parts = line.split(" ");
            if (parts[0].equals("set_a")) {
                int position = Integer.parseInt(parts[1]);
                a_string[0] = a_string[0].substring(0, a_string[0].length() - 1 - position) + parts[2] + a_string[0].substring(a_string[0].length() - position);
            } else if (parts[0].equals("set_b")) {
                int position = Integer.parseInt(parts[1]);
                b_string[0] = b_string[0].substring(0, b_string[0].length() - 1 - position) + parts[2] + b_string[0].substring(b_string[0].length() - position);
            } else if (parts[0].equals("get_c")) {
                c[0] = new ArrayList<>();
                int position = Integer.parseInt(parts[1]);
                IntStream.range(0, position+1).forEach(index -> {

                    String b_bit;
                    if(b_string[0].length() - 1 - index>=0)
                        b_bit = b_string[0].substring(b_string[0].length() - 1 - index, b_string[0].length() - index);
                    else
                        b_bit="0";
                    String a_bit;
                    if(a_string[0].length() - 1 - index>=0)
                        a_bit= a_string[0].substring(a_string[0].length() - 1 - index, a_string[0].length() - index);
                    else
                        a_bit="0";
                    if (a_bit.equals("0") && b_bit.equals("0")){
                        c[0].add(0 + leftover.get());
                        leftover.set(0);
                    }
                    else if (a_bit.equals("1") && b_bit.equals("1")){
                        c[0].add(0+ leftover.get());
                        leftover.set(1);
                    } else{
                        if(leftover.get()==1){
                            c[0].add(0);
                        }else{
                            c[0].add(1);
                            leftover.set(0);
                        }
                    }

                });
                System.out.print(c[0].get(position));
            }
        });
//        System.out.println(a_string[0]);
//        System.out.println(b_string[0]);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int ab_size = Integer.parseInt(firstMultipleInput[0]);

        int queries_size = Integer.parseInt(firstMultipleInput[1]);

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        List<String> queries = IntStream.range(0, queries_size).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        Result.changeBits(a, b, queries);

        bufferedReader.close();
    }
}
