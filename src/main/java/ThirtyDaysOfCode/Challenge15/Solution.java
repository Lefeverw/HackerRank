package ThirtyDaysOfCode.Challenge15;

/**
 * @author lefeverw
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
    private int[] elements;
    public int maximumDifference;

    public Difference(int[] a) {
        this.elements=a;
    }

    public void computeDifference() {
        Arrays.stream(elements).forEach(element->{
            Arrays.stream(elements).forEach(element2->{
                if(Math.abs(element-element2)>maximumDifference)
                    maximumDifference=Math.abs(element-element2);
            });
        });
    }

    // Add your code here

} // End of Difference class

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}