/**
 * Created by Khiem on 11/9/2016.
 */
public class main2 {
    public static void main(String[] args){
        System.out.println(set(32));
    }

    static int set(int n) {
        int[] dp = new int[n];
        dp[0] = 2;
        dp[1] = 4;
        dp[2] = 6;
        dp[3] = 9;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
        }
        return dp[n-1];
    }
}
