import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class HappyLadybugs {

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {

        //"ABCDEFGHIJKLMNOPQRSTUVWXYZ"

        int underscore = 0;
        int[] colors = new int[26];
        boolean happy = true;

        String board = "a" + b + "a";

        int i = 1;
        while (i < b.length() + 1) {
            if (board.charAt(i) == '_') {
                underscore++;
            } else {
                colors[board.charAt(i) - 'A']++;
            }
            if (board.charAt(i - 1) != board.charAt(i) && board.charAt(i) != board.charAt(i + 1)) {
                happy = false;
            }
            i++;
        }

        if (underscore == b.length()) {
            System.out.println("YES");
            return "YES";
        }

        if (underscore == 0) {
            if (happy) {
                System.out.println("YES");
                return "YES";
            } else {
                System.out.println("NO");
                return "NO";
            }
        }

        i = 0;
        while (i < 26) {
            if (colors[i] == 1) {
                System.out.println("NO");
                return "NO";
            }
            i++;
        }

        System.out.println("YES");
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
