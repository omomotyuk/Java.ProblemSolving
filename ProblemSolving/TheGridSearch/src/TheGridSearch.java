import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class TheGridSearch {

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {

        boolean check = false;
        int pLength = P[0].length();

        int i = 0;
        while ( i < G.length - P.length ) {
            int index = G[i].indexOf(P[0]);
            if ( index != -1 ) {
                int j = 1;
                while (j < P.length) {
                    if ( P[j].equals(G[i + j].substring(index, index + pLength)) == false ) {
                        break;
                    }
                    j++;
                }
                if (j == P.length) {
                    check = true;
                    break;
                }
            }
            i++;
        }

        String output = check == true ? "YES" : "NO";

        System.out.println(output);

        return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
