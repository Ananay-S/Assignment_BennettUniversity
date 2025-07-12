package DSA_16_LimitedScope;

public class LS_02_BinaryExponentiation {

    static long power_r(long a, long b) {
        if (b==0) return 1;
        long result = power_r(a, b>>1);
        if ((b&1)==1) return result*result*a;
        else return result*result;
    }
    static long power_i(long a,  long  b) {
        long result = 1;
        while (b>0) {
            // System.out.println(a+" "+b+" "+result);
            if ((b&1)==1) result *= a;
            a*=a;
            b>>=1; // b/2
        }
        return result;
    }
    public static void main(String[] args) {
        
        // nth fibonacci number
        // large number mod (a^b mod m)
        System.out.println(power_r(10, 8));
        System.out.println(power_i(10, 15));
        
    }
}