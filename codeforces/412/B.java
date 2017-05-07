import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by drproduck on 5/7/17.
 */
public class B {
    public static Set<Integer> sco(int n) {
        int i = (n / 50) % 475;
        Set<Integer> s = new HashSet<>();
        for (int j = 0; j < 25; j++) {
            i = (i * 96 + 42) % 475;
            s.add(i+26);
        }
        return s;
    }

//    public static Set<Integer> rev(int n) {
//        Set<Integer> s = new HashSet<>();
//        for (int i = 0; i < 25; i++) {
//            n = n - 26;
//            n =
//        }
//    }


    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int p = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();


        int sta = x - ((x - y) / 50) * 50;
        while (true) {
            if (sco(sta).contains(p)) {
                break;
            }
            sta += 50;
        }

        int dif = (x - sta) / 50;
        if (dif == 0) {
            System.out.println(0);
        } else if (dif > 0) {
            System.out.println(0);
        } else {
            dif = -dif;
            System.out.println(dif / 2 + dif % 2);
        }
    }
}
