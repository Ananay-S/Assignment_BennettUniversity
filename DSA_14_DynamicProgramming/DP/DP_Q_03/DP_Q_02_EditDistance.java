package DSA_14_DynamicProgramming.DP.DP_Q_03;

public class DP_Q_02_EditDistance {
    
    // min number of operations to convert string s1 to s2
    // insert replace delete

    // m3
    // tabulation
    // time O(m*n)
    // space O(m*n)
    static int m3(String s1, String s2, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }

}
