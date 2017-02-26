import java.util.IntSummaryStatistics;
import java.util.Scanner;

/**
 * Created by drproduck on 2/25/17.
 */
public class D2 {
    static long[] dp = new long[100];{

    }
    static String k;
    static int n;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.next();
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        recurse(0, 0, k.length() - 1);
        System.out.println(dp[k.length()-1]);
    }

    static long recurse(int radix, int from, int to) {
        if (to < from) {
            return 0;
        }
        if (dp[to] != -1) {
            return dp[to];
        }
        else {
            int curr = 0;
            int c = k.charAt(to)-48;
            int r = 0;
            long mn = Integer.MAX_VALUE;
            int _to = to;
            while (_to>=0&&curr + c * pow(10, r) < n) {
                _to--;
                curr += c * pow(10, r);
                mn = Math.min(mn, recurse(radix+1, from, _to)+curr*pow(n, radix));
                r++;
                if (_to >= 0) {
                    c = k.charAt(_to) - 48;
                }
            }
            dp[to] = mn;
            return mn;
        }
    }

    static int pow(int n,int p) {
        int res = 1;
        while (p > 0) {
            res *= n;
            p--;
        }
        return res;
    }
}
