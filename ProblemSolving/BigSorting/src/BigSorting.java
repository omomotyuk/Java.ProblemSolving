import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BigSorting {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {

        int[] index = new int[unsorted.length];

        int i = 0;
        while(i < index.length) {
            index[i] = i++;
        }

        i = 0;
        while (i < index.length - 1) {
            int j = i + 1;
            while(j < index.length) {
                if( unsorted[index[i]].length() == unsorted[index[j]].length()) {
                    if(unsorted[index[i]].compareTo(unsorted[index[j]]) > 0) {
                        int s = index[i];
                        index[i] = index[j];
                        index[j] = s;
                    }
                } else if (unsorted[index[i]].length() > unsorted[index[j]].length() ) {
                    int s = index[i];
                    index[i] = index[j];
                    index[j] = s;
                }
                j++;
            }
            i++;
        }

        String[] sorted = new String[unsorted.length];

        i = 0;
        while (i < unsorted.length) {
            sorted[i] = unsorted[index[i++]];
        }

        return sorted;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.nextLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            //bufferedWriter.write(result[i]);
            System.out.println(result[i]);

            if (i != result.length - 1) {
                //bufferedWriter.write("\n");
                //System.out.println("\n");
            }
        }

        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
