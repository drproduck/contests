 /**
 * Created by Khiem on 11/8/2016.
 */
public class main {
    public int x;

    public static void main(String[] args) {
        main work = new main();
        System.out.println(work.subset(32));
    }

    void increment() {
        x++;
    }

    public int subset(int n) {
        boolean[] b = new boolean[n + 1];
        bt(b, 0, n);
        return x;
    }

    void bt(boolean[] b, int k, int n) {

        if (k == n) {
            process(b, n);
        } else {
            k++;
            boolean[] bb = new boolean[2];
            bb[1] = true;
            for (int i = 0; i < 2; i++) {
                b[k] = bb[i];
                bt(b, k, n);
            }
        }
    }


    void process(boolean[] b, int n) {
        for (int i = 0; i <= n - 2; i++) {
            if (b[i] && b[i + 2]) {
                return;
            }
        }
        increment();
    }
}

class Box {
    int x;

    public void increment() {
        x++;
    }
}

