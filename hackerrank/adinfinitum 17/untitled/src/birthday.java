/**
 * Created by Khiem on 12/31/2016.
 */
public class birthday {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        int c = 5;
        System.out.println(Math.pow(a+b+c, 5));
        System.out.println(Math.pow(a, 5) + Math.pow(b, 5) + Math.pow(c, 5) + 5 * (a * b * b * b * b + a * c * c * c * c + b * a * a * a * a + b * c * c * c * c + c * a * a * a * a + c * b * b * b * b + a * a * b * b * b + a * a * c * c * c + b * b * a * a * a + b * b * c * c * c + c * c * a * a * a + c * c * b * b * b));
    }
}
