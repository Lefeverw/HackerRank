package JavaProficiency.Introduction.Challenge9;

/**
 * @author lefeverw
 */
import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int counter=0;
        while (scanner.hasNext()){
            counter++;
            String s = scanner.nextLine();
            System.out.printf("%s %s\n",counter,s);
        }

    }
}
