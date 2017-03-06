import javax.naming.InsufficientResourcesException;
import javax.naming.InterruptedNamingException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;
import java.util.*;
/**
 * Created by drproduck on 3/3/17.
 */
public class D {
    static int n;
    static int m;

    static Vector<Pair<Integer, Integer>>[] adj;
    static Vector<Integer>[] edge;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        adj = new Vector[m + 1];
        for (int i = 1; i <= m; i++) {
            adj[i] = new Vector<>();
        }
        edge = new Vector[n + 1];
        for (int i = 1; i <=n; i++) {
            edge[i] = new Vector<>();
        }

        int[] status = new int[n+1];
        for (int i = 1; i <= n; i++) {
            status[i] = in.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            int y = in.nextInt();
            for (int j = 0; j < y; j++) {
                edge[in.nextInt()].add(i);
            }
        }
        for (int i = 1; i <= n; i++) {
            int x = edge[i].get(0);
            int y = edge[i].get(1);
            adj[x].add(new Pair<>(y, status[i]));
            adj[y].add(new Pair<>(x, status[i]));
        }

        boolean[] visited = new boolean[m + 1]; // if this vertex is visited
        int[] color = new int[m + 1]; // vertex color
        boolean res = true;
        for (int i = 1; i <= m&&res; i++) {
            if (!visited[i] && adj[i].size() != 0) {
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                color[i] = 0;
                visited[i] = true;
                while (!q.isEmpty()&&res) {
                    int cur = q.poll();
                    int curcol = color[cur];
                    for (Pair p :
                            adj[cur]) {
                        int next = (int) p.x;
                        int edgecol = (int) p.y;
                        if (!visited[next]) {
                            if (edgecol == 0) {
                                color[next] = 1 - curcol;
                            } else color[next] = curcol;
                            visited[next] = true;
                            q.add(next);
                        } else {
                            if (edgecol == 0 && curcol == color[next] || (edgecol == 1 && curcol != color[next])) {
                                res = false;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (res) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
}

class Pair<X, Y> {
    X x;
    Y y;
    Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}
