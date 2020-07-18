
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here

        a.sort(Comparator.naturalOrder());
        b.sort(Comparator.naturalOrder());

        Integer[] A = (Integer[]) a.toArray(new Integer[a.size()]);
        Integer[] B = (Integer[]) b.toArray(new Integer[b.size()]);

        if ( A[A.length - 1] > B[0] ) {
            return 0;
        }

        int number = 0;

        for (int i = A[A.length - 1]; i <= B[0]; i++ ) {
            boolean check = true;

            for (int j = 0; j < A.length; j++) {
                if ( i % A[j] != 0 ) {
                    check = false;
                    break;
                }
            }

            if ( check ) {
                for (int j = 0; j < B.length; j++ ) {
                    if (B[j] % i != 0 ) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    number++;
                }
            }
        }

        System.out.println(number);

        return number;
    }

}

public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);

        //bufferedWriter.write(String.valueOf(total));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
