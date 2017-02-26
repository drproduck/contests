import java.util.Scanner;

/**
 * Created by drproduck on 2/25/17.
 */
public class D1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String k = in.next();
        int curr = k.charAt(k.length() - 1) - 48;
        int radix = 0;
        int r = 0;
        int nonzero = (curr == 0) ? -1 : 0;
        long res = 0;
        for (int i = k.length() - 2; i >= 0; i--) {
            int now = k.charAt(i) - 48;
            if (curr + pow(10, radix+1) * now >= n) {
                if (nonzero > -1) {
                    int added = curr - curr / pow(10, nonzero + 1) * pow(10, nonzero + 1);
                    curr /= pow(10, nonzero + 1);
                    res += added * pow(n, r);
                    r++;
                    radix -= nonzero;
                    while (curr + now * pow(10, radix) > n) {
                        r ++;
                        radix --;
                    }
                        curr += now * pow(10, radix);
                        nonzero = (curr == 0) ? -1 : radix;
                    }
                 else {
                    r+= radix;
                    radix = 0;
                    curr = now;
                }

            } else {
                curr += pow(10, radix+1)*now;
                radix++;
                if (now != 0) {
                    nonzero++;
                }
            }

        }
        if (curr != 0) {
            res += curr * pow(n, r);
            }
        System.out.println(res);
    }

    static int pow(int n, int p) {
        int r = 1;
        for (int i = 0; i < p; i++) {
            r *= n;
        }
        return r;
    }
}
