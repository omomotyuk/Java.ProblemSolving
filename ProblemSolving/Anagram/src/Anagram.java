
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Anagram {

    // Complete the anagram function below.
    static int anagram(String s) {

        if ( s.length() % 2 == 1 ) {
            return -1;
        } else {
            int[] left = new int[26];
            int[] right = new int[26];

            int i = 0;
            while ( i < s.length() / 2) {
                left[s.charAt(i++) - 'a']++;
            }

            while ( i < s.length() ){
                right[s.charAt(i++) - 'a']++;
            }

            int changes = 0;

            i = 0;
            while (i < 26) {
                changes += Math.abs(left[i] - right[i]);
                i++;
            }

            return changes / 2;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            System.out.println(result);

            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
