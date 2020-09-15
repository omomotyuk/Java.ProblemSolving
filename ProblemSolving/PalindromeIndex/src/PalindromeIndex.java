
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PalindromeIndex {

    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {

        int r = -1;
        int l = s.length();
        int m = l-- / 2;

        int i = 0;
        while (i < m) {
            if (s.charAt(i) != s.charAt(l - i)) {
                if (r == -1) {
                    if (s.charAt(i) != s.charAt(l - i - 1)) {
                        r = i;
                        l++;
                    } else {
                        r = l - i;
                        l--;
                    }
                } else {
                    r = -1;
                    break;
                }
            }
            i++;
        }

        return r;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            System.out.println(result);

            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
