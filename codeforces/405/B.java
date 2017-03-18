import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by drproduck on 3/18/17.
 */
public class B  {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int m = in.nextInt();

        HashSet<Integer>[] a = new HashSet[n];
        for (int i = 0; i < n; i++) {
            a[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt()-1;
            int y = in.nextInt()-1;
            a[x].add(y);
            a[y].add(x);
        }
        boolean[] vis = new boolean[n];
        boolean res = true;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                HashSet<Integer> s = a[i];
                vis[i] = true;
                for (Integer x :
                        s) {
                    if (!vis[x]) {
                        HashSet<Integer> t = a[x];
                        vis[x] = true;
                        if (s.size() != t.size()) res = false;
                        else {
                            for (Integer y :
                                    t) {
                                if (i!=y&&!s.contains(y)) {
                                    res = false;
                                    break;
                                }
                            }
                        }
                    }
                    if (!res) break;
                }
            }
            if (!res) break;
        }
        if (res) System.out.println("YES");
        else System.out.println("NO");
    }
}




