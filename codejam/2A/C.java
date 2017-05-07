import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by drproduck on 5/6/17.
 */
public class C {
    public static boolean[][] a;

    public static void main(String[] args) {
        a = new boolean[110][110];
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = in.nextInt();
        for (int ii = 1; ii <= nc; ii++) {
            int r = in.nextInt();
            int c = in.nextInt();
            int k = in.nextInt();
            System.out.printf("Case #%d: ", ii);
            for (int i = 0; i < r; i++) {
                String s = in.next();
                for (int j = 0; j < c; j++) {
                    if (s.charAt(j) == '#') {
                        a[i][j] = true;
                    } else a[i][j] = false;
                }
            }
            int res = solve(r, c, k);
            System.out.printf("%d\n", res);
        }
    }

    public static int solve(int r, int c, int k) {
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a[i][j]) {
                    int h = 1;
                    int le = j;
                    int ri = j;
                    int nu = 1;

                    while (true) {
                        if (i+h >= r) break;
                        le -= 1;
                        ri += 1;
                        if (le <0 || ri >= c) break;
                        boolean ok = true;
                        for (int l = le; l <= ri; l++) {
                            if (!a[i + h][l]) {
                                ok = false;
                                break;
                            }
                        }
                        if (!ok) break;
                        h++;
                        nu += ri - le + 1;
                    }
                    max = (max < nu) ? nu : max;
                }
            }
        }
        return max;
    }
}
