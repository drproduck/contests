import java.util.Scanner;

/**
 * Created by Khiem on 12/21/2016.
 */
public class hackonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int angle = in.nextInt();
            // your code goes here
        }
        int[] a = new int[101];
        a[1] = 1;
        a[2] = 0;
        a[3] = 1;
        for (int i = 4; i < a.length; i++) {
            a[i] = (a[i-1] + a[i-3])%2;
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println("a" + i * i + " = " + a[i * i]);

        }
    }
}
