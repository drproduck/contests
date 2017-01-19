import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Khiem on 1/19/2017.
 */
public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long k = in.nextLong();
        String n = in.next();
        Stack<Long> a = new Stack();
        long b = 0;
        int radix = 0;
        int numZ = 0;
        boolean lastNumZ = false;
        for (int i = n.length() - 1; i >= 0; i--) {
            int c = Character.getNumericValue(n.charAt(i));
            if (c == 0) {
                lastNumZ = true;
                numZ++;
                radix++;
            } else {
                if (b + c * Math.pow(10, radix) > k) {
                    a.push(b);
                    if (!lastNumZ) {
                        i++;
                        while (numZ > 0) {
                            a.push(0L);
                            numZ--;
                        }
                    } else {
                        radix = numZ;
                    }
                    b = 0;
                    numZ = 0;
                    lastNumZ = false;
                }
                else {
                    b += c * Math.pow(10, radix);
                    radix++;
                    lastNumZ  = false;
                    numZ = 0;
                }

            }
        }
        if (b != 0) {
            a.push(b);
        }
        radix = a.size() - 1;
        long sum = 0L;
        while (!a.empty()) {
            long x = a.pop();
            sum += (x * (long) Math.pow(k, radix));
            radix--;
            System.out.println(x);
        }
        System.out.println(sum);
    }
}
