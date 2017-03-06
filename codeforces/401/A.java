import java.util.Scanner;

/**
 * Created by drproduck on 3/4/17.
 */
public class A {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();

        int m = n % 6;
        int res = 0;
        switch (m) {
            case 0:
                switch (x) {
                    case 0: res = 0; break;
                    case 1: res = 1; break;
                    case 2: res = 2; break;
                } break;
            case 1:
                switch (x) {
                    case 0: res = 1; break;
                    case 1: res = 0; break;
                    case 2: res = 2; break;
                } break;
            case 2:
                switch (x) {
                    case 0: res = 1; break;
                    case 1: res = 2; break;
                    case 2: res = 0; break;
                } break;
            case 3:
                switch (x) {
                    case 0: res = 2; break;
                    case 1: res = 1; break;
                    case 2: res = 0; break;
                } break;
            case 4:
                switch (x) {
                    case 0: res = 2; break;
                    case 1: res = 0; break;
                    case 2: res = 1; break;
                } break;
            case 5:
                switch (x) {
                    case 0: res = 0; break;
                    case 1: res = 2; break;
                    case 2: res = 1; break;
                } break;
        }
        System.out.println(res);
    }
}
