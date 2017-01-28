/**
 * Created by Khiem on 12/31/2016.
 */
public class extendedEuclid {
    public static int getInverseMod(int n, int mod) {
        int big = (n <= mod) ? mod : n;
        int small = (n<=mod) ? n : mod;
        int r;
        int q;
        int s1 = 0;
        int s2 = 1;
        int s3;
        while ((r = big%small) !=0){
            q = big/small;
            s3 = s1 - s2*q;
            s1 = s2;
            s2 = s3;
            big = small;
            small = r;

        }
        if (small > 1) return -1;
        return s2 = (s2<0)? (s2+mod):s2;
    }

    public static void main(String[] args) {
        System.out.println(extendedEuclid.getInverseMod(4, 1000000007));
    }
}
