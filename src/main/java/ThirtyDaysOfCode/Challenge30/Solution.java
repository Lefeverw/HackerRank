package ThirtyDaysOfCode.Challenge30;

/**
 * @author lefeverw
 */
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        ArrayList<Integer> nValues = new ArrayList<>();
        ArrayList<Integer> kValues = new ArrayList<>();
        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);
nValues.add(n);
            int k = Integer.parseInt(nk[1]);
            kValues.add(k);
        }

        scanner.close();

        IntStream.range(0,nValues.size()).forEach(index->{
            int n = nValues.get(index);
            int k = kValues.get(index);
            AtomicInteger maxValue = new AtomicInteger();
            IntStream.rangeClosed(1,n).forEach(a->{
                IntStream.rangeClosed(a+1,n).forEach(b->{
                    int c = a & b;
                    if(c> maxValue.get() &&c<k){
                        maxValue.set(c);
                    }
                });
            });
            System.out.println(maxValue.get());
        });
    }
}
