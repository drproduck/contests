import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Khiem on 11/2/2016.
 */
public class main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new FileReader("C:\\Users\\Khiem\\Projects\\google\\File Fix-it\\src\\A-small-practice.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Khiem\\Projects\\google\\File Fix-it\\src\\A-small-practice.out")));
        String line;
        Node cr;
        while (in.hasNextLine()) {
            int nc = Integer.parseInt(in.nextLine());
            for (int i = 1; i <= nc; i++) {
                out.printf("Case #%d: ", i);
                int sum = 0;
                StringTokenizer tok = new StringTokenizer(in.nextLine(), " ");
                int nn = Integer.parseInt(tok.nextToken());
                int nm = Integer.parseInt(tok.nextToken());
                Node root = new Node();
                while (nn-- > 0) {
                    Node current = root;
                    for (StringTokenizer tk = new StringTokenizer(in.nextLine(), "/"); tk.hasMoreTokens(); ) {
                        cr = new Node(tk.nextToken());
                        mkdir(current, cr);
                        current = cr;
                    }
                }
                while (nm-- > 0) {
                    Node current = root;
                    for (StringTokenizer tk = new StringTokenizer(in.nextLine(), "/"); tk.hasMoreTokens(); ) {
                        cr = new Node(tk.nextToken());
                        sum += mkdir(current, cr);
                        current = cr;
                    }
                }
                out.printf("%d\n", sum);
            }
        }
        out.close();
    }

    static int mkdir(Node p, Node c) {
        int a = p.lst.indexOf(c);
        if (a == -1) {
            p.lst.add(c);
            return 1;
        }
        else return 0;
    }

}

