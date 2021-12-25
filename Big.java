import java.math.BigInteger;

public class Big {
   
    public static BigInteger factorial(int n) {
        if (n <= 1) {
            return BigInteger.ONE;
        } else {
            BigInteger result = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 30; i++) {
            System.out.printf("%2d! : %d%n", i, factorial(i));
        }
    }
}
