import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Scanner;

/**
 * Created by Khiem on 12/24/2016.
 */
public class buildtree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] edges = new int[n - 1][2];
        int[] connections = new int[n + 1];
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0;j<2;j++) {
                edges[i][j] = in.nextInt();
            }
            connections[edges[i][1]]++;
            connections[edges[i][2]]++;
        }
        ArrayQueue<Integer> q = new ArrayQueue<>(n);
        int[] parents = new int[n + 1];
        for (int i=1;i<connections.length;i++) {
            if (connections[i] == 1) {
                q.add(i);

            }
        }
    }
}
