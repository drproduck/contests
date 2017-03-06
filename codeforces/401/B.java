import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by drproduck on 3/4/17.
 */
public class B {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();
        String m = in.next();

        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = Character.getNumericValue(s.charAt(i));
        }
        int[] b = new int[m.length()];
        for (int i = 0; i < m.length(); i++) {
            b[i] = Character.getNumericValue(m.charAt(i));
        }

        Arrays.sort(a);
        Arrays.sort(b);
        int max = 0;
        int min = 0;

        int bp = 0;
        int ap = 0;
        while (bp < b.length && ap < a.length) {
            if (b[bp] > a[ap]) {
                bp++;
                ap++;
                max++;
            } else {
                bp++;
            }
        }
        bp = 0;
        ap = 0;
        while (bp < b.length && ap < a.length) {
            if (b[bp] >= a[ap]) {
                bp++;
                ap++;
                min++;
            } else {
                bp++;
            }
        }
        System.out.printf("%d\n%d\n", l-min, max);
    }
}
