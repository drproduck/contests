import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by drproduck on 5/7/17.
 */
public class A {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int hi = Integer.MAX_VALUE;
        int ch = 1; // 0 unrated, 1 maybe, 2 rated
        for (int i = 0; i <n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a != b) {
                ch = 2;
                break;
            }
            if (ch != 0 && a > hi) {
                ch = 0;
            }
            hi = a;
        }
        if (ch == 0) {
            System.out.println("unrated");
        } else if (ch == 1) {
            System.out.println("maybe");
        } else System.out.println("rated");
    }
}
