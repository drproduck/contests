import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by drproduck on 3/18/17.
 */
public class A {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int a = in.nextInt();
        int b = in.nextInt();
        int n = 0;
        while (a <= b){
            a *= 3;
            b *= 2;
            n++;
        }
        System.out.println(n);
    }
}
