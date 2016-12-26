import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Khiem on 10/23/2016.
 */
public class SumOfconsecutivePrimes {
    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static ArrayList<Integer> sieve = sieve(10000);

    public static ArrayList<Integer> sieve(int n) {
        boolean[] prime = new boolean[n+1];
        for (int i = 2;i<=n;i++) {
            prime[i] = true;
        }
        for (int p = 2;p*p<=n;p++) {
            if (prime[p]) {
                for (int i=p*2;i<=n;i+=p) {
                    prime[i] = false;
                }
            }
        }
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0;i<prime.length;i++) {
        if (prime[i])
            a.add(i);
        }
        return a;
    }




    public static void main(String[] args) {
        System.out.println(sieve(100).toString());
    }
}

class RSQ {
    public RSQ(int k) {

    }
}
