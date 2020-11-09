
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Quicksort1Partition {

    // Complete the quickSort function below.
    static int[] quickSort(int[] arr) {

        int[] result = new int[arr.length];

        int l = 0;
        int r = arr.length - 1;

        int i = 1;
        while (i < arr.length) {
            if( arr[i] < arr[0] ) {
                result[l++] = arr[i];
            } else if (arr[i] > arr[0]) {
                result[r--] = arr[i];
            }
            i++;
        }

        r++;

        while (l < r) {
            result[l++] = arr[0];
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

        int[] result = quickSort(arr);

        for (int i = 0; i < result.length; i++) {
            //bufferedWriter.write(String.valueOf(result[i]));
            System.out.print(result[i]);

            if (i != result.length - 1) {
                //bufferedWriter.write(" ");
                System.out.print(" ");
            }
        }

        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}