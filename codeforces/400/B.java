import java.util.Scanner;

/**
 * Created by drproduck on 2/26/17.
 */
public class B {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n + 2];
        for (int i = 2; i < n+2; i++) {
            if (p[i] == 0) {
                p[i] = 1;
                for (int j = i+i; j < n+2; j+=i) {
                    if (p[j] == 0) {
                        p[j] = 2;
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 2; i < n+2; i++) {
            res.append(p[i] + " ");
        }
        if (n < 3) {
            System.out.println(1);
        }
        else System.out.println(2);
        System.out.println(res.toString());
    }
}
