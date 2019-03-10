package ProblemSolving.DynamicArray;

/**
 * @author lefeverw
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        ArrayList<Integer> lastAnswers = new ArrayList<>();
        ArrayList<ArrayList<Integer>> sequences = new ArrayList<>();
        final int[] lastAnswer = {0};
        IntStream.range(0, n).forEach(number -> sequences.add(new ArrayList<>()));
        queries.stream().forEach(query -> {
            if (query.get(0) == 1) {
                //DO first query
                int sequenceIndex = (query.get(1) ^ lastAnswer[0]) % n;
                sequences.get(sequenceIndex).add(query.get(2));
            } else {
                //Do second query
                int sequenceIndex = (query.get(1) ^ lastAnswer[0]) % n;
                lastAnswer[0] = sequences.get(sequenceIndex).get(query.get(2) % sequences.get(sequenceIndex).size());
                System.out.println(lastAnswer[0]);
                lastAnswers.add(lastAnswer[0]);
            }
        });
        return lastAnswers;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
