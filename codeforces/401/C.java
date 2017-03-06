    import java.io.*;
    import java.util.Scanner;
    import java.util.StringTokenizer;

    /**
     * Created by drproduck on 3/4/17.
     */
    public class C {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            StringBuilder s = new StringBuilder(200000);
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = in.nextInt()-1;
                }
            }
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = i;
            }
            for (int i = 0; i < m; i++) {
                    int start = 0;
                    int end = 0;
                    while (start < n) {
                        while (end + 1 < n && a[end + 1][i] >= a[end][i]) {
                            end++;
                        }
                        dp[start] = (dp[start] >= end) ? dp[start] : end;
                        end++;
                        start = end;
                        }
                }

                int dpmax = dp[0];
                for (int i = 1; i < n; i++) {
                    if (dpmax > dp[i]) {
                        dp[i] = dpmax;
                    } else {
                        dpmax = dp[i];
                    }
                }
                int q = in.nextInt();
            for (int i = 0; i < q; i++) {
                int x = in.nextInt()-1;
                int y = in.nextInt()-1;
                if (dp[x] >= y) {
                    s.append("Yes\n");
                } else s.append("No\n");
            }
            System.out.println(s.toString());
        }
    }

