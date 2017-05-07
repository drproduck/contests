import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by drproduck on 4/14/17.
 */
public class B {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc= in.nextInt();
        for (int i = 1; i <= nc; i++) {
            int N = in.nextInt();
            int P = in.nextInt();
            int[] serve = new int[N];
            for (int j = 0; j < N; j++) {
                serve[j] = in.nextInt();
            }
            int[][] dp = new int[N][P];
            int[] a = new int[P];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < P; k++) {
                    a[k] = in.nextInt();
                }
                Arrays.sort(a);
                for (int k = 0; k < P; k++) {
                    dp[j][k] = a[k];
                }
            }
            int res = 0;
            if (N == 1) {
                for (int j = 0; j < P; j++) {
                    int lo = (int) Math.ceil((double)dp[0][j]/serve[0]/1.1);
                    int hi = (int) Math.floor((double)dp[0][j]/serve[0] / 0.9);
                    if (hi >= lo) res++;
                }
            }
            if (N == 2) {
                int[][] d = new int[P+1][P+1];
                for (int j = 1; j < P + 1; j++) {
                    for (int k = 1; k < P + 1; k++) {
                        int x = d[j-1][k];
                        int y = d[j][k - 1];
                        int z;
                        int hi1 = (int) Math.floor((double)dp[0][j-1]/serve[0] /0.9);
                        int lo1 = (int) Math.ceil((double)dp[0][j-1]/serve[0] / 1.1);
                        int hi2 = (int) Math.floor((double)dp[1][k-1]/serve[1] / 0.9);
                        int lo2 = (int) Math.ceil((double)dp[1][k-1]/serve[1] / 1.1);
                        if (hi1 < lo2 || lo1 > hi2) {
                            z = d[j - 1][k - 1];
                        } else {
                            z = d[j-1][k-1] + 1;
                        }
                        d[j][k] = Integer.max(x, Integer.max(y, z));
                    }
                }
                res = d[P][P];
            }
            System.out.println("Case #"+i+": "+res);
        }
    }
}
