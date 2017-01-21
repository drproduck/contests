import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Khiem on 1/20/2017.
 */
public class E {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader((new InputStreamReader(System.in))));
        int n = in.nextInt();
        int[][] a = new int[n][5];
        for (int i = 1; i <n;i++) {
            for (int j = 0;j<4;j++) {
                a[i][j] = in.nextInt();
            }
            a[i][4] = i;
        }
        Arrays.sort(a, (int[] x, int[] y) -> (x[0] - y[0]));
        System.out.println(Arrays.deepToString(a));
        Set<Integer> leaves = new HashSet<>();
        int[] bool = new int[n+1];
        for (int i = 1; i <= n; i++) {
            bool[a[i][0]] =1;
        }
        for (int i = 1;i<n;i++) {
            if (bool[i] == 0) {
                leaves.add(i);
            }
        }

    }
}
