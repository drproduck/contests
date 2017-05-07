import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by drproduck on 5/7/17.
 */
public class D {
    public static long[] two;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        two = new long[50];
        two[0] = 1;
        for (int i = 1; i < 50; i++) {
            two[i] = 2 * two[i - 1];
        }
        TreeMap<Long, long[]> t = new TreeMap<>();
        TreeMap<Long, long[]> l = new TreeMap<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            long x = in.nextLong();
            if (Arrays.binarySearch(two, x) < 0) {
                if (l.containsKey(x)) {
                    l.get(x)[0]++;
                } else {
                    l.put(x, new long[]{0});
                }
            } else {
                if (t.containsKey(x)) {
                    t.get(x)[0]++;
                } else {
                    t.put(x, new long[]{0});
                }
            }
            boolean ok = true;
            while (l.size() > 0) {
                Map.Entry<Long, long[]> e = l.pollFirstEntry();
                int floor = Arrays.binarySearch(two, e.getValue()[0]);
                floor = -(floor + 1);
                for (int j = 0; j < floor; j++) {
                    if (t.get(x) == null) {
                        ok = false;
                        break;
                    } else {
                        if (t.get(x)[0] <= 0) {
                            ok = false;
                            break;
                        } else {
                            t.get(x)[0] --;
                        }
                    }
                }
                if (!ok) break;
            }
            if (!ok)
        }
    }
}
