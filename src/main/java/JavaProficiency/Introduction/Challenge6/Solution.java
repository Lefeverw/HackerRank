package JavaProficiency.Introduction.Challenge6;

/**
 * @author lefeverw
 */
import java.util.*;
import java.util.stream.IntStream;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        IntStream.rangeClosed(1,10).forEach(number-> System.out.printf("%d x %d = %d\n",N,number,N*number));
        scanner.close();
    }
}
