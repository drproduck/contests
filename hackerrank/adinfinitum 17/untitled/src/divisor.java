import java.util.Scanner;

/**
 * Created by Khiem on 12/31/2016.
 */
public class divisor {
    static final int n = (int) Math.pow(10, 5);
    static final int mod = (int) Math.pow(10,9)+7;
    static int[] firstNPrimes = initializePrimeArray(n);

    //product *= (biggestTerm - (ithPrime - 1) * biggestPower - 1) / ((ithPrime - 1) * (ithPrime - 1))
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        StringBuffer s = new StringBuffer();
        for (int a0 = 0; a0 < q; a0++) {
            int m = in.nextInt();
            int a = in.nextInt();
            long product = 1;
            for (int i = 1; i <= m; i++) {
                int ithPrime = firstNPrimes[i];
                int biggestPower = a + i + 2;
                int biggestTerm = powerMod(ithPrime, biggestPower, mod)+mod;
                int secondTerm = ((ithPrime-1)*biggestPower+1)%mod;
                int square = (int)((long) (ithPrime - 1) * (long) (ithPrime - 1) % mod);
                if (square == 1 || square == 0) {
                    product *= (biggestTerm-secondTerm)%mod;
                }
                else {
                    int bottom = getInverseMod(square, mod) % mod;
                    product *= (long)(biggestTerm - secondTerm) * (long)bottom % mod;
                    product %= mod;
                }
            }
            product %= mod;
            s.append(product + "\n");
        }
        System.out.println(s);
    }

    static int[] initializePrimeArray(int n) {
        double absoluteUpperBound = n * Math.log(n) + n * (Math.log(Math.log(n)) - 0.9385);
        int[] a = new int[(int) absoluteUpperBound + 1];
        for (int p = 2; p * p <= absoluteUpperBound; p++) {
            if (a[p] == 0) {
                for (int i = p * 2; i <= absoluteUpperBound; i += p) {
                    a[i] = 1;
                }
            }
        }
        int[] primes = new int[n + 1];
        for (int i = 2, j = 1; j <= n; i++) {
            if (a[i] == 0) {
                primes[j] = i;
                j++;
            }
        }
        return primes;
    }

    static private int powerMod(int i, int j, int k) {
        if (j == 1) {
            return i % k;
        } else {
            long x = powerMod(i, j / 2, k);
            if (j % 2 == 1) {
                return(int) ((x * x * i) % k);
            } else {
                return (int) ((x * x) % k);
            }
        }
    }
    public static int getInverseMod(int n, int mod) {
        int big = (n <= mod) ? mod : n;
        int small = (n<=mod) ? n : mod;
        int r;
        int q;
        int s1 = 0;
        int s2 = 1;
        int s3;
        while ((r = big%small) !=0){
            q = big/small;
            s3 = s1 - s2*q;
            s1 = s2;
            s2 = s3;
            big = small;
            small = r;

        }
        if (small > 1) return -1;
        return s2 = (s2<0)? (s2+mod):s2;
    }
}
