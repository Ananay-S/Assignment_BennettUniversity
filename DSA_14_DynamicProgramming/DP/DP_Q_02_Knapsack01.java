package DSA_14_DynamicProgramming.DP;

import java.util.Arrays;

public class DP_Q_02_Knapsack01 {
    
    // given: 
    // n items
    // val[] value of items
    // wt[] weight of items
    // w allowed weight 
    // aim: 
    // maximise value


    // m1
    // recurssion
    // time O(2^n)
    // space O(n)
    static int m1(int[] val, int[] wt, int n, int w) {
        // base case
        if (n==0 || w==0) return 0;

        if (w < wt[n-1]) { // cannot include nth item
            return m1(val, wt, n-1, w);
        } else { // max of nth item not included and included
            return Math.max(m1(val, wt, n-1, w), val[n-1] + m1(val, wt, n-1, w-wt[n-1]));
        }
    }
    // _____________________________________________________________________

    // m2
    // memoization
    // time O(n.w)
    // space O(n.w)
    static int m2Util(int[][] dp, int[] val, int[] wt, int n, int w) {    //dp->memo
        // base case
        // if (n==0 || w==0) return 0;
        if (n<0) return 0; 

        // memoization
        if (dp[n][w]!=-1) return dp[n][w];

        if (w < wt[n-1]) { 
            // cannot include nth item
            return m1(val, wt, n-1, w);
        } else { 
            // max of nth item not included and included
            // memoization
            return dp[n][w] = Math.max(m1(val, wt, n-1, w), val[n-1] + m1(val, wt, n-1, w-wt[n-1]));
        }
    }
    static int m2(int[] val, int[] wt, int n, int w) {
        int[][] dp = new int[n+1][w+1];
        // initialise with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return m2Util(dp, val, wt, n, w);
    }
    // _____________________________________________________________________

    // m3
    // tabulation
    // time O(n.w)
    // space O(n.w)
    static int m3(int[] val, int[] wt, int n, int w) {    //dp->memo
        // base case
        // if (n==0 || w==0) return 0;
        // if (n<0) return 0; 
        
        // initialization of table
        int[][] dp = new int[n+1][w+1];

        // tabulation
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                    // continue;
                } else {
                    if (j < wt[i-1]) { 
                        // cannot include nth item
                        dp[i][j] = dp[i-1][j];
                    } else { 
                        // max of nth item not included and included
                        // tabulation
                        dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]);
                    }
                }
                // System.out.println(i+" "+j+" "+dp[i][j]);
                System.out.print(dp[i][j]+" ");
            }System.out.println();

        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        
        int[] val = {10,15,40};
        int[] wt = {1,2,3};
        int n = val.length;
        int w = 6;

        System.out.println("m1: "+m1(val, wt, n, w));
        System.out.println("m2: "+m2(val, wt, n, w));
        System.out.println("m3: "+m3(val, wt, n, w));
    }
}
