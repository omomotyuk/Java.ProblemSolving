
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class FillingJars {

    // Complete the solve function below.
    static int solve(int n, int[][] operations) {

        long total = 0;
        int i = 0;
        while (i < operations.length) {
            total += (operations[i][1] - operations[i][0] + 1) * operations[i++][2];
        }

        return (int)(total / n);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] operations = new int[m][3];

        for (int operationsRowItr = 0; operationsRowItr < m; operationsRowItr++) {
            String[] operationsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int operationsColumnItr = 0; operationsColumnItr < 3; operationsColumnItr++) {
                int operationsItem = Integer.parseInt(operationsRowItems[operationsColumnItr]);
                operations[operationsRowItr][operationsColumnItr] = operationsItem;
            }
        }

        int result = solve(n, operations);

        System.out.println(result);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
