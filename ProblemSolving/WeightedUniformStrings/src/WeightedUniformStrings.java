
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class WeightedUniformStrings {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {

        List<Integer> weights = new ArrayList<Integer>();
        int[] numbers  = new int[26];

        int i = 0;
        char c = s.charAt(i++);
        int number = 1;
        //int weight = 1 + (int) (c - 'a');
        //int total = weight;

        while (i < s.length()) {
            /*if (!weights.contains(total)) {
                weights.add(total);
            }*/
            if (c == s.charAt(i)) {
                number++;
                //total += weight;
            } else {
                //System.out.println(c + " " + total + " " + weights.contains(total));
                if (numbers[c - 'a'] < number) {
                    numbers[c - 'a'] = number;
                }
                c = s.charAt(i);
                number = 1;
                //weight = 1 + (int) (c - 'a');
                //total = weight;
            }
            i++;
        }
        if (numbers[c - 'a'] < number) {
            numbers[c - 'a'] = number;
        }
        /*if (!weights.contains(total)) {
            weights.add(total);
        }*/
        //System.out.println(c + " " + total + " " + weights.contains(total));

        i = 0;
        while (i < 26) {
            int j = 1;
            while (j <= numbers[i]) {
                weights.add( j * (i + 1) );
                System.out.println( j * (i + 1) );
                j++;
            }
            i++;
        }

        int length = queries.length;

        String[] result = new String[length];

        i = 0;
        while (i < length) {
            if (weights.contains(queries[i])) {
                result[i] = "Yes";
            } else {
                result[i] = "No";
            }
            //System.out.println(i + " " + queries[i] + " " + weights.contains(queries[i]) + " " + result[i]);
            i++;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            //bufferedWriter.write(result[i]);
            System.out.println(result[i]);

            /*if (i != result.length - 1) {
                //bufferedWriter.write("\n");
            }*/
        }

        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
