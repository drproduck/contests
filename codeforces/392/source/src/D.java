import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Khiem on 1/19/2017.
 */
public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        String n = in.next();
        Stack<Long> a = new Stack();
        long b = 0;
        int radix = 0;
        int numZ = 0;
        boolean lastNumZ = false;
        for (int i = n.length() - 1; i >= 0; i--) {
            int c = Character.getNumericValue(n.charAt(i));
            if (c == 0) {
                numZ++;
                lastNumZ = true;
                radix++;
            } else {
                if (b + (int) Math.pow(10, radix) > k) {
                    if (b!=0)
                    a.push(b);
                    i++;
                    if (lastNumZ) {
                        radix = numZ;
                        numZ = 0;
                    } else while (numZ > 0) {
                            a.push(0L);
                            numZ --;
                        }
                    b = 0;
                    lastNumZ = false;
                } else {
                    b += c * (int) Math.pow(10, radix);
                    radix++;
                    lastNumZ = false;
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
        }
        System.out.println(sum);
    }
}
