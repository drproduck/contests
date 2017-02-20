import java.util.Scanner;

/**
 * Created by Khiem on 1/19/2017.
 */
public class C {
    public static void main(String[] args) {
        System.out.println(row(15,2,100));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

    }

    static int row(int n, int m, int k) {
        int rows = (int) Math.ceil(k / m);
        rows  = (int) Math.ceil(rows/n);
        if (rows % 2 == 1) {
            return n - (rows % n);
        } else return rows % n;
    }
}
