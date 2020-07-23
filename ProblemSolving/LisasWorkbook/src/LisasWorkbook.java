
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
        int problem = 0;
        int special = 0;

        for (int i = 0; i < n; i++ ) {
            pageNumber++;

            System.out.println("i = " + i + " arr_i = " + arr[i] + " page = " + pageNumber);

            if ( pageNumber > arr[i] ) {
                if (arr[i] % k == 0) {
                    pageNumber += (arr[i] / k - 1);
                } else {
                    pageNumber += (arr[i] / k);
                }
            } else {
                problem = (pageNumber / k) * k + 1;
                pageNumber += pageNumber / k;

                while (pageNumber > problem && problem <= arr[i]) {
                    pageNumber++;
                    problem += k;
                }

                if (pageNumber - 1 == problem - 1) {
                    if (pageNumber - 1 != 0 ) {
                        special++;
                        System.out.println("page = " + (pageNumber - 1) + " problem = " + (problem - 1) + " special = " + special);
                    }
                }

                if (pageNumber < problem) {
                    special++;
                    pageNumber--;
                    System.out.println("page = " + pageNumber + " problem = " + problem + " special = " + special);
                } else {
                    while (pageNumber == problem && problem <= arr[i]) {
                        special++;
                        System.out.println("page = " + pageNumber + " problem = " + problem + " special = " + special);
                        pageNumber++;
                        problem += k;
                    }
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
