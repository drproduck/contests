import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by drproduck on 4/22/17.
 */
public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = in.nextInt();
        for (int i = 1; i <= nc; i++) {
            System.out.printf("Case #%d: ", i);
            double d = in.nextDouble();
            int n = in.nextInt();
            double max = Double.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                double s = (d - in.nextDouble()) / in.nextDouble();
                max = Double.max(max, s);
            }
            double res = (double) d / max;
            System.out.printf("%f\n", res);
        }
    }
}

