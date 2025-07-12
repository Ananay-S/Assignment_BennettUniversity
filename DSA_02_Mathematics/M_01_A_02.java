package DSA_02_Mathematics;
import java.util.Arrays;

// Mathematics_01_Application_02
public class M_01_A_02 {
    
    // A1) prime numbers
    static boolean[] seiveOfEratoSthenes(int n) {
        
        boolean isPrime[] = new boolean[n+1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i*i <= n; i++) {
            for (int j = 2*i; j <= n; j+=i) {
                if (isPrime[j] == true) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    // A2) gcd
    static int gcd(int a, int b) {
        // if (b==0) return a;
        // return gcd(b, a%b);
        return (a%b==0) ? b : gcd(b, a%b);
    }

    // A3 power and modulo
    static int power(int a, int b) {
        int result = 1;

        while (b>0) {
            if ((b&1) != 0) {
                result *= a;
            }
            a *= a;
            b >>= 1;
        }

        return result;
    } // 
    static long power(long a, long b, int n) {
        long result = 1;

        while (b>0) {
            a = a%n;

            if ((b&1) != 0) {
                result = (result * a)%n; // result always mod n 
            }

            a = a * a; // a is always mod n 
            b >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        
        // A1) prime numbers
        int n = 20;
        boolean isPrime[] = seiveOfEratoSthenes(n);
        for (int i = 0; i < isPrime.length; i++) {
            System.out.println(i+" "+isPrime[i]);
        }
        System.out.println();

        // A2) gcd (property euclid's algorithm: gcd(a,b) = gcd(b,a%b))
        System.out.println(gcd(24, 60));
        System.out.println();

        // A3 power and modulo (property : (a*b)modn = (amodn * bmodn)modn)
        System.out.println(power(n, n));
        System.out.println(power(3978432, 5, 1000000007));

        
    }
}
