import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by drproduck on 4/22/17.
 */
public class B {
    String[] u = {"R", "Y", "B"};
    String[] v = {"G", "V", "O"};
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = in.nextInt();
        for (int i = 1; i <= nc; i++) {
            System.out.printf("Case #%d: ", i);
            int n = in.nextInt();

            boolean im = false;
            int r = in.nextInt(), o = in.nextInt(), y = in.nextInt(), g = in.nextInt(), b = in.nextInt(), v = in.nextInt();
            if (o >= b || g >= r || v >= y) {
                im = true;
            }
            TreeMap<String, Integer> map = new TreeMap<>();
            int[] a = new int[3];
            a[0] = r;
            a[1] = y;
            a[2] = b;
            int[] c = new int[3];
            c[0] = g;
            c[1] = v;
            c[2] = o;

            int[] d = new int[3];
            d[0] = a[0] - c[0];
            d[1] = a[1] - c[1];
            d[2] = a[2] - c[2];


            int sum = d[0] + d[1] + d[2];
            int ind_max = 0;
            int ind_min = 1;
            int ind_med;

            for (int j = 1; j < 3; j++) {
                if (d[j] > ind_max) {
                    ind_max = j;
                }
                if (d[j] < ind_min) {
                    ind_min = j;
                }
            }
            if (ind_max == ind_min) {
                ind_max = 0;
                ind_min = 1;
                ind_med = 2;
            } else {
                ind_med = 3 - ind_max - ind_min;
            }
            int e = 0;
            if (d[ind_max] > d[ind_min] + d[ind_med]) {
                int cap = d[ind_min] + d[ind_med];
                if (d[ind_max] - c[ind_max] > cap) {
                    im = true;
                } else {
                    e = d[ind_max] - cap ;
                    d[ind_max] = cap - 1;
                }
            }
            boolean done = false;
            while (!done) {
                for (int j = 1; j < 3; j++) {
                    if (d[j] > ind_max) {
                        ind_max = j;
                    }
                    if (d[j] < ind_min) {
                        ind_min = j;
                    }
                }
                if (ind_max == ind_min) {
                    ind_max = 0;
                    ind_min = 1;
                    ind_med = 2;
                } else {
                    ind_med = 3 - ind_max - ind_min;
                }

            }

        }
    }
}
