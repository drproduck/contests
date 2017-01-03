import java.util.Scanner;

/**
 * Created by Khiem on 12/31/2016.
 */
public class birthday {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            // your code goes here
            long f2 = in.nextLong();
            long f3 = in.nextLong();
            long f4 = in.nextLong();
            long l = in.nextLong();
            long r = in.nextLong();
            double lowerBound = f3*f2/f4;
            double upperBound = Math.sqrt(3 * f2);

        }
    }
}
