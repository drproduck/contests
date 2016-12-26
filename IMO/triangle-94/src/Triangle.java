import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Khiem on 10/27/2016.
 */
public class Triangle {
    public static BufferedReader br = (new BufferedReader(new InputStreamReader(System.in)));

    private static int left(int x) {
        double y = 2*x;
        return x+(int) Math.ceil(Math.sqrt(y + Math.sqrt(y))) - 1;
    }

    private static  int right(int x) {
        double y = 2*x;
        return x+(int)Math.ceil(Math.sqrt(y + Math.sqrt(y)));
    }
    

    private static int length(int r) {
        return r * (r + 1) / 2;
    }

    public static void main(String[] args) throws IOException{
        long start = System.nanoTime();
        FastScanner in = new FastScanner(new File("C:\\Users\\Khiem\\Projects\\IMO\\triangle-94\\src\\input-6.txt"));
        PrintWriter out = new PrintWriter("C:\\Users\\Khiem\\Projects\\IMO\\triangle-94\\src\\output-6.txt");
        int r = in.nextInt();
        int[] dp = new int[r];
        int c;
        int d;
        dp[0] = in.nextInt();
        for (int i = 2; i <= r; i++) {
            c = dp[0]+in.nextInt();
            for (int j = 1; j < i-1; j++) {
                d = in.nextInt() + (dp[j - 1] < dp[j] ? dp[j] : dp[j - 1]);
                dp[j-1] = c;
                c = d;
            }
            dp[i-1] = dp[i-2]+in.nextInt();
            dp[i-2] = c;
        }
        int max = dp[0];
        for (int i = 1;i<r;i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        out.println(max);
        long stop = System.nanoTime();
        out.println(stop - start);
        out.close();

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
