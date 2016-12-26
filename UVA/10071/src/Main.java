import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Khiem on 10/31/2016.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        StringTokenizer data;
        int a,b;
        while ((input =in.readLine()) != null) {
            data = new StringTokenizer(input);
            a = Integer.parseInt(data.nextToken());
            b = Integer.parseInt(data.nextToken());
            out.println(a * b * 2);
        }
        out.close();
    }
}

