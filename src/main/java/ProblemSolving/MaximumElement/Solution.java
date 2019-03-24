package ProblemSolving.MaximumElement;

/**
 * @author lefeverw
 */
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {
static ArrayList<Integer> stack = new ArrayList<>();
static int max=0;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int N =scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        IntStream.range(0,N).forEach(index->{
            String[] query = scan.nextLine().split(" ");
            scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            switch (query[0]){
                case "1":
                    if(Integer.parseInt(query[1])>max)
                        max=Integer.parseInt(query[1]);
                    stack.add(Integer.parseInt(query[1]));
                    break;
                case "2":
                    Integer potMax = stack.remove(stack.size() - 1);
                    if(potMax == max)
                        max = stack.stream().mapToInt(x -> x).max().orElse(0);
                    break;
                case "3":
                    System.out.println(max);
                    break;
            }
        });
    }
}

