
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SuperReducedString {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {

        int[] n = new int[s.length()];
        int i = 0;
        while (i < n.length) {
            n[i++] = 1;
        }

        int left = 0;
        int right = 1;

        do {
            if (s.charAt(left) == s.charAt(right)) {
                n[left] = 0;
                n[right] = 0;

                if (left > 0) {
                    left = 0;
                }
            } else {
                left = right;
                right++;
            }

        } while (right < s.length());

        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
