import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by drproduck on 4/22/17.
 */
public class B {
    static char[] a;
    static char[] b;
    static long curb = (long) 1e18;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = in.nextInt();
        for (int i = 1; i <= nc; i++) {
            System.out.printf("Case #%d: ", i);
            String c = in.next();
            a = c.toCharArray();
            String j = in.next();
            b = j.toCharArray();
            for (int k = 0; k < c.length(); k++) {
                if (a[k] == b[k]) ;
                if (a[k] == '?' && b[k] != '?' || a[k] )
            }
        }
    }

    static void fill(int ind) {

    }
}

