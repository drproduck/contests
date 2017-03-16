import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by drproduck on 3/15/17.
 */
public class B {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();

        int mine = Integer.MAX_VALUE;
        int maxs = Integer.MIN_VALUE;
        int s;
        int e;
        for (int i = 0; i < n; i++) {
            s = in.nextInt();
            e = in.nextInt();
            maxs = (maxs >= s) ? maxs : s;
            mine = (mine <= e) ? mine : e;
        }
        int m = in.nextInt();
        int max = 0;
        for (int i = 0; i < m; i++) {
            s = in.nextInt();
            e = in.nextInt();
            int dif1 = maxs - e;
            int dif2 = s - mine;
            max = (max >= dif1) ? max : dif1;
            max = (max >= dif2) ? max : dif2;
        }
        System.out.println(max);
    }
}
