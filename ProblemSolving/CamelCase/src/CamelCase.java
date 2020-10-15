
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CamelCase {

    // Complete the camelcase function below.
    static int camelcase(String s) {

        int numberOfWords = 0;

        if (s.length() != 0) {

            numberOfWords++;

            int i = 0;
            while (i < s.length()) {
                if( 'A' <= s.charAt(i) && s.charAt(i++) <= 'Z') {
                    numberOfWords++;
                }
            }
        }

        return numberOfWords;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = camelcase(s);

        System.out.println(result);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
