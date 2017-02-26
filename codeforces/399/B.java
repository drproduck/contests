import java.util.Scanner;

/**
 * Created by drproduck on 2/20/17.
 */
public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        String bits = Long.toBinaryString(n);
        long length = bits.length();
        int l = in.nextInt();
        int r = in.nextInt();
        int one_count = 0;
        for (int i = l; i <= r; i++) {
            int var_i = i;
            while(true) {
                int x = Integer.toBinaryString(var_i).length();
                if (Integer.numberOfTrailingZeros(i) == x - 1) {
                    if (bits.charAt(x - 1) == '1') {
                        one_count++;
                    } break;
                } else {
                    int p = 1 << (x-1);
                    var_i = (p << 1) - var_i;
                }
            }
        }
        System.out.println(one_count);
    }
}
