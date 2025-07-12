package DSA_14_DynamicProgramming.DP;

public class DP_Q_07_PalandromicPartitioning {
    
    // tabulation
    static int m3(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int c = 1; c < n; c++) {
            for (int i = 0, j = c; i < n-c; i++, j++) {
                if (isPalindrome(str, i, j)) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], (dp[i][k] + dp[k+1][j] + 1));
                    }
                }
            }
        }
        // dpPrint(dp);
        return dp[0][n-1];
    }
    static boolean isPalindrome(String str, int i, int j) {
        while (i<j) {
            if (str.charAt(i++)!=str.charAt(j--)) return false;
        }
        return true;
    }
    static void dpPrint(int[][] dp) {
        for (int[] is : dp) {
            for (int is2 : is) {
                System.out.print(is2 + "\t");
            } System.out.println();
        }
    }
    public static void main(String[] args) {
        
        String str = "abac";
        System.out.println(m3(str));
    }
}
