import java.util.Scanner;

/**
 * Created by Khiem on 1/17/2017.
 */
public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        RankedDisjointSets ds = new RankedDisjointSets(n);
        for (int i = 1; i <= n; i++) {
            ds.union(i, in.nextInt());
        }
        System.out.println(ds.numTrees);
    }

    static class RankedDisjointSets {
        int[] parent;
        int[] rank;
        int numTrees;

        RankedDisjointSets(int size) {
            parent = new int[size + 1];
            rank = new int[size + 1];
            numTrees = size;
        }

        void union(int x, int y) {
            x = find(x);
            y = find(y);

            if (x == y) {
                return;
            } else {
                numTrees--;
                if (rank[x] < rank[y]) {
                    parent[x] = y;
                } else if (rank[x] > rank[y]) {
                    parent[y] = x;
                } else {
                    parent[y] = x;
                    rank[x]++;
                }
            }
        }

        int find(int x) {
            if (parent[x] == 0) {
                return x;
            } else return parent[x] = find(parent[x]);
        }
    }
}


