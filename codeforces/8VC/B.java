import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Khiem on 1/15/2017.
 */
public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] an = new String[n];
        String[] am = new String[m];
        for (int a = 0;a<n;a++) {
             an[a] = in.next();
        }
        for (int i = 0; i < m; i++) {
            am[i] = in.next();
        }
        Arrays.sort(an);
        int same = 0;
        int low  = (n < m) ? n : m;
        String[] ahigh = (n < m) ? am : an;
        String[] alow = (n < m) ? an : am;
        for (int a = 0;a<low;a++) {
            if (Arrays.binarySearch(ahigh, alow[a]) >= 0) {
                same++;
            }
        }
        if (n < m) {
            System.out.println("NO");
        } else if (n == m) {
            if (same % 2 == 0) {
                System.out.println("NO");
            }
            else System.out.println("YES");
        }
        else System.out.println("YES");
    }
}
