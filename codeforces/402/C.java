import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by drproduck on 2/26/17.
 */
public class C {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] p = new int[n][3];
        for (int i = 0; i < n; i++) {
            p[i][0] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            p[i][1] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            p[i][2] = p[i][0] - p[i][1];
        }
        Arrays.sort(p, (int[] a, int[] b) -> Integer.compare(a[2], b[2]));
        int sum = 0;
        int i = 0;
        while (i < k) {
            sum += p[i][0];
            i++;
        }
        while (i<n&&p[i][2] < 0) {
            sum += p[i][0];
            i++;
        }
        while (i < n) {
            sum += p[i][1];
            i++;
        }
        System.out.println(sum);
    }
}
