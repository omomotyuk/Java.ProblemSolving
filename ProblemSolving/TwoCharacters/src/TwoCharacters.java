
import java.io.*;
import java.math.*;
import java.security.*;
import java.sql.Array;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TwoCharacters {

    // Complete the alternate function below.
    static int alternate(String s) {

        int [] numbers = new int[26];

        int i = 0;
        while(i < s.length()) {

            char c = s.charAt(i++);

            if(c <= 'Z') {
                numbers[c - 'A']++;
            } else {
                numbers[c - 'a']++;
            }
        }

        Arrays.sort(numbers);

        int result = 0;

        i = 2;
        while(i > 0) {
            if(numbers[26 - i] != 0) {
                result += numbers[26 - i--];
            } else {
                return 0;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);
        System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
