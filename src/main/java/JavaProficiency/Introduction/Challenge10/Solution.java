package JavaProficiency.Introduction.Challenge10;

/**
 * @author lefeverw
 */
import java.util.*;

public class Solution {
    static boolean flag;
    static int B;
    static int H;
    static {
        final Scanner scanner = new Scanner(System.in);
        B = scanner.nextInt();
        H = scanner.nextInt();
        flag= false;
        if(B<=0 ||H<=0)
                System.out.println("java.lang.Exception: Breadth and height must be positive");

        else
            flag = true;
    }

    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main

}//end of class