import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BeautifulDays {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {

        int beautiful = 0;

        for (int number = i; number < j + 1; number++) {

            String string = new StringBuffer("" + number).reverse().toString();

            int reverse = Integer.parseInt(string);

            //System.out.println("" + number + " " + reverse);

            if (Math.abs(number - reverse) % k == 0) {
                beautiful++;
            }
        }

        System.out.println(beautiful);

        return beautiful;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
