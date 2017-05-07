import java.util.Arrays;

/**
 * Created by drproduck on 4/14/17.
 */
public class hello {
    public static void main(String[] args) {
        System.out.println("Hello");
        Integer[] a = {3, 2, 1};
        Arrays.sort(a, (x, y) -> Integer.signum(x - y));
        System.out.println(Arrays.toString(a));
    }
}
