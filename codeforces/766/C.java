import java.util.*;

public class C{
    static int[] max_l;
    static int min_num_strings = 0;
    static int[] ways;
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
        max_l[length-1] = 1;
        ways[length-1] = 1;
        s = in.next();
        alfa = new int[26];
        for (int i = 0; i < 26; i++) {
            alfa[i] = in.nextInt();
        }
        recurse(0);
        System.out.println(ways[0]);
    }

    static int asci(char c) {
        return c - 97;
    }
    static int recurse(int pos) {
        int old_pos = pos;
        if (pos == ways.length - 1) {
            return 1;
        }
        int w = 0;
        int l = 0;

        int[] a = new int[26];
        while (pos < ways.length) {
            int x = asci(s.charAt(pos));
            a[x]+=1;
            if (a[x] > alfa[x]) {
                break;
            }
            l++;
            pos++;
            if (pos == ways.length)
                w++;
            else if (ways[pos] != -1) {
                w = (w + ways[pos]) % m;
            } else w = (w + recurse(pos) % m);
        }
        ways[old_pos] = w;
        max_l[old_pos] = l;
        return w;
    }
}