import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Khiem on 1/20/2017.
 */
public class E {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader((new InputStreamReader(System.in))));
        int n = in.nextInt();
        List<int[]>[] a = new ArrayList[n+1];
        int[][] b = new int[n + 1][];
        int[] inDeg = new int[n + 1];
        for (int i = 1; i <n;i++) {
            int v = in.nextInt();
            inDeg[v] ++;
            int[] c = new int[3];
            for (int j = 0;j<3;j++) {
                c[j] = in.nextInt();
            }
            if (a[v] == null) {
                a[v] = new ArrayList<>();
            }
            a[v].add(c);
            b[i] = c;
        }
        System.out.println(Arrays.deepToString(a));
        Queue<Integer> leaves = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (a[i] == null) {
                leaves.add(i);
            }
        }

    }
}
