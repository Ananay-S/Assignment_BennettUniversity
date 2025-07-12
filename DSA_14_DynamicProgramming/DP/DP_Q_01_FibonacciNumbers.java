package DSA_14_DynamicProgramming.DP;

import java.util.Arrays;

public class DP_Q_01_FibonacciNumbers {
    
    // f(n) = f(n-1) + f(n-2)

    // m-1
    // recursion
    // time O(2^n)
    // space O(n)
    static int m1(int n) {
        if (n<=1) return n; // (n==0 || n==1)
        return m1(n-1)+m1(n-2);
    }
    // _____________________________________________________________________

    // m-2
    // dp-memoization
    // time O(n)
    // space O(n)
    static int m2Util(int n, int[] dp) { // int[] memo
        if (n<=1) return n;
        if (dp[n]!=-1) return dp[n];
        return dp[n] = m2Util(n-1, dp) + m2Util(n-2, dp);
    }
    static int m2(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return m2Util(n, dp);
    }
    // _____________________________________________________________________

    // m-3
    // dp-tabulation
    // time O(n)
    // space O(n)
    static int m3(int n) {
        if (n<1) return n;
        int[] dp = new int[n+1];
        // dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    // _____________________________________________________________________
    
    // m-4
    // optimisied m-3 or iterative m-1
    // time O(n)
    // space O(1)
    static int m4(int n) {
        if (n<=1) return n;
        int previous2 = 0;
        int previous1 = 1;
        int current = 0 ;
        for (int i = 2; i <= n; i++) {
            current = previous1+previous2;
            previous2 = previous1;
            previous1 = current;
        }
        return current;
    }
    // _____________________________________________________________________

    // m-5
    // matrix exponentiation
    // time O(logn) ~ O(c^3 logn)
    // space O(1)
    static int[][] matrixExponentiate(int[][] matrix, int len, int n) {        
        int[][] result = new int[len][len];
        for (int i = 0; i < len; i++) {
            result[i][i] = 1;
        }
        if (n==0) { // identity                                      
            return result;
        }
        if (n==1) {                                             
            return matrix;
        }
        while (n>0) {
            if ((n&1)==1) matrixMultiply(result, matrix, len);
            matrixMultiply(matrix, matrix, len);
            n>>=1;
        }
        return result;
    }
    static void matrixMultiply(int[][] a, int[][] b, int len) {
        int[][] temp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    temp[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        // copy temp to a(result)
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                a[i][j] = temp[i][j];
            }
        } 
    }
    static int m5(int n) {
        if (n<=1) return n;
        // f(n) = f(n-1) + f(n-2)
        int[][] fn = {{1,1},{1,0}};
        int len = 2;
        int[][] result = matrixExponentiate(fn, len, n-1);
        return result[0][0];
    }
    
    // m-6
    // goden ratio
    // time O(1)
    // space O(1)

    public static void main(String[] args) {
        int n = 5;
        
        System.out.println("m5: "+m5(n));
        System.out.println("m4: "+m4(n));
        System.out.println("m3: "+m3(n));
        System.out.println("m2: "+m2(n));
        System.out.println("m1: "+m1(n));
    }

    // four step for optimization
    // recursion
    // memoization
    // tabulation
    // iteration (if const number of previous are required)
    
    // matrix exponentiation
    // golden ratio

}
