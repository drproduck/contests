import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by drproduck on 5/6/17.
 */
public class B {
    public static double[][] a;
    public static double[][] d;
    public static void main(String[] args){
        a = new double[10010][3];
        d = new double[10010][10010];
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = in.nextInt();
        for (int ii = 1; ii <= nc; ii++) {
            System.out.printf("Case #%d: ", ii);
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                a[i][0] = in.nextDouble();
                a[i][1] = in.nextDouble();
                a[i][2] = in.nextDouble();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    d[i][j] = Double.max(Math.abs(a[i][0] - a[j][0]), Math.abs(a[i][1] - a[j][1])) * a[j][2];
                }
            }
            double res = solve(n);
            System.out.printf("%f\n", res);
        }
    }

    public static double solve(int n) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            double s = 0;
            for (int j = 0; j < n; j++) {
//                if (i==j) continue;
                s += d[i][j];
            }
            min = (min < s) ? min : s;
        }
        double x = 0;
        double y = 0;
        for (int i = 0; i < n; i++) {
            x += a[i][0];
            y += a[i][1];
        }
        x = x/n;
        y = y / n;

        double s = 0;
        for (int i = 0; i < n; i++) {
            s += Double.max(Math.abs(a[i][0] - x), Math.abs(a[i][1] - y));
        }
        min = (min < s) ? min : s;

        double mm = Double.MAX_VALUE;
        int z = 0;
        int w = 0;
        int t = 0;
        for (int i = 0; i < n; i++) {
            double mmm = Double.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (mmm < d[i][j]) {
                    mmm = d[i][j];
                    t = j;
                }
            }
            if (mm > mmm) {
                mm = mmm;
                z = i;
                w = t;
            }
        }
        x = (a[z][0] + a[w][0]) / 2;
        y = (a[z][1] + a[w][1]) / 2;

        s = 0;
        for (int i = 0; i < n; i++) {
            s += Double.max(Math.abs(a[i][0] - x), Math.abs(a[i][1] - y));
        }
        min = (min < s) ? min : s;
        return min;
    }
}
