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

        int[] deg = new int[n];
        RankedDisjointSets ds = new RankedDisjointSets(n);
        for (int i = 0; i < m; i++) {
            int x = in.nextInt()-1;
            int y = in.nextInt()-1;
            ds.union(x, y);
            deg[x] ++;
            deg[y] ++;
        }
        boolean res = true;
        for (int i = 0; i < n; i++) {
            if (deg[i] != ds.size(i)-1) {
                res = false;
                break;
            }
        }
        if (res) System.out.println("YES");
        else System.out.println("NO");
    }
}


abstract class DisjointSets {

    public int[] getParents() {
        return parents;
    }

    public int getNumElements() {
        return numElements;
    }

    protected int[] parents;
    protected int numElements;

    public DisjointSets(int numElements) {
        this.numElements = numElements;
        parents = new int[numElements];
    }

    abstract void union(int x, int y);

    abstract int find(int x);

    abstract int size(int x);
}

class RankedDisjointSets extends DisjointSets {
    private int[] size;

    public RankedDisjointSets(int numElements) {
        super(numElements);
        for (int i = 0; i < numElements; i++) {
            parents[i] = -1;
        }
        size = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            size[i] = 1;
        }
    }

    /**
     * union-by-rank: each node initially has rank 1.Each time 2 trees are concatenated,
     * the root of the tree with smaller rank will be linked to the root of the bigger one
     * rank is not necessarily height as path compression with alter heights online
     */
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (parents[y] < parents[x]) {
                parents[x] = y;
                size[y] += size[x];
            } else {
                if (parents[x] == parents[y]) {
                    parents[x]--;
                }
                parents[y] = x;
                size[x] += size[y];
            }
        }
    }

    /**
     * path-compression: Each time 2 trees are joined, the nodes that are traversed in the smaller tree
     * will be linked to the root of the larger tree. This makes the tree less deep, allowing faster
     * access in next find. It has been shown that the amortized find is practically below 5 (though unbounded)
     *
     * @param x
     * @return
     */
    public int find(int x) {
        if (parents[x] < 0) {
            return x;
        } else {
            return parents[x] = find(parents[x]);
        }

    }

    public int size(int x) {
        return size[find(x)];
    }
}


