package ProblemSolving.TimeConversion;

/**
 * @author lefeverw
 */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String amOrPM = s.substring(s.length() - 2);
        String timeWihtoutAMOrPM = s.substring(0, s.length() - 2);
        if(amOrPM.equals("PM") && s.substring(0, 2).equals("12"))
            return timeWihtoutAMOrPM;

        else {
            String minutesAndSeconds = s.substring(2, s.length() - 2);
            if (amOrPM.equals("AM")&&s.substring(0, 2).equals("12"))
                return "00" + minutesAndSeconds;
            else if (amOrPM.equals("AM"))
                return timeWihtoutAMOrPM;
            else
                return (Integer.parseInt(s.substring(0, 2)) + 12) + minutesAndSeconds;
        }

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
