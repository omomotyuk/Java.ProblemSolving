import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumDistances {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {

        int l = a.length;
/*
        int d[][] = new int[l][l];

        List<Integer> values = new ArrayList<Integer>();

        int index;
        int j;
        int dis;

        int i = 0;
        while (i < l) {
            if (!values.contains(a[i])) {
                values.add(a[i]);
            } else {
                index = values.indexOf(a[i]);
                d[index][0]++;
                d[index][d[index][0]] = i++;
            }
        }

        int min = l;

        i = 0;
        while (i < l) {
            if (d[i][0] > 1) {
                j = 1;
                while (j < d[i][0]) {
                    dis = d[i][j + 1] - d[i][j++];
                    if (min > dis) {
                        min = dis;
                        if(min == 1) {
                            return 1;
                        }
                    }
                }
            }
            i++;
        }

        if (min == l) {
            return -1;
        }
*/
        int pos[][] = new int[l][2];

        int i = 0;
        while(i < l) {
            pos[i][0] = a[i];
            pos[i][1] = i++;
        }

        Arrays.sort(pos, (av, ai) -> av[0] - ai[0]);

        int min = l;

        i = 1;
        while(i < l) {
            if( pos[i - 1][0] == pos[i][0]) {
                int val = pos[i][1] - pos[i -1][1];
                if (min > val) {
                    min = val;
                    if (min == 1) {
                        return 1;
                    }
                }
            }
            i++;
        }

        if (min == l) {
            return -1;
        }

        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        System.out.println(result);
/*
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
*/
        scanner.close();
    }
}
