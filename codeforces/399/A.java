import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by drproduck on 2/20/17.
 */
public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        if (a.length == 2) {
            System.out.println(0);
        } else {
            int result = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                min = (min > a[i]) ? a[i] : min;
            }
            int min_count = 0;
            for (int i = 0; i < n; i++) {
                if (min == a[i]) {
                    min_count++;
                }
            }
            if (min_count >= a.length - 1) {
                result = 0;
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                max = (max < a[i]) ? a[i] : max;
            }
            int max_count = 0;
            for (int i = 0; i < n; i++) {
                if (max == a[i]) {
                    max_count++;
                }
            }
            result = a.length - min_count - max_count;
            System.out.println(result);
        }
    }
}
