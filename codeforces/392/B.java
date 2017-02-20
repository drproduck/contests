import java.util.Scanner;

/**
 * Created by Khiem on 1/19/2017.
 */
public class B {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int[] a = new int[4];
        char[] b = new char[4];
        for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '!') {
                    a[i % 4]++;
                } else {
                    b[i % 4] = c;
                }
        }
        StringBuffer str = new StringBuffer();
        int[] c = new int[4];
        for (int i = 0; i < 4; i++) {
            if (b[i] == 'R') {
                c[0] = a[i];
            } else if (b[i] == 'B') {
                c[1] = a[i];
            } else if (b[i] == 'Y') {
                c[2] = a[i];
            } else if (b[i] == 'G') {
                c[3] = a[i];
            }
        }
        str.append(String.format("%d %d %d %d\n", c[0], c[1], c[2], c[3]));
        System.out.println(str.toString());
    }
}
