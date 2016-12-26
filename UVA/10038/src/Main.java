import java.io.*;
import java.util.StringTokenizer;
class Main {
    static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int num;
        int[] arr;
        boolean[] b;
        int s;
        while ((line = in.readLine()) != null) {
            StringTokenizer data = new StringTokenizer(line);
            num = Integer.parseInt(data.nextToken());
            arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(data.nextToken());
            }
            s = 0;
            b = new boolean[num];
            for (int i = 0; i < arr.length-1; i++) {
                int c = Math.abs(arr[i] - arr[i + 1]);
                if (c>0&&c<num&&!b[c]) {
                    b[c] = true;
                s++;
                }
            }
            if (s == num - 1) {
                System.out.println("Jolly");
            }
            else System.out.println("Not jolly");
        }
    }
}
