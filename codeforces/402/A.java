import java.util.Scanner;

/**
 * Created by drproduck on 2/25/17.
 */
public class A {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[5];
        for (int i = 0; i < n; i++) {
            a[in.nextInt()-1] ++;
        }
        for (int i = 0; i < n; i++) {
            a[in.nextInt()-1] --;
        }
        int abs = 0;
        int total = 0;
        boolean pos = true;
        for (int i = 0; i < 5; i++) {
            total += a[i];
            int x = Math.abs(a[i]);
            if (x % 2 == 1) {
                pos = false;
                break;
            }
            abs += x/2;
        }
        if (total != 0 || !pos || abs % 2 == 1) {
            System.out.println("-1");
        } else {
            System.out.println(abs/2);
        }
    }
}
