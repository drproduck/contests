import java.util.Scanner;

/**
 * Created by drproduck on 2/24/17.
 */
public class E {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        if (k == 1 || k >= 4) {
            System.out.println("-1");
        } else {
            if (k == 2) {
                if (n <= 4) {
                    System.out.println("-1");
                } else {
                    StringBuilder s = new StringBuilder();
                    for (int i = 2; i <= n; i++) {
                        s.append(i+" "+(i-1)+"\n");
                    }
                    System.out.println(n-1);
                    System.out.println(s.toString());
                }
            } else if (k == 3) {
                if (n <= 3) {
                    System.out.println("-1");
                } else {
                    int count = 3;
                    StringBuilder s = new StringBuilder();
                    for (int i = 2; i <= 4; i++) {
                        s.append(i+" "+(i-1)+"\n");
                    }
                    if (n >= 5) {
                        s.append("1 5\n3 5\n");
                        count += 2;
                    }
                    for (int i = 6; i <= n; i++) {
                        for (int j = 5; j < i; j++) {
                            s.append(i+" "+j+"\n");
                            count++;
                        }
                    }
                    System.out.println(count);
                    System.out.println(s.toString());
                }
            }
        }
    }
}
