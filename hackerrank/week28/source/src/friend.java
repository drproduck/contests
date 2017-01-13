import java.util.*;

/**
 * Created by Khiem on 1/12/2017.
 */
public class friend {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer str = new StringBuffer();
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            DisjointSets ds = new DisjointSets(n);
            int m = in.nextInt();
            for (int a1 = 0; a1 < m; a1++) {
                int x = in.nextInt();
                int y = in.nextInt();
                ds.add(x);
                ds.add(y);
                ds.unionBySize(x, y);
            }
            long max = 0;
            long total = 0;
            List<Node> roots = ds.getRoots();
            for (Node root :
                    roots) {
                max += root.size * (root.size - 1);
            }
            System.out.println(max);
            ds.total = total;
            ds.max = max;
            for (Node root : roots) {
                ds.size = root.size;
                ds.iterate(root);
            }
            str.append(ds.total);
            System.out.println(ds.toString());
        };
        System.out.println(str);
    }
}

class DisjointSets {

    private Node[] set;
    long total;
    long max;
    int size;

    public DisjointSets(int numElements) {
        set = new Node[numElements + 1];
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        for (int i = 1; i < set.length; i++) {
            if (set[i] != null) {
                str.append(String.format("node %d is root %b is leaf %b has size %d\n", set[i].index, set[i].isRoot, set[i].isLeaf(), set[i].size));
            }
        }
        return str.toString();
    }

    public void unionBySize(int x, int y) {
        Node nx = find(x);
        Node ny = find(y);
        if (nx.equals(ny)) {
            nx.repeated++;
        } else if (ny.size < nx.size) {
            ny.parent = nx;
            nx.children.add(ny);
            nx.size += ny.size;
            nx.repeated += ny.repeated;
            ny.isRoot = false;

        } else {
            nx.parent = ny;
            ny.children.add(nx);
            ny.size += nx.size;
            ny.repeated += nx.repeated;
            nx.isRoot = false;
        }
    }

    List<Node> getRoots() {
        List<Node> roots = new ArrayList<>();
        for (int i = 1; i < set.length; i++) {
            if (set[i] != null && set[i].isRoot) {
                roots.add(set[i]);
            }
        }
        Collections.sort(roots, (Node a, Node b) -> a.size - b.size);
        return roots;
    }

    public Node find(int x) {
        if (set[x].isRoot) {
            return set[x];
        } else {
            return find(set[x].parent.index);
        }
    }

    public boolean add(int x) {
        if (set[x] != null) {
            return false;
        } else {
            set[x] = new Node(x);
            return true;
        }
    }

    public void iterate(Node node) {
        if (node.isRoot) {
            while (node.repeated > 0) {
                total += max;
                node.repeated --;
            }
        }
        if (node.isLeaf()) {
            total += max;
            max -= size*(size-1) - (size-1)*(size-2);
            size--;
        } else {
            for (Node child :
                    node.children) {
                iterate(child);
            }
            total += max;
            max -= size*(size-1) - (size-1)*(size-2);
            size--;
        }
    }
}

class Node {
    Node parent;
    List<Node> children;
    int size;
    int repeated;
    boolean isRoot;
    int index;

    Node(int i) {
        index = i;
        isRoot = true;
        size = 1;
        repeated = 0;
        children = new ArrayList<>();
        parent = null;
    }

    void sortChildren() {
        Collections.sort(children, (Node x, Node y) -> x.size - y.size);
    }


    void add(Node x) {
        children.add(x);
    }

    boolean isLeaf() {
        return (children.size() == 0);
    }
}

