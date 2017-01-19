import java.util.Scanner;

/**
 * Created by Khiem on 1/19/2017.
 */
public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int a =0;a<n;a++) {
            ar[a] = in.nextInt();
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = (ar[i] > max) ? ar[i] : max;
        }
    int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += max - ar[i];
        }

        System.out.println(sum);
    }
}
