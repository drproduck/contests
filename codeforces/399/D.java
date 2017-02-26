import java.util.Scanner;

/**
 * Created by drproduck on 2/22/17.
 */
public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int q = in.nextInt();
        double[] dp = new double[k + 1];
        int[] res = new int[1001];
        int qq = 1;
        dp[0] = 1;
        for (int n = 1; qq <= 1000; n++) {  // n is number of day, qq is bound for query
            for (int i = k; i > 0; i--) {
                dp[i] = i / (double) k * dp[i] + (k - i + 1) / (double) k * dp[i - 1];
            }
            double a = (qq - Math.pow(10, -7))/2000;
            while (qq <= 1000 && dp[k] >= (qq - Math.pow(10, -7)) / 2000.0) {

                res[qq] = n;
                qq++;
            }
            dp[0] = 0;
        }
        while (q-- > 0) {
            System.out.println(res[in.nextInt()]);
        }
    }
}






