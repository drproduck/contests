import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Random;

/**
 * Created by drproduck on 5/6/17.
 */
public class A {
    public static int mod = 1000000007;
    public static int[] a;

    public static void main(String[] args) {
        a = new int[10010];
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = in.nextInt();
        for (int i = 1; i <= nc; i++) {
            System.out.printf("Case #%d: ", i);
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            int res = solve(n);
            System.out.printf("%d\n", res);
        }
    }

    public static int solve(int n) {
        int two = 1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                res = add(res, mul(two, a[j + i] - a[j]));
            }
            two = mul(two, 2);
        }
        return res;
    }

    public static int add(int a, int b) {
        return (int) (((long) a + (long) b) % mod);
    }

    public static int mul(int a, int b) {
        return (int) ((long) a * (long) b % mod);
    }
}
