import java.util.Scanner;

/**
 * Created by Khiem on 1/15/2017.
 */
public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n <= 2) {
            System.out.println(n+2);
        }
        else System.out.println(n-2);
    }
}
