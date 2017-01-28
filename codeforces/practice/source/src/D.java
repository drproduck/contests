import java.util.Scanner;

/**
 * Created by Khiem on 1/17/2017.
 */
public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        SegmentTree st = new SegmentTree(n);
        int k = in.nextInt();
        if (k > n / 2) {
            k = n - k;
        }
        int t = 1;
        int num = 1;
        StringBuffer str = new StringBuffer();
        do {
            st.increment(t);
            int t2 = (t + k) % n;
            st.increment(t2);
            int tt = (t + 1) % n;
            int tt2 = (t2 == 0) ? n - 1 : (t2 - 1) % n;
            num = num + 1 + st.rsq(tt, tt2);
            t = t2;
            str.append(num + " ");
        } while (t != 1);
        System.out.println(str.toString());
    }

    static class SegmentTree {
        int[] a;
        int[] st;
        int n;

        /**
         * everything is 0 in the beginning
         *
         * @param n
         */
        public SegmentTree(int n) {
            a = new int[n];
            st = new int[4 * n];
            this.n = n;
            build(1, 0, n - 1);
        }

        public SegmentTree(int n, int[] array) {
            a = array;
            this.n = n;
            st = new int[2 * n + 2];
            build(1, 0, n - 1);
        }

        int left(int p) {
            return p << 1;
        }

        int right(int p) {
            return (p << 1) + 1;
        }

        int[] st() {
            return st;
        }

        void build(int p, int L, int R) {
            for (int i = L; i <= R; i++) {
                st[p] += a[i];
            }
            if (L == R) st[p] = a[L];
            else {
                build(left(p), L, (L + R) / 2);
                build(right(p), (L + R) / 2 + 1, R);
            }
        }

        int rsq(int i, int j) {
            if (i <= j)
                return rsq(1, 0, n - 1, i, j);
            else if (i == j + 1) return st[1];
            else return st[1] - rsq(1, 0, n - 1, j + 1, i - 1);
        }

        int rsq(int p, int L, int R, int i, int j) {
            if (i > R || j < L) {
                return 0;
            }
            if (L >= i && R <= j) {
                return st[p];
            }
            return rsq(left(p), L, (L + R) / 2, i, j) + rsq(right(p), (L + R) / 2 + 1, R, i, j);
        }

        int update(int newVal, int pos) {
            int oldVal = a[pos];
            if (oldVal == newVal) return oldVal;
            a[pos] = newVal;
            int dif = newVal - oldVal;
            int p = 1;
            int L = 0;
            int R = n - 1;
            while (L != R) {
                st[p] += dif;
                if (pos < (L + R) / 2 + 1) {
                    R = (L + R) / 2;
                    p = p * 2;
                } else {
                    L = (L + R) / 2 + 1;
                    p = p * 2 + 1;
                }
            }
            return oldVal;
        }

        int increment(int pos) {
            int oldVal = a[pos];
            a[pos]++;
            int dif = 1;
            int p = 1;
            int L = 0;
            int R = n - 1;
            st[p] += dif;
            while (L != R) {
                if (pos < (L + R) / 2 + 1) {
                    R = (L + R) / 2;
                    p = p * 2;
                } else {
                    L = (L + R) / 2 + 1;
                    p = p * 2 + 1;
                }
                st[p] += dif;
            }
            return oldVal;
        }
    }
}
