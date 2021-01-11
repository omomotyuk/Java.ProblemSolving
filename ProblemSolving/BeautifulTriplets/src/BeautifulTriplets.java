
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BeautifulTriplets {

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {

        int l = arr.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int r = 0;

        while (i < l - 2) {
            System.out.println("i = " + i);
            j = i + 1;
            while (j < l - 1) {
                System.out.println("j = " + j);
                if (arr[j] - arr[i] == d) {
                    k = j + 1;
                    while (k < l) {
                        System.out.println("k = " + k);
                        if (arr[k] - arr[j] == d) {
                            r++;
                            System.out.println("r = " + r);
                            break;
                        } else {
                            k++;
                        }
                    }
                }
                j++;
            }
            i++;
        }

        return r;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        System.out.println(result);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
