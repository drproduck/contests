import java.util.Scanner;

/**
 * Created by Khiem on 12/21/2016.
 */
public class solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        StringBuffer result = new StringBuffer();
        int[] turn = new int[4];
        for (int i = 0; i < turn.length; i++) {
            turn[i] = -1;

        }
        for (int a0 = 0; a0 < q; a0++) {
            int angle = in.nextInt();
            int nturn = (angle / 90) % 4;
            int change = 0;
            if (turn[nturn] != -1) {
                change = turn[nturn];
            }
            else {
                switch (nturn) {
                    case 0:
                        break;
                    case 1:
                        for (int i = 1; i <= n; i++) {
                            int ii = i % 7;
                            ii *= ii;
                            for (int j = 1; j <= n; j++) {
                                int jj = j % 7;
                                jj *= jj;
                                int nj = (n + 1 - j) % 7;
                                nj *= nj;
                                if (a((ii * jj) % 7) != a((nj * ii) % 7)) {
                                    change++;
                                }
                            }
                        }
                        break;
                    case 2:
                        for (int i = 1; i <= n; i++) {
                            int ii = i % 7;
                            ii *= ii;
                            for (int j = 1; j <= n; j++) {
                                int jj = j % 7;
                                jj *= jj;
                                int ni = (n + 1 - i) % 7;
                                ni *= ni;
                                int nj = (n + 1 - j) % 7;
                                nj *= nj;
                                if (a((ii*jj) % 7) != a((ni * nj) % 7)) {
                                    change++;
                                }
                            }
                        }
                        break;
                    case 3:
                        for (int i = 1; i <= n; i++) {
                            int ii = i % 7;
                            ii *= ii;
                            for (int j = 1; j <= n; j++) {
                                int jj = j % 7;
                                jj *= jj;
                                int ni = (n + 1 - i) % 7;
                                ni *= ni;
                                if (a((ii * jj) % 7) != a((jj * ni) % 7)) {
                                    change++;
                                }
                            }
                        }
                        break;
                }
                turn[nturn] = change;
            }
            result.append(change + "\n");
        }
        System.out.println(result);
    }

    private static int a(int n) {
        switch (n) {
            case 0:
                return 1;
            case 1:
                return 1;
            case 2:
                return 0;
            case 4:
                return 0;
        }
        return 0;
    }
}


