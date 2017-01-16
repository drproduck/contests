import java.util.Random;
import java.util.Scanner;
/**
 * Created by Khiem on 1/11/2017.
 */
public class eight {
    public static final int divisor = (int) (Math.pow(10, 9) + 7);
    public static void main(String[] args) {
        Ranked
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String number = in.next();
        //String number = rng(n);
        long total = 0L;
        for (int i = 1; i <= n; i++) {
            long possibleLast3Digits = 0L;
            if (digit(number, i) % 8 == 0) {
                total = (total + 1)%divisor;
            }
            for (int j = i + 1; j <= n; j++) {
                if ((digit(number, i) * 10 + digit(number, j)) % 8 == 0) {
                    total = (total + 1)%divisor;
                }
                for (int k = j + 1; k <= n; k++) {
                    if ((digit(number, i) * 100 + digit(number, j) * 10 + digit(number, k)) % 8 == 0) {
                        possibleLast3Digits = (1+possibleLast3Digits)%divisor;
                    }
                }
            }
            long a = (possibleLast3Digits*powerMode(2, i-1, divisor))%divisor;
            total = (total + a)%divisor;
        }
        System.out.println(total);
    }

    public static int digit(String s, int n) {
        return Character.getNumericValue(s.charAt(n - 1));
    }

    public static long powerMode(int a, int p, int m) {
        if (p == 0) {
            return 1;
        }
        if (p == 1) {
            return a % m;
        } else {
            long x = powerMode(a, p / 2, m);
            if (p % 2 == 1) {
                return (x * x * a) % m;
            } else return (x * x) % m;
        }
    }

    public static String rng(int n) {
        Random r = new Random();
        StringBuffer str = new StringBuffer();
        for (int i = 1;i<=n;i++) {
            str.append((int) r.nextInt(10));
        }
        System.out.println("done generating");
        return str.toString();
    }
}
