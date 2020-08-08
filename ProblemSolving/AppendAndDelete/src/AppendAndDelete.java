
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AppendAndDelete {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {

        int sLength = s.length();
        int tLength = t.length();

        int l = sLength < tLength ? sLength : tLength;

        int i = 0;
        while (i < l && s.charAt(i) == t.charAt(i)) {
            i++;
        }

        sLength -= i;
        tLength -= i;

        l = sLength + tLength;

        if (l == k) {
            return "Yes";
        } else if (l < k) {
            if (i == 0) {
                return "Yes";
            } else if ((k - l) % 2 == 0) {
                return "Yes";
            } else if (i <= (k - l) / 2) {
                return "Yes";
            }
        }

        return "No";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        System.out.println(result);

        /*bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
