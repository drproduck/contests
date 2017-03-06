import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by drproduck on 2/26/17.
 */
public class D {
    static int[] a;
    static char[] y;
    static String t;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String p = in.next();
        t = in.next();

        y = new char[p.length()];
        for (int i = 0; i < p.length(); i++) {
            y[i] = p.charAt(i);
        }

        a = new int[p.length()];
        for (int i = 0; i < p.length(); i++) {
            a[i] = in.nextInt() - 1;
        }
        int res = binSearch(0, a.length - 1, y);
        System.out.println(res);
    }

    static int binSearch(int l, int r, char[] curbest) {
        if (l == r) {
            return l;
        } else {
            int mid = (r + l) / 2;
            int[] b = Arrays.copyOfRange(a, l, mid+1);
            char[] c = Arrays.copyOf(curbest, curbest.length);
            for (int i = b.length - 1; i >= 0; i--) {
                c[b[i]] = ' ';
            }
            if (has(c, t)) {
                return binSearch(mid + 1, r, c);
            } else {
                return binSearch(l, mid, curbest);
            }
        }
    }

    static boolean has(char[] a, String b) {
        int c = 0;
        for (int i = 0; i < a.length&&c<b.length(); i++) {
            if (a[i] == b.charAt(c)) {
                c++;
            }
        }
        if (c == b.length()) {
            return true;
        }
        return false;
    }
}
