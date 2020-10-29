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

        int l = unsorted.length;
        int[] index = new int[l];

        int i = 0;
        while(i < l) {
            index[i] = i++;
        }

        int s;
        int il;
        int jl;
        i = 0;
        while (i < l - 1) {
            int j = i + 1;
            while(j < l) {
                il = unsorted[index[i]].length();
                jl = unsorted[index[j]].length();
                if( il == jl ) {
                    if(unsorted[index[i]].compareTo(unsorted[index[j]]) > 0) {
                        s = index[i];
                        index[i] = index[j];
                        index[j] = s;
                    }
                } else if (il > jl ) {
                    s = index[i];
                    index[i] = index[j];
                    index[j] = s;
                }
                j++;
            }
            i++;
        }

        String[] sorted = new String[l];

        i = 0;
        while (i < l) {
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
