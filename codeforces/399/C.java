import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[1024];
        int[] tmp = new int[1024];

        for (int i = 0; i < n; i++) {
            a[in.nextInt()]++;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 1024; j++) {
                tmp[j] = a[j];
            }
            int par = 0;
            for (int j = 0; j < 1024; j++) {
                if (a[j] > 0) {
                    int cur = j^x;
                    int change = (a[j] / 2);
                    if (par==0) change += (a[j] & 1);
                    tmp[j] -= change;
                    tmp[cur] += change;
                    par ^= (a[j] & 1);
                }
            }
            for (int j = 0; j < 1024; j++) {
                a[j] = tmp[j];
            }
        }
        int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < 1024; j++) {
                if (a[j] > 0) {
                    min = Integer.min(min, j);
                    max = Integer.max(max, j);
                }
            }
        System.out.println(max + " " + min);
    }
}
