import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Khiem on 12/30/2016.
 */
public class primitiveproblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        ArrayList<Integer> factors = factors(p - 1);
        int sum = p - 1;
        for (Integer factor : factors) {
            sum = sum * (factor - 1) / factor;
        }
        int min = -1;
        for (int i = 2; i<=p-1;i++) {
            boolean passed = true;
            for (Integer factor : factors) {
                int x = powerMod(i, (p-1)/factor, p);
                if (x==1) {
                    passed = false;
                    break;
                }
            }
            if (passed) {
                min = i;
                break;
            }
        }
        System.out.println(min + " " + sum + "\n");
    }

    static private int powerMod(int i, int j, int k) {
        if (j == 1) {
            return i % k;
        }
        else {
            int x = powerMod(i, j / 2, k);
            if (j % 2 == 1) {
                return (x * x * i) % k;
            } else {
                return (x * x) % k;
            }
        }
    }

    static private ArrayList<Integer> factors(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        int[] a = new int[n+1];
        for (int i = 2; i <= n; i++) {
            if (a[i] == 0) {
                if (n % i == 0) {
                    factors.add(i);
                    n /= i;
                }
                while (n % i == 0) {
                    n /= i;
                }
                for (int j = i; j <= n; j += i) {
                    a[j] = 1;
                }
            }
        }
        return factors;
    }
}
