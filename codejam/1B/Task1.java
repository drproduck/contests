import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by drproduck on 4/21/17.
 */
public class Task1 {
    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args){
        int nc = in.nextInt();
        for (int i = 1; i <= nc; i++) {
            System.out.printf("Case #%d: ", i);
            int n = in.nextInt();
            int p = in.nextInt();

            int[] s = new int[n];
            for (int j = 0; j < n; j++) {
                s[j] = in.nextInt();
            }

            int[][] q = new int[n][p];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < p; k++) {
                    q[j][k] = in.nextInt();
                }
                Arrays.sort(q[j]);
            }

            int res = 0;
            int[] pointer = new int[n];
            while (true) {
                boolean ok = true;
                int min = -1, max = Integer.MAX_VALUE;
                int move_id = -1;

                for (int j = 0; j < n; j++) {
                    if (pointer[j] == p) {
                        ok = false;
                        break;
                    }
                    int lx = (q[j][pointer[j]] * 10 - 1) / (11 * s[j] + 1);
                    int rx = (q[j][pointer[j]] * 10) / (9 * s[j]);

                    if (rx < max) {
                        move_id = j;
                    }
                    min = Integer.max(min, lx);
                    max = Integer.min(max, rx);
                }

                if (!ok) {
                    break;
                }

                if (min <= max) {
                    res++;
                    for (int j = 0; j < n; j++) {
                        pointer[j]++;
                    }
                } else {
                    pointer[move_id] ++;
                }
            }

            System.out.printf("%d\n", res);
        }
    }
}
