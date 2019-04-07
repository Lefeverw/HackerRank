package ProblemSolving.EqualStacks;

/**
 * @author lefeverw
 */
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */

        Stack<Integer>stack1=new Stack<>();
        IntStream.range(0,h1.length).map(index->h1.length-1-index).forEach(index->stack1.push(h1[index]));
        Stack<Integer>stack2=new Stack<>();
        IntStream.range(0,h2.length).map(index->h2.length-1-index).forEach(index->stack2.push(h2[index]));
        Stack<Integer>stack3=new Stack<>();
        IntStream.range(0,h3.length).map(index->h3.length-1-index).forEach(index->stack3.push(h3[index]));

        int firstSum=getSum(stack1);
        int secondSum=getSum(stack2);
        int thirdSum=getSum(stack3);
        while(firstSum != secondSum || secondSum != thirdSum){
            if(firstSum>=secondSum&&firstSum>=thirdSum){
                firstSum-=stack1.pop();
            }else if(secondSum>=firstSum&&secondSum>=thirdSum){
                secondSum-=stack2.pop();
            }else{
                thirdSum-=stack3.pop();
            }
        }
        return firstSum;

    }

    private static int getSum(Stack<Integer> stack1) {
        return stack1.stream().mapToInt(Integer::intValue).sum();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

