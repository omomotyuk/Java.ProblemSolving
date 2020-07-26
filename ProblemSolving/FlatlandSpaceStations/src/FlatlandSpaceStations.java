import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FlatlandSpaceStations {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {

        Arrays.sort(c);

        //System.out.println("" + Arrays.toString(c));

        int max = 0;
        int left = 0;
        int right = 0;
        int next = 0;
        int output = 0;

        max = c[0]; // c[0] - 0
        left = 0;
        right = c[0];

        int i = 1;
        while(i < c.length) {
            next = c[i] - c[i -1];
            if (max < next) {
                max = next;
                left = c[i - 1];
                right = c[i];
            }
            i++;
        }

        next = n - 1 - c[c.length - 1];
        if (max < next) {
            max = next;
            left = c[c.length - 1];
            right = n - 1;
        }

        //System.out.println(max + " " + left + " " + right);

        if (left == 0 && c[0] != 0) {
            output = max;
        } else if (right == n - 1 && c[c.length - 1] != n - 1) {
            output = max;
        } else if (c[0] != 0 && c[0] > max / 2) { // c[0] - 0
            output = c[0]; // c[0] - 0
        } else if (c[c.length - 1] != n - 1 && n - 1 - c[c.length - 1] > max /2) {
            output = n - 1 - c[c.length - 1];
        } else if (n == c.length) {
            max = 0;
        }
        else {
            output = max / 2;
        }

        System.out.println(output);

        return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
