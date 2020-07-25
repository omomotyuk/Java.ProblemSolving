
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LisasWorkbook {

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {

        int pageNumber = 0;
        int special = 0;

        for (int i = 0; i < n; i++ ) {

            int j = 1;
            int l = (arr[i]/k)*k;

            while ( j <= l ) {
                pageNumber++;
                j+=k;
                if ( j - k <= pageNumber && pageNumber < j ) {
                    special++;
                }
            }

            l = arr[i] % k;

            if ( l != 0) {
                pageNumber++;
                if ( j <= pageNumber && pageNumber < j + l ) {
                    special++;
                }
            }
        }

        System.out.println(special);

        return special;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
