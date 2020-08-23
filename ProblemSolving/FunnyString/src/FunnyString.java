
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FunnyString {

    // Complete the funnyString function below.
    static String funnyString(String s) {

        int i = 0;
        int j = s.length() - 1;
        int l = s.length() / 2 + 1;
        int next;
        int revs;

        while (i < l) {
            next = (int) (s.charAt(i + 1) - s.charAt(i++));
            revs = (int) (s.charAt(j - 1) - s.charAt(j--));

            if ( Math.abs(next) != Math.abs(revs) ) {
                break;
            }
        }

        if (i == l) {
            return "Funny";
        } else {
            return "Not Funny";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            System.out.println(result);

            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
