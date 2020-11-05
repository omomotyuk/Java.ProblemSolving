
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingSort1 {

    // Complete the countingSort function below.
    static int[] countingSort(int[] arr) {

        int[] result = new int[100];

        int i = 0;
        while (i < arr.length) {
            result[arr[i++]]++;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = countingSort(arr);

        for (int i = 0; i < result.length; i++) {
            //bufferedWriter.write(String.valueOf(result[i]));
            System.out.print(result[i]);

            if (i != result.length - 1) {
                //bufferedWriter.write(" ");
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }

        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
