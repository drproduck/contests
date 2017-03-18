import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by drproduck on 3/18/17.
 */
public class C {
    static char up = 'A';
    static char lo = 'a';
    static String cur;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int k = in.nextInt();

        StringBuilder s = new StringBuilder();
        int m = n - k + 1;
        int st = -1;
        int c = 0;
        s.append(get(false));
        int t = 0;
        while (t < m && in.next().equals("NO")) {
            t++;
        }
        int ct = t+1;
        int dt = t+k;
        while (t > 0) {
            s.append(" "+get(true));
            t--;
        }
        for (int i = ct; i<n &&i < dt; i++) {
            s.append(" "+get(false));
        }

        for (int i = dt; i < n; i++) {
            if (in.next().equals("YES")) {
                s.append(" " + get(false));
            } else {
                s.append(" " + get(true));
            }
        }
        System.out.println(s.toString());
    }

    static String get(boolean same) {
        String sa;
        if (!same) {
            sa = Character.toString(up) + Character.toString(lo);
            lo++;
            if (lo > 122) {
                lo = 97;
                up++;
            }
        } else {
            sa = cur;
        }
        cur = sa;
        return sa;
    }
}
