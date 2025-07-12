package DSA_14_DynamicProgramming.DP.DP_Q_02;

import java.util.Arrays;

public class DP_Q_01_CoinChange {
    
    // m-1
    // recurssion
    // time O(m^n)
    // space O(n)
    static int m_1(int[] coins, int sum) {
        if (sum==0) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int left = sum-coins[i];
            if (left>=0) {
                int leftMin = m_1(coins, left);
                if (leftMin!=Integer.MAX_VALUE)
                    min = Math.min(min, leftMin+1);
            }
        }
        return min;
    }
    // _____________________________________________________________________
    
    // m-2
    // memoization
    // time O(m*n)
    // space O(n)
    static int m_2Util(int[] coins, int sum, int[] dp) {
        if (sum==0) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int left = sum-coins[i];
            if (left>=0) {
                int leftMin;
                if (dp[left]!=-1) leftMin = dp[left];
                else leftMin = m_2Util(coins, left, dp);
                if (leftMin!=Integer.MAX_VALUE)
                    min = Math.min(min, leftMin+1);
            }
        }
        dp[sum] = min;
        return min;
    }
    static int m_2(int[]coins, int sum) {
        int[] dp = new int[sum+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        return m_2Util(coins, sum, dp);
    }
    // _____________________________________________________________________

    // m-3
    // tabulation
    // time O(n)
    // space O(n)
    // _____________________________________________________________________
    
    // m - coins
    // n - sum

    // 2 approach 
    // thinking that the given coins are sorted and then taking till maximum value then  
    //  exhaustive solution
    // m-1
    // recurssion
    // time O(m^n)
    // space O(n)
    // static int m1(int[] coins, int sum, int i) {
    //     if (sum==0) return 0;
    //     int coin = coins[i];
    //     // for (int coin : coins) {
    //     int min;
    //     if (coin>sum) {
    //         // cannot take this coin
    //         min = m1(coins, sum, i+1);
    //     } else {
    //         // can take this coin
    //         // will not take this coin
    //         int minEx = 
    //         // will take this coin
    //         int minIn
            

    //     }
            
    //     // }
        
    // }
    // _____________________________________________________________________

    public static void main(String[] args) {
        int[] coins = {7,5,1}; // m
        int sum = 23; // n

        System.out.println("m1: "+m_1(coins, sum));
        System.out.println("m2: "+m_2(coins, sum));
    }
}
