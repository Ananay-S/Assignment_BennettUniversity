package DSA_14_DynamicProgramming.DP.DP_Q_01;

import java.util.Arrays;

public class DP_Q_01_TribonacciNumbers {

    // f(n) = f(n-1) + f(n-2) + f(n-3)
    
    // m-1
    // recursion
    // time O(3^n)
    // space O(n)
    static int m1(int n) {
        if (n<2) return 0;
        if (n==2) return 1;
        else return m1(n-1)+m1(n-2)+m1(n-3);
    }
    // _____________________________________________________________________
    // m-2
    // memoization
    // time O(n)
    // space O(n)
    static int m2Util(int n, int[] dp) {
        if (n<2) return 0;
        if (n==2) return 1;
        if (dp[n]!=-1) return dp[n];
        else return dp[n] = m1(n-1)+m1(n-2)+m1(n-3);
    }
    static int m2(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return m2Util(n, dp);
    }
    // _____________________________________________________________________
    // m-3
    // tabulation
    // time O(n)
    // space O(n)
    static int m3(int n) {
        if (n<2) return 0;
        int[] dp =new int[n+1];
        dp[2]=1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
    // _____________________________________________________________________
    // m-4
    // iteration
    // time O(n)
    // space O(1)
    static int m4(int n) {
        if (n<2) return 0;
        if (n==2) return 1;
        int previous3 = 0;
        int previous2 = 0;
        int previous1 = 1;
        int current = 0;
        for (int i = 3; i <= n; i++) {
            current = previous1 + previous2 + previous3;
            previous3 = previous2;
            previous2 = previous1;
            previous1 = current;
        }
        return current;
    }
    // _____________________________________________________________________
    // m-5
    // matrix exponentiation
    // time O(logn) 
    // space O(1)
    // let len be order of matrix then O(len^3 * 'logn / 1')
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
        if (n<2) return 0;
        if (n==2) return 1;
        // f(n) = f(n-1) + f(n-2) + f(n-3)
        int[][] fn = {{1,1,1},{1,0,0},{0,1,0}};
        int len = 3;
        int[][] result = matrixExponentiate(fn, len, n-2);
        return result[0][0];
    }
    // _____________________________________________________________________

    public static void main(String[] args) {
        int n=9;

        System.out.println("m1: "+m1(n));
        System.out.println("m2: "+m2(n));
        System.out.println("m3: "+m3(n));
        System.out.println("m4: "+m4(n));
        System.out.println("m5: "+m5(n));
    }
}