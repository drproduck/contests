import java.util.Scanner;

/**
 * Created by Khiem on 12/22/2016.
 */
public class nim {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        StringBuffer result = new StringBuffer();
        for (int a0 = 0; a0 < g; a0 ++) {
            int n = in.nextInt();
            int[] p = new int[n];
            for(int p_i=0; p_i < n; p_i++){
                p[p_i] = in.nextInt();
            }
            int x = 0;
            for (int i =0;i<n;i++) {
                x ^= (p[i]+1);
            }
            System.out.println(x);
            result.append((x <= 1) ? "L\n" : "W\n");
        }
        System.out.println(result);
    }
}
