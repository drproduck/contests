import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by drproduck on 3/15/17.
 */
public class A {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap();
        map.put("Tetrahedron", 4);
        map.put("Cube", 6);
        map.put("Octahedron", 8);
        map.put("Dodecahedron", 12);
        map.put("Icosahedron", 20);
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += map.get(in.next());
        }
        System.out.println(sum);
    }
}
