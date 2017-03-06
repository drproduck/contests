import java.util.Scanner;
import java.util.TreeMap;

;

/**
 * Created by drproduck on 3/1/17.
 */
public class C {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        long[] a  = new long[n];
        for (int i = 0; i < n; i++) {
           a[i] =  in.nextLong();
        }
        long[] partial_sum = new long[n];
        partial_sum[0] = a[0];
        for (int i = 1; i < n; i++) {
            partial_sum[i] = a[i] + partial_sum[i - 1];
        }
        long ans = 0;
        if (k == 1) {
            TreeMap<Long, Long> map = new TreeMap<>();
            for (int i = n - 1; i >= 0; i--) {
                if (!map.containsKey(partial_sum[i])) {
                    map.put(partial_sum[i], 1L);
                } else map.put(partial_sum[i], map.get(partial_sum[i]) + 1);
                if (i != 0) {
                    Long x = map.get(partial_sum[i - 1] + k);
                    if (x != null) {
                        ans += x;
                    }
                } else {
                    Long x = map.get(k);
                    if (x != null) {
                        ans += x;
                    }
                }
            }
        }

        if (k == -1) {
            TreeMap<Long, Long> map = new TreeMap<>();
            for (int i = n - 1; i >= 0; i--) {
                if (!map.containsKey(partial_sum[i])) {
                    map.put(partial_sum[i], 1L);
                } else map.put(partial_sum[i], map.get(partial_sum[i]) + 1);
                if (i != 0) {
                    Long x = map.get(partial_sum[i - 1] + 1);
                    if (x != null) {
                        ans += x;
                    }
                    Long y = map.get(partial_sum[i - 1] - 1);
                    if (x != null) {
                        ans += x;
                    }
                } else {
                    Long x = map.get(1);
                    if (x != null) {
                        ans += x;
                    }
                    Long y = map.get(-1);
                    if (x != null) {
                        ans += x;
                    }
                }
            }
        }
    else {
            long sk = k;
            TreeMap<Long, Long> map = new TreeMap();
            for (int i = n - 1; i >= 0; i--) {
                if (!map.containsKey(partial_sum[i]))
                    map.put(partial_sum[i], 1L);
                else map.put(partial_sum[i], map.get(partial_sum[i]) + 1);
                k = sk;
                while (k < 1e15) {
                    if (i != 0) {
                        Long x = map.get(partial_sum[i - 1] + k);
                        if (x != null) {
                            ans += x;
                        }
                    } else {
                        Long x = map.get(k);
                        if (x != null) {
                            ans += x;
                        }
                    }
                    k *= sk;
                }
            }
        }
    System.out.println(ans);
    }
}
