
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MarsExploration {

    // Complete the marsExploration function below.
    static int marsExploration(String s) {

        int changed = 0;

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i++) != 'S') {
                changed++;
            }
            if (s.charAt(i++) != 'O') {
                changed++;
            }
            if (s.charAt(i++) != 'S') {
                changed++;
            }
        }

        return changed;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        System.out.println(result);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
