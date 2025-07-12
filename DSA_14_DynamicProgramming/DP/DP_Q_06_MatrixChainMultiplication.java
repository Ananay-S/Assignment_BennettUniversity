package DSA_14_DynamicProgramming.DP;

public class DP_Q_06_MatrixChainMultiplication {
    
    // given 
    // order of multiple matrices
    // order of multiplication
    // find
    // min number of operations

    // m1
    // recurssion
    
    // m3
    // tabulation
    static int m3(int[] arr, int n) {
        int[][] dp = new int[n+1][n+1];
        for (int c = 2; c <= n; c++) {
            for (int i = 0, j = c; i <= n-c; i++, j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], (dp[i][k] + arr[i]*arr[k]*arr[j] + dp[k][j]));
                }
            }
        }
        return dp[0][n]; 
    }
    public static void main(String[] args) {
        
        int[] arr = {2,3,4,1,3};
        System.out.println(m3(arr, 4));
    }
}
