import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by drproduck on 4/21/17.
 */
public class A {
    static String[] a = {"ZERO", "TWO", "SIX", "SEVEN", "FIVE", "EIGHT", "THREE", "NINE", "FOUR", "ONE"};
    static int[] b = {0, 2, 6, 7, 5, 8, 3, 9, 4, 1};
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = in.nextInt();
        for (int i = 1; i <= nc; i++) {
            System.out.printf("Case #%d: ", i);
            String s = in.next();
            HashMap<Character, int[]> count = new HashMap<>();
            for (char c : s.toCharArray()) {
                int[] wrap = count.get(c);
                if (wrap == null) {
                    count.put(c, new int[]{1});
                } else {
                    wrap[0] ++;
                }
            }

            ArrayList<Integer> list = new ArrayList();
            for (int j = 0; j < a.length; j++) {
                while(true) {
                    boolean exhausted = false;
                    for (char r : a[j].toCharArray()) {
                        if (count.get(r) == null || count.get(r)[0] == 0) {
                            exhausted = true;
                            break;
                        }
                    }
                    if (exhausted) break;
                    for (char r : a[j].toCharArray()) {
                        count.get(r)[0] --;
                    }
                    list.add(b[j]);
                }
            }

            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (Integer integer : list) {
                sb.append(integer);
            }
            System.out.printf("%s\n", sb.toString());
        }
    }
}
