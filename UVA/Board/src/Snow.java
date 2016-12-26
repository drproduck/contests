import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Khiem on 10/23/2016.
 */
public class Snow {

    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int numC = in.nextInt();
        while (numC-- > 0) {
            String name = in.next();
            int R = in.nextInt();
            int C = in.nextInt();
            int n = R * C;
            Vertex[][] m = new Vertex[R][C];
            while (n-- > 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        m[i][j] = new Vertex(i, j, in.nextInt());
                        if (i > 0) {
                            Vertex higher = m[i][j];
                            Vertex lower = m[i - 1][j];
                            if (higher.h < lower.h) {
                                higher = m[i - 1][j];
                                lower = m[i][j];
                            }
                            higher.to(lower);
                        }
                        if (j > 0) {
                            Vertex higher = m[i][j];
                            Vertex lower = m[i][j - 1];
                            if (higher.h < lower.h) {
                                higher = lower;
                                lower = m[i][j];
                            }
                            higher.to(lower);

                        }
                    }
                }
                //System.out.printf("%s: %d", name, longestPath(m, R, C));
            }
        }

    }

    public static int longestPath(Vertex[][] m, int r, int c) {
        Vertex[] order = new Vertex[r * c];
        int n = 0;
        Stack<Vertex> s = new Stack<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (m[i][j].id == 0) {
                    s.add(m[i][j]);
                }
            }
        }
        while (!s.isEmpty()) {
            Vertex current = s.pop();
            order[n] = current;
            n++;
            for (int i = current.od - 1; i >= 0; i--) {
                Vertex next = current.adj[i];
                next.id--;
                if (next.id == 0) {
                    s.add(next);
                }
            }
        }
        int max = -1;
        for (int i = order.length - 1; i > 0; i--) {
            Vertex current = order[i];
            for (int j = current.od - 1; j >= 0; j--) {
                current.t = Math.max(current.t, current.adj[j].t);
            }
            max = Math.max(max, current.t);
        }
        return max;
    }

}


