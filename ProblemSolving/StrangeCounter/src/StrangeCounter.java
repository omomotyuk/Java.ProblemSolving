import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class StrangeCounter {

    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {

        long n = (long)(Math.log(t / 3 + 1) / Math.log(2));

        long s = 3 * (long)(Math.pow(2,n) - 1);
        //int sn = 3 * (int)(Math.pow(2,n + 1) - 1);

        //System.out.println("t = " + t + "; n = " + n + "; s = " + s + "; sn = " + sn);

        long next = (long) Math.pow(2,n) * 3;

        long output = 0;

        if ( t == s ) {
            output = 1;
        } else {
            output = s + next + 1 - t;
        }

        System.out.println(output);

        return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
