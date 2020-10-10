import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class IceCreamParlor {

    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] arr) {

        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        int max = copy[arr.length - 1];

        int[] ind = new int[max + 1];

        int i = 0;
        while (i < arr.length) {
            ind[arr[i]] = i;
            i++;
        }

        i = 0;
        while (i < arr.length) {
            if( ind[m - arr[i]] != 0) {
                int[] ret = new int[]{ i + 1, ind[m - arr[i]] + 1};
                Arrays.sort( ret );
                return( ret );
            }
            i++;
        }

        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = icecreamParlor(m, arr);

            System.out.println(Arrays.toString(result));

            /* for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine(); */
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
