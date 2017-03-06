import java.util.Scanner;

/**
 * Created by drproduck on 2/26/17.
 */
public class A {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        int n = in.nextInt();
        String victim;
        String next;
        System.out.println(a + " " + b);
        for (int i = 0; i < n; i++) {
            victim = in.next();
            next = in.next();
            if (a.equals(victim)) {
                a = next;
            } else if (b.equals(victim)) {
                b = next;
            }
            System.out.println(a + " " + b);
        }
    }
}
