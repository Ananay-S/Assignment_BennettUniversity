package DSA_04_Arrays.Practice_04;

import java.util.Arrays;

public class P_05_ChocolateDistributionProblem {
    
    static int m1(int arr[], int n) {
        if (arr.length - 1 < n) {
            return -1;
        }
        if (arr.length == 0 || n == 0 ) {
            return 0;
        }

        Arrays.sort(arr);
        int differnce, min = arr[arr.length-1];
        for (int i = 0; i <= arr.length-n; i++) {

            differnce = (arr[i+n-1] - arr[i]);
            min = Math.min(min, differnce);
        }

        return min;
    }

    public static void main(String[] args) {
        
        // m1 sorting 
        // time: O(n)
        // space: O(1)
        int arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7;

        System.out.println("minimum difference: "+ m1(arr, m));

    }
}
