package DSA_14_DynamicProgramming.DP;

public class DP_Q_05_KadaneAlgorithm {
 
    // maximum sum submatrix
    // time O(n^4 * N^2) = O(n^6) ~ O(n^5)

    static int m(int[][] arr, int m, int n) {
        int max = Integer.MIN_VALUE;
        for (int cs = 0; cs < m; cs++) {
            for (int ce = cs; ce < m; ce++) {
                int[] carr = new int[n];
                for (int r = 0; r < n; r++) {
                    carr[r] += arr[ce][r]; 
                }
                max = Math.max(max, kadane(carr));
            }
        }
        return max;
    }

    static int kadane(int[] arr) {
        int currentSum = 0;
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

}
