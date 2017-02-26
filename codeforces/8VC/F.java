import java.util.Scanner;

/**
 * Created by drproduck on 2/24/17.
 */
public class F {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] b = new int[n];
        int max_count = 0;
        int kk = k;
        for (int i = 0; i < n && max_count <= n && kk > 0; i++) {
            if (b[i] == 0) {
                b[i] = 1;
                if (b[a[i]] == 0) {
                    max_count+=2;
                    kk--;
                }
                b[a[i]] = 1;
            }
        }
        if (kk > 0) {
            max_count = (max_count + kk >= n) ? n : max_count + kk;
        }
        System.out.println(max_count);
        int min_count = 0;
        kk = k;

    }
}
