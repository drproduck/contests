import jdk.nashorn.internal.runtime.OptimisticReturnFilters;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by drproduck on 2/26/17.
 */
public class E {
    static HashMap<String, Trip<String, Integer, String>> map;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {

        }

    }

}
class Pair<X, Y>{
        X value;
        Y str;

    Pair(X v, Y s) {
        value = v;
        str = s;
    }
    }
class Trip<X, Y, Z>{
    X fi;
    Y op;
    Z se;

    Trip(X a, Y b, Z c) {
        fi = a;
        op = b;
        se = c;
    }
}
class LeftSide{

}

class Value extends LeftSide extends Operand {
    Integer value;

    public Value(Integer value) {
        this.value = value;
    }
}
class Operand {

}

class Variable extends Operand {
}