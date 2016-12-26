import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Khiem on 10/28/2016.
 */
public class Primes {
    public static int[][] sieve5digit() {
        int[][] p = new int[8][10000];
        int[] q = new int[(int) Math.sqrt(100000)+1];
        q[0] = 1;
        q[1] = 1;
        for (int i = 2; i * i <= 100000; i++) {
            if (q[i] == 0) {
                for (int j = 2 * i*(10000/i); j < 100000; j += i) {
                    if (j >= 90000) {
                        p[8][j-90000] = 1;
                    }
                    else if (j>=80000)
                        p[7][j-80000] = 1;
                    else if (j>=70000)
                        p[6][j-70000] = 1;
                    else if (j>=60000)
                        p[5][j-60000] = 1;
                    else if (j>=50000)
                        p[4][j-50000] = 1;
                    else if (j>=40000)
                        p[3][j-40000] = 1;
                    else if (j>=30000)
                        p[2][j-30000] = 1;
                    else if (j>=20000)
                        p[1][j-20000] = 1;
                    else if (j>=10000)
                        p[0][j-10000] = 1;
                }
            }
        }
        return p;
    }
}
class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(File f) {
        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
}
