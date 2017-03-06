import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import  java.math.*;

/**
 * Created by drproduck on 3/3/17.
 */
public class E {
    static long md = 1000000007;
    static long[] prime = new long[1000001];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();
        priming();
        k = (k >> 1) + (k & 1);
        long res = n;
        for (int i = 0; i < k; i++) {
            if (res == 1) {
                break;
            }
            res = phi(res);
        }
        System.out.println(res % md);
    }

    static void priming() {
        for (int i = 2; i < prime.length; i++) {
            if (prime[i] == 0) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = 1;
                }
            }
        }
    }

    static long phi(long n) {
        if (n == 1) return 1;
        if (n < 1e6 && prime[(int) n] == 0) return n - 1;

        int root = (int) Math.sqrt(n);
        long res = n;
        for (int i = 2; i <= root; i++) {
            if (prime[i] == 0 && n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                res = res / i * (i - 1);
            }
        }
        if (n>1) res = res / n * (n-1);
        return res;
    }
}
