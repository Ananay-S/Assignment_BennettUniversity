package DSA_05_Sort_Search.Practice_05;

import java.util.Arrays;
import java.util.Collections;

public class P_01_PermuteTwoArraysSoSumOfEveryPair {
    
    // m1
    static boolean isPossible(int a[], Integer b[], int n, int k) {
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if (a[i]+b[i] < k) return false;
        }

        return true;
    }

    public static void main(String[] args) {
     
        // Q permute two arrays such that sum of every pair is greater or equal to k
        int a[] = {2, 1, 3}; 
        Integer b[] = {7, 8, 10}; 
        int k = 10; 
        int n = a.length;
        System.out.println(isPossible(a, b, n, k));
    }
}
