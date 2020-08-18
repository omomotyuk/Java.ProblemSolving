import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CaesarCipher {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {

        String output = "";

        k = k % 26;

        char c;
        int i = 0;
        while (i < s.length()) {
            c = s.charAt(i);
            if ( 'a' <= c && c <= 'z') {
                output += (char) ('a' + (c - 'a' + k) % 26);
            } else if ('A' <= c && c <= 'Z') {
                output += (char) ('A' + (c - 'A' + k) % 26);
            } else {
                output += c;
            }
            i++;
        }

        return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        System.out.println(result);

        /*bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
