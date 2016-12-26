import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Khiem on 10/29/2016.
 */
public class Walls {
    public static void main(String[] args){
        FastScanner fs = new FastScanner(new File("dir goes here"));
        int nr = fs.nextInt();
        int nt = fs.nextInt();
        int[][] mtx = new int[nr+1][nt+2];
        for (int i = 1; i <= nr; i++) {
            mtx[i][0] = fs.nextInt();
            for (int j = 1;j<=nt;j++) {
                mtx[i][j] = fs.nextInt();
            }
            mtx[i][mtx[i][0]+1] = mtx[i][1];
        }
        int[][] g= new int[nr+1][nr+1];

    }
}
public static  void graph() {

}
public static void town(int[][] t,int n, FastScanner fs) {
    assert (t.length == n + 1);
    int[] adj = new int[n];
    int m = fs.nextInt();
    for (int i  =0;i<m;i++) {
        adj[i] = fs.nextInt();
    }

}
class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(File f) {
        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt() {
        return Integer.parseInt(next());
    }
}

