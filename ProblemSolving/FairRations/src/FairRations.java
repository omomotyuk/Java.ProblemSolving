import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FairRations {

    // Complete the fairRations function below.
    static int fairRations(int[] B) {

        int loaves = 0;
        int steps = 0;

        int i = 0;
        while (i < B.length) {
            if (B[i] % 2 == 0) {
                if (steps != 0) {
                    steps++;
                }
            } else {
                if (steps != 0) {
                    loaves+=steps;
                    steps = 0;
                } else {
                    steps++;
                }
            }
            i++;
        }

        loaves*=2;

        if (steps != 0) {
            System.out.println("NO");
            return -1;
        }

        System.out.println(loaves);

        return loaves;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);

        if (result == -1) {
            //bufferedWriter.write("NO");
        } else {
            //bufferedWriter.write(String.valueOf(result));
        }

        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
