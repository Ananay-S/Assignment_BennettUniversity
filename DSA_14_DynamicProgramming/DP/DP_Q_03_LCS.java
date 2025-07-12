package DSA_14_DynamicProgramming.DP;

public class DP_Q_03_LCS {

    // longest common subsequence
    // play with index from back
    // algorithm
    // if char at last indes matches then call both -1 and retrun +1
    // else retrun max of left or right -1

    // m1
    // recurssion
    // time O(2^min(m,n))
    // space O(min(m,n))
    static int m1(String s1, String s2, int m, int n) {
        if (m==0 || n==0) 
            return 0;
        else if (s1.charAt(m-1) == s2.charAt(n-1))
            return 1 + m1(s1, s2, m-1, n-1);
        else 
            return Math.max(m1(s1, s2, m-1, n), m1(s1, s2, m, n-1));
    }
    // _____________________________________________________________________

    // m2
    // memoization
    // time O(m*n)
    // space O(m*n)
    static int m2Util(int[][] dp, String s1, String s2, int m, int n) {
        if (m==0 || n==0) 
            return 0;
        else if (dp[m][n]!=-1)
            return dp[m][n];
        else if (s1.charAt(m-1) == s2.charAt(n-1))
            return dp[m][n] = 1 + m1(s1, s2, m-1, n-1);
        else 
            return dp[m][n] = Math.max(m1(s1, s2, m-1, n), m1(s1, s2, m, n-1));
    }
    static int m2(String s1, String s2, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return m2Util(dp, s1, s2, m, n);
    }
    // _____________________________________________________________________

    // m3
    // tabulation
    // time O(m*n)
    // space O(m*n)
    static int m3(String s1, String s2, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    // _____________________________________________________________________
    
    // m4
    // iteration (space optimised tabulation)
    // time O(m*n)
    // space O(n)
    static int m4(String s1, String s2, int m, int n) {
        int[][] dp = new int[2][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[1][j] = 1 + dp[0][j-1];
                } else {
                    dp[1][j] = Math.max(dp[1][j-1], dp[0][j]);
                }
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = dp[1][j];
            }
        }
        return dp[1][n];
    }
    // _____________________________________________________________________

    public static void main(String[] args) {
        
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int m = s1.length();
        int n = s2.length();

        System.out.println("m1: "+m1(s1, s2, m, n));
        System.out.println("m2: "+m2(s1, s2, m, n));
        System.out.println("m3: "+m3(s1, s2, m, n));
        System.out.println("m4: "+m4(s1, s2, m, n));


        // how to print lcs 
        // +1 add to squence 
        // or in tabulation add +1 
    }
}
