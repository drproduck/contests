import java.util.Scanner;

/**
 * Created by Khiem on 12/24/2016.
 */
public class coprimepath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] nodes = new int[n];
        for(int nodes_i=0; nodes_i < n; nodes_i++){
            nodes[nodes_i] = in.nextInt();
        }
        int[][] edges = new int[n-1][2];
        for(int edges_i=0; edges_i < n-1; edges_i++){
            for(int edges_j=0; edges_j < 2; edges_j++){
                edges[edges_i][edges_j] = in.nextInt();
            }
        }
        for(int a0 = 0; a0 < q; a0++){
            int u = in.nextInt();
            int v = in.nextInt();
            // your code goes here

        }
    }
}
