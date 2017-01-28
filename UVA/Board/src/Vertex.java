import java.util.Scanner;

/**
 * Created by Khiem on 10/23/2016.
 */
public class Vertex {
    int t;
    int h;
    int[] cor;
    int id;
    int od;
    Vertex[] adj;

    public Vertex(int r, int c, int height) {
        h = height;
        cor = new int[2];
        cor[0] = r;
        cor[1] = c;
        adj = new Vertex[4];
    }

    public void to(Vertex vertex) {
        adj[od] = vertex;
        od++;
        vertex.id++;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(in.next());
        System.out.println(in.nextInt());
    }
}
