import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by drproduck on 4/14/17.
 */
public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = in.nextInt();
        for (int i = 1; i <= nc; i++) {
            int R = in.nextInt();
            int C = in.nextInt();
            char[][] dp = new char[R][C];
            for (int j = 0; j < R; j++) {
                String line = in.next();
                for (int k = 0; k < C; k++) {
                    dp[j][k] = line.charAt(k);
                }
            }
            for (int j = 0; j < R; j++) {
                int x = 0;
                while (x < C && dp[j][x] == '?') {
                    x++;
                }
                if (x < C) {
                    char temp = dp[j][x];
                    for (int k = 0; k < C; k++) {
                        if (dp[j][k] == '?') {
                            dp[j][k] = temp;
                        } else {
                            temp = dp[j][k];
                        }
                    }
                }
            }
            for (int j = 0; j < C; j++) {
                int x = 0;
                while (x < R && dp[x][j] == '?') {
                    x ++;
                }
                if (x < R) {
                    char temp = dp[x][j];
                    for (int k = 0; k < R; k++) {
                        if (dp[k][j] == '?') {
                            dp[k][j] = temp;
                        } else {
                            temp = dp[k][j];
                        }
                    }
                }
            }
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    s.append(dp[j][k]);
                }
                if (j < R - 1) {
                    s.append("\n");
                }
            }
            System.out.println("Case #"+i+":"+"\n"+s.toString());
        }
    }
}

