import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LongSummaryStatistics;
import java.util.Scanner;

/**
 * Created by drproduck on 3/5/17.
 */
public class E {
    static long[][] b;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = in.nextInt();
            }
        }
        long[][] ori = new long[n][1];
        b = new long[n][3];
        for (int i = 0; i < n; i++) {
            b[i][0] = i;
            b[i][1] = a[i][1];
            b[i][2] = 0;
        }
        for (int i = 0; i < n; i++) {
            ori[i] = b[i];
        }

        Arrays.sort(b, (long[] x, long[] y) -> Long.compare(x[1], y[1]));
        System.out.println(Arrays.deepToString(ori));
        buildTree();

        Arrays.sort(a, (int[] x, int[] y) -> Integer.compare(x[1], y[1]));
        long[] dp = new long[n];
        dp[0] = a[0][2];
        for (int i = 1; i < n; i++){
            long max = 0;
            for (int j = 0; j < i; j++) {
                if (a[i][0] < a[j][1]) {
                    max = Long.max(max, dp[j]);
                }
            }
            dp[i] = a[i][2] + max;
        }
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Long.max(max, dp[i]);
        }
        System.out.println(max);
    }

    static int[] st;

    static void buildTree() {
        st = new int[b.length*4];
        build(1, 0, b.length-1);
    }

    static int left(int p) {
        return p << 1;
    }

    static int right(int p) {
        return (p << 1) + 1;
    }
    static void build(int p, int l, int r) {
        if (l == r) {
            st[p] = l;
        } else {
            build(left(p), l, (l + r) / 2);
            build(right(p), (l + r) / 2 + 1, r);
            int p1 = st[left(p)];
            int p2 = st[right(p)];
            st[p] = (b[p1][2] >= b[p2][2]) ? p1 : p2;
        }
    }

    static int que(int u, int v) {
        return que(1, 0, b.length - 1, u, v);
    }

    static int que(int p, int l, int r, int u, int v) {
        if (l >= u && r <= v) {
            return st[p];
        }
        if (l > v || r < u) {
            return -1;
        }
        int p1 = que(left(p), l, (l + r) / 2, u, v);
        int p2 = que(right(p), (l + r) / 2 + 1, r, u, v);
        if (p1 == -1) return p2;
        if (p2==-1) return p1;
        return (b[p1][2] >= b[p2][2]) ? p1 : p2;
    }

    static void update(int i, int v) {
        update(1, 0, b.length - 1, i, v);
    }

    static void update(int p, int l, int r, int i, int v) {
        if (l == r&&l==i) {
            return;
        }
        if (i <= (l + r) / 2) {
            update(left(p), l, (l + r) / 2, i, v);
        } else update(right(p), (l + r) / 2 + 1, r, i, v);
        int p1 = st[left(p)];
        int p2 = st[right(p)];
        st[p] = (b[p1][2] >= b[p2][2]) ? p1 : p2;
    }
}
