package JavaProficiency.Strings.JavaAnagrams;

/**
 * @author lefeverw
 */
import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        String[] lettersOfA = a.toLowerCase().split("");
        String[] lettersOfB = b.toLowerCase().split("");
        int counter = 0;
        for (int i = 0; i < lettersOfA.length; i++) {
            for (int j = 0; j < lettersOfB.length; j++) {
                if(lettersOfB[j].equals(lettersOfA[i])){
                    lettersOfB[j]="";
                    lettersOfA[i]="";
                    counter++;
                    break;
                }
            }
        }
        return counter==a.length()&&counter==b.length();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
