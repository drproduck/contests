import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by drproduck on 2/19/17.
 */
public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        boolean yes = false;
        for (int i = k - 1; i >= 2; i--) {
            if (a[i] < a[i - 1] + a[i - 2]) {
                yes = true;
                break;
            }
        }
        if (!yes)
        System.out.println("NO");
        else System.out.println("YES");
    }
}
