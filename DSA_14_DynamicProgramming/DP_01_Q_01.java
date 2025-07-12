package DSA_14_DynamicProgramming;

import java.util.Arrays;

public class DP_01_Q_01 {
    
    // MIN COINS
    // m1
    static int m1(int sum, int[] arr) {
        if (sum==0) return 0;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (sum-num >= 0) {
                int n = m1(sum-num, arr);
                if (n!=Integer.MAX_VALUE) min = Math.min(min, n+1); // expection handle
            }
        }
        return min;
    } 
    // m2
    static int m2(int sum, int[] arr, int[] dp) {
        if (sum==0) return 0;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (sum-num >= 0) {
                int n = 0;
                if (dp[sum-num]==-1) {
                    n = m2(sum-num, arr, dp);    
                } else {
                    n = dp[sum-num];
                }
                if (n!=Integer.MAX_VALUE) min = Math.min(min, n+1); // expection handle
            }
        }
        // System.out.println(sum+" "+min);
        return dp[sum] = min;
    } 
    
    public static void main(String[] args) {
        // Dp 
        // m^n to m*n

        // Q1 min no of coins
        int sum = 18;
        int[] arr ={1,7,5 };
        // m1 recursion
        System.out.println("recursion: "+m1(sum, arr));
        // m2 dp
        int[] dp = new int[sum+1];
        Arrays.fill(dp, -1);
        dp[0] = 0; 
        System.out.println("dp: "+m2(sum, arr, dp));
        for (int i : dp) {
            System.out.print(i+" ");
        }System.out.println();

    }
}
