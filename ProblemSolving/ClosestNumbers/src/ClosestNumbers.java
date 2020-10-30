
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ClosestNumbers {

    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] arr) {

        Arrays.sort(arr);

        int[] pairIndex = new int[arr.length * 2];

        int min = arr[1] - arr[0];
        int pairNumber = 1;
        int index = 0;
        pairIndex[index++] = 0;
        pairIndex[index++] = 1;

        int i = 2;
        while (i < arr.length) {

            int val = arr[i] - arr[i - 1];

            if (min > val) {
                min = val;
                pairNumber = 1;
                index = 0;
                pairIndex[index++] = i - 1;
                pairIndex[index++] = i;
            } else if (min == val) {
                pairNumber++;
                pairIndex[index++] = i - 1;
                pairIndex[index++] = i;
            }

            i++;
        }

        int[] result = new int[index];

        i = 0;
        while (i < index) {
            result[i] = arr[pairIndex[i++]];
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

        int[] result = closestNumbers(arr);

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
