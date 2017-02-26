import java.util.Scanner;

/**
 * Created by drproduck on 2/26/17.
 */
public class B {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int k = in.nextInt();
        int count0 = 0;
        int non0 = 0;
        for (int i = n.length()-1; i >= 0&&count0<k; i--) {
            if ((n.charAt(i) - 48) == 0) {
                count0++;
            } else {
                non0++;
            }
        }
        if (count0 == k) {
            System.out.println(non0);
        } else if (0 < count0&&count0 < k) {
            System.out.println(n.length()-1);
        }
    }
}
