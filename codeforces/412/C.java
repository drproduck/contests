import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by drproduck on 5/7/17.
 */
public class C {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = in.nextInt();
        for (int i = 0; i < nc; i++) {
            long x = in.nextLong();
            long y = in.nextLong();
            long p = in.nextLong();
            long q = in.nextLong();
            System.out.println(solve(x, y, p, q, x, y, p, q));
        }
    }

    public static long solve(long x, long y, long p, long q, long xx, long yy, long pp, long qq) {
        if (p == 0) {
            if (x == 0) {
                return 0;
            } else return -1;
        }
        if (p == q && x < y) {
            return -1;
        }
        if (x == p && y == q) {
            return 0;
        }
        if (y <= q) {
            if (p > x) {
                while (p - x > q - y) {
                    p += pp;
                    q += qq;
                }
                return q - y;
            } else {
                while (p < x) {
                    p += pp;
                    q += qq;
                }
                return q - y;
            }
        } else {
            long mul = ((y - q) / q + (((y - q) % q != 0) ? 1 : 0));
            q +=  mul * q;
            p += mul * p;
            return solve(x, y, p, q, xx, yy, pp, qq);
        }
    }
}
