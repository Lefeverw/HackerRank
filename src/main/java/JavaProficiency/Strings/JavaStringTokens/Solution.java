package JavaProficiency.Strings.JavaStringTokens;

/**
 * @author lefeverw
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        if(s.trim().replaceAll(" +", "").equals("")){
            System.out.println(0);
            return;
        }
        String[] parts = s.trim().replaceAll(" +", " ")
                .replaceAll("!+", " ")
                .replaceAll(",+", " ")
                .replaceAll("\\?+", " ")
                .replaceAll("\\.+", " ")
                .replaceAll("@+", " ")
                .replaceAll("_+", " ")
                .replaceAll("'+", " ")
                .replace(", ", ",")
                .replace("! ", ",")
                .replace("  ", ",")
                .replace("   ", ",")
                .replace("    ", ",")
                .replace("\\? ", ",")
                .replace("\\. ", ",")
                .replace("@ ", ",")
                .replace("_ ", ",")
                .split(" |!|,|\\.|_|'|@|\\?");
        System.out.println(parts.length);
        Arrays.stream(parts).forEach(System.out::println);
        scan.close();
    }
}