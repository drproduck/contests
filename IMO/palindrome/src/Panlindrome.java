import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Khiem on 10/28/2016.
 */
public class Panlindrome {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Khiem\\Projects\\IMO\\palindrome\\src\\PALIN9.IN"));
        int l = Integer.parseInt(br.readLine());
        char[] arr = new char[l + 1];
        for (int i = 1; i <= l; i++) {
            arr[i] = (char) br.read();
        }
        int[][] dp = new int[l + 1][l + 1];
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= l; j++) {
                if (arr[i] == arr[l + 1 - j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else dp[i][j] = (dp[i - 1][j] > dp[i][j - 1]) ? dp[i - 1][j] : dp[i][j - 1];
            }
        }
        PrintWriter pw = new PrintWriter("C:\\Users\\Khiem\\Projects\\IMO\\palindrome\\src\\PALIN9.ANS");


        int max1 = dp[1][l - 1];
        for (int i = 1; i < l; i++) {
            max1 = max1 < dp[i][l - i] ? dp[i][l - i] : max1;
        }
        int min1 = (l - 2 * max1);


        int max2 = dp[1][l - 2];
        for (int i = 1; i < l - 1; i++) {
            max2 = max2 > dp[i][l - 1 - i] ? max2 : dp[i][l - 1 - i];
        }
        int min2 = (l - 1 - 2 * max2);

        if (min1 < min2) {
            pw.println(min1);
        } else pw.println(min2);
        pw.close();
    }
}

