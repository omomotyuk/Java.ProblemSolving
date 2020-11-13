
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GameOfThronesI {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {

        int[] pairs = new int[26];

        int i = 0;
        while (i < s.length()) {
            pairs[s.charAt(i++) - 'a']++;
        }

        int odd = 0;

        i = 0;
        while (i < 26) {
            odd += pairs[i++] % 2;
        }

        if (s.length() % 2 != odd) {
            return "NO";
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        System.out.println(result);

        /*bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
