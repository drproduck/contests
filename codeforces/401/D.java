import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by drproduck on 3/5/17.
 */
public class D {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.next();
        }
        for (int i = n-1; i >= 1; i--) {
            String x = a[i];
            String y = a[i - 1];
            if (y.equals("#")) {
                continue;
            }
            if (x.equals("#")) {
                a[i-1] = "#";
                continue;
            }
            int yp = 1;
            boolean changed = false;
            boolean greater = false;
            for (int j = 1; j < x.length() && yp < y.length(); j++) {
                if (x.charAt(j) > y.charAt(yp)) {
                    greater =true;
                    break;
                } else {
                    if (x.charAt(j) == y.charAt(yp)) {
                        yp++;
                    } else {
                        a[i - 1] = y.substring(0, yp);
                        changed = true;
                        break;
                    }
                }
            }
            if (greater) {
                continue;
            }
            else if (!changed) {
                if (y.length() <= x.length()) {
                    continue;
                } else {
                    a[i-1] = x.substring(0, x.length());
                }
            }
        }
        StringBuilder s = new StringBuilder(1000000);
        for (int i = 0; i < n; i++) {
            s.append(a[i] + "\n");
        }
        System.out.println(s.toString());
    }
}
