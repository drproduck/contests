import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Khiem on 10/31/2016.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[][] arr = new int[4][4];
        StringTokenizer data;
        String input;
        Box min;
        int sum;
        while ((input = in.readLine()) != null) {
            sum = 0;
            min = new Box(Integer.MAX_VALUE);
            data = new StringTokenizer(input);
            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    arr[i][j] = Integer.parseInt(data.nextToken());
                    sum += arr[i][j];
                }
            }
            int[] a = new int[4];
            bt(a, 1, 3, arr, sum, min);
            out.println(min.a);
        }
        out.close();
    }



    static void bt(int[] a, int k, int n, int[][] arr, int sum, Box min) {
        if (k == n) {
            process(min, a, arr, sum);
        } else {
            boolean[] b = new boolean[4];
            for (int i = 1; i <= k; i++) {
                b[a[i]] = true;
            }
            k = k + 1;
            for (int i = 1; i <= n; i++) {
                if (!b[i]) {
                    bt(a, k, n, arr, sum, min);
                }
            }
        }
    }

    static void process(Box min, int[] a, int[][] arr, int sum) {
        min.a = Math.min(min.a, sum - arr[1][a[1]] - arr[2][a[2]] - arr[3][a[3]]);
    }

    static String color(int i) {
        switch (i) {
            case 1:
                return "B";
            case 2:
                return "G";
            case 3:
                return "C";
        }
        return null;
    }
}

class Box {
    int a;

    Box(int a) {
        this.a = a;
    }
}