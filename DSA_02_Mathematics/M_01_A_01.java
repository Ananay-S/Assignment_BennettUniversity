package DSA_02_Mathematics;

// Mathematics_01_Application_01
public class M_01_A_01 {
    
    // A1) factorial of anumber
    static int factorial(int n) {
        int fact=1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // A2) trailing zeros in a factorial
    static int trailingZeros(int n) {
        int count=0;
        for (int i = 5; i <= n; i*=5) {
            count += n/i;
        }
        return count;
    }

    // A3) palindrome numbers
    static boolean isPalindrome(int n) {
        int temp=n;
        int m=0;
        while (temp > 0) {
            m = (m*10) + (temp%10);
            temp /= 10;
        }
        return (n == m) ? true : false;
    }

    public static void main(String[] args) {
        // A1) factorial of anumber
        System.out.println(factorial(5));
        System.out.println();

        // A2) trailing zeros in a factorial
            // (no. of factors of 5 < 2) (factors of n in m! = [m/n] + [m/n^2]...)
        System.out.println(trailingZeros(5));
        System.out.println();

        // A3) palindrome numbers 
            // how to reverse a number
        System.out.println(isPalindrome(505));
        System.out.println();
    }
}
