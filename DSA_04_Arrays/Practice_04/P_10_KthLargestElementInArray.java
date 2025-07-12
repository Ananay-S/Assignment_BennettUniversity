package DSA_04_Arrays.Practice_04;

import java.util.Arrays;

public class P_10_KthLargestElementInArray {
    
    // m1
    static int m1(int arr[], int k) {
        Arrays.sort(arr);
        return arr[arr.length - k];
    }
    public static void main(String[] args) {
        
        // m1 sorting (requires editing)
        // time O(nlogn)
        // space O(1)
        System.out.println("kth larget elemnt: ");
    }
}
