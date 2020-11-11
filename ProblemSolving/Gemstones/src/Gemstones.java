
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Gemstones {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        
        int[] gemstone = new int[26];

        int i;
        for ( String stone : arr ) {
            i = 0;
            int[] check = new int[26];
            while (i < stone.length()) {
                int index = (int)(stone.charAt(i++) - 'a');
                if(check[index] == 0) {
                    gemstone[index]++;
                }
                check[index]++;
            }
        }

        int result = 0;
        i = 0;
        while(i < gemstone.length) {
            if(gemstone[i++] == arr.length) {
                result++;
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        System.out.println(result);

        scanner.close();
    }
}
