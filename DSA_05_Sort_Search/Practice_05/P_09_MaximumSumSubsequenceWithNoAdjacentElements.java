package DSA_05_Sort_Search.Practice_05;

import java.util.Arrays;

public class P_09_MaximumSumSubsequenceWithNoAdjacentElements {
    
    // m1
    static int m1(int arr[], int idx, int n) {
        System.out.println("m1");
        if (idx>=n) return 0;
        return Math.max((arr[idx] + m1(arr, idx+2, n)), (m1(arr, idx+1, n)));
    }

    // m2
    static int m2(int arr[], int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return m2_(arr, 0, n, dp);
    }
    static int m2_(int arr[], int idx, int n, int dp[]) {
        System.out.println("m2");
        if (idx>=n) return 0;
        if (dp[idx]!=-1) return dp[idx]; // return visited
        return Math.max((arr[idx] + m2_(arr, idx+2, n, dp) ), (m2_(arr, idx+1, n, dp)));
    }

    // m3
    static int m3(int[] arr, int n) {
        int inc = arr[0];
        int exc = 0;
        for (int i : arr) {
            int temp = Math.max(inc, exc);
            inc = exc + i;
            exc = temp;
        }
        return Math.max(inc, exc);
    }


    public static void main(String[] args) {
        // Stickler Thief
        int[] arr = { 5, 5, 10, 100, 10, 5 };
        int N = 6;
        
        // m1 brute recusrion backtracking
        // time O(2^n)
        // space O(n)
        System.out.println("m1: "+ m1(arr, 0, N));

        // m2 dp memoization (storing visited places)
        // time O(n)
        // space O(n)
        System.out.println("m2: "+ m2(arr, N));

        // m3 optimised  algorithm
        // time O(n)
        // space O(1)

    }
}

