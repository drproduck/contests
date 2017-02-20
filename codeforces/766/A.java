import java.util.Scanner;

/**
 * Created by drproduck on 2/19/17.
 */
public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.next();
        String second = in.next();
        int result = -1;
        int a = first.length();
        int b = second.length();
        if (a != b) {
            result = (a > b) ? a : b;
        } else if (!first.equals(second)) {
            result = a;
        }
        System.out.println(result);
    }
}
