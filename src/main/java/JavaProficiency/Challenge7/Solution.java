package JavaProficiency.Challenge7;

/**
 * @author lefeverw
 */
import java.util.*;
import java.util.stream.IntStream;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            IntStream.rangeClosed(0,n-1).forEach(value->{
                System.out.printf("%d ",IntStream.rangeClosed(0,value).map(exp->(int)Math.pow(2,exp)).sum()*b+a);
            });
            System.out.println();
        }

        in.close();
    }
}

