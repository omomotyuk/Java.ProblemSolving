
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pangrams {

    // Complete the pangrams function below.
    static String pangrams(String s) {

        String l = s.toLowerCase();

        int i = (int) 'a';

        while (i <= 'z') {
            if (l.indexOf(i++) == -1) {
                break;
            }
        }

        if( 'z' < i ) {
            return "pangram";
        } else {
            return "not pangram";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        System.out.println(result);

        /*bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
