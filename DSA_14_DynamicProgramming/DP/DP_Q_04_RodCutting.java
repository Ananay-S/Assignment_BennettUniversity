package DSA_14_DynamicProgramming.DP;

import java.util.Arrays;

public class DP_Q_04_RodCutting {
    
    // m1
    // recurssion
    // time O(n^n)
    // space O(n)
    static int m1(int[] price, int n) {
        if (n==0) return Integer.MIN_VALUE;

        int max = price[n-1];
        
        for (int i = 1; i <= n/2; i++) {
            int l = m1(price, i);
            int r = m1(price, n-i);
            max = Math.max(max, l+r);
        }
        
        return max;
    }

    // m2
    // memoization
    // time O(n)
    // space O(n)
    static int m2Util(int[] dp, int[] price, int n) {
        if (n==0) return Integer.MIN_VALUE;

        if (dp[n]!=-1) return dp[n];

        int max = price[n-1];
        
        for (int i = 1; i <= n/2; i++) {
            int l = m2Util(dp, price, i);
            int r = m2Util(dp, price, n-i);
            max = Math.max(max, l+r);
        }
        
        return dp[n] = max;
    }
    static int m2(int[] price, int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return m2Util(dp, price, n);
    }

    // m3
    // tabulation
    // time O(n)
    // spac O(n)
    static int m3(int[] price, int n) {
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            dp[i] = price[i-1];
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], dp[j]+dp[i-j]);
            } 
        }

        return dp[n];
    }

    
    public static void main(String[] args) {
        
        
        int[] price = {3, 5, 8, 9, 10, 17, 17, 20};
        int n = price.length;
        // int n = 2;

        System.out.println("m1: "+m1(price, n));
        System.out.println("m2: "+m2(price, n));
        System.out.println("m3: "+m3(price, n));
    }
}
