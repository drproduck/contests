import java.util.Arrays;

/**
 * Created by drproduck on 3/2/17.
 */
public class nchoosesk {
    static int k;
    static int n;
    static int[] b;
    static void printComb(int n, int k) {
        nchoosesk.k = k;
        nchoosesk.n = n;
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = i+1;
        }

        int[] a = new int[k];
        bt(a, 0 , 0);
    }

    static void print(int[] a) {
        System.out.println(Arrays.toString(a));
    }
    static void bt(int[] a, int bound, int count) {
        if (count == k) {
            print(a);
        } else if (bound > b.length - 1) {
                return;
        } else {
            for (int i = bound; i < b.length; i++) {
                int[] ax = Arrays.copyOf(a, a.length);
                ax[count] = b[i];
                bt(ax, i+1, count+1);
            }
        }
    }
    public static void main(String[] args){
        printComb(5, 3);
    }
}
