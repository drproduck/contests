import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by drproduck on 3/15/17.
 */
public class C {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long n = in.nextLong();
        long m = in.nextLong();
        if (n <= m) {
            System.out.println(n);
        } else {
            long res = m;
            long start = n - m;
            long x =  (long) Math.sqrt(start * 2);
            if (x * (x + 1)  < start * 2) {
                x++;
            }
            System.out.println(res+x);
        }
    }
}
