
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
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int max = 0;

        if (k == 1) {
            max = 1;
        } else {
            int size = s.size();
            int[] numbers = new int[k];

            int i = 0;
            for (Integer n : s) {
                numbers[n.intValue() % k]++;
                i++;
            }

            if (k == 2) {
                if (numbers[0] > 0 && numbers[1] > 0) {
                    max = 2;
                } else {
                    max = 1;
                }
            } else {
                if (numbers[0] < 2) {
                    max = numbers[0];
                } else {
                    max++;
                }

                i = 1;
                while (i <= k / 2) {
                    max += Math.max(numbers[i], numbers[k - i]);
                    i++;
                }

                if (k % 2 == 0) {
                    if (numbers[k / 2] != 0) {
                        max++;
                    }
                }
            }
        }

        return max;
    }
}

public class NonDivisibleSubset {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
