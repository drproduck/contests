import java.util.*;

public class C{
    static int[] max_l;
    static int[] ways;
    static int[] num_substr;
    static String s;
    static int[] alfa;
    static final int m = (int)Math.pow(10, 9) + 7;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        ways = new int[length];
        for (int i = 0; i < length; i++) {
            ways[i] = -1;
        }
        max_l = new int[length];
        num_substr = new int[length];
        for (int i = 0; i < length; i++) {
            num_substr[i] = -1;
        }
        max_l[length-1] = 1;
        ways[length-1] = 1;
        num_substr[length-1] = 1;
        s = in.next();
        alfa = new int[26];
        for (int i = 0; i < 26; i++) {
            alfa[i] = in.nextInt();
        }

        for(int pos = length-2;pos>=0;pos--) {
            int bound = Integer.MAX_VALUE;
            int var_pos = pos;
            int w = 0;
            int l = 0;
            int min = Integer.MAX_VALUE;

            while (var_pos < length && l < bound) {
                int new_bound = alfa[asci(s.charAt(var_pos))];
                if (new_bound < l + 1)
                    break;
                else bound = (new_bound < bound) ? new_bound : bound;
                l++;
                var_pos++;
                if (var_pos == length) {
                    w++;
                    min = 1;
                } else {
                    w = (w + ways[var_pos]) % m;
                    min = (min > 1 + num_substr[var_pos]) ? 1 + num_substr[var_pos] : min;
                }
            }
            ways[pos] = w;
            max_l[pos] = l;
            num_substr[pos] = min;
        }



        System.out.println(ways[0]);
        int max = -1;
        for (int i = 0; i < max_l.length; i++) {
            max = (max_l[i] > max) ? max_l[i] : max;
        }
        System.out.println(max);
        System.out.println(num_substr[0]);
    }

    static int asci(char c) {
        return c - 97;
    }
}