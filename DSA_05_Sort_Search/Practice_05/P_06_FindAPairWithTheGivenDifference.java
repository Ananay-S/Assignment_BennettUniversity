package DSA_05_Sort_Search.Practice_05;

import java.util.Arrays;
import java.util.HashSet;

public class P_06_FindAPairWithTheGivenDifference {
    
    // m2
    static boolean m2(int[] arr, int n) {
        n = Math.abs(n);
        Arrays.sort(arr);
        int len  = arr.length;
        int i = 0;
        int j = 1;
        while ((i<len)&&(j<len)) {
            if ((i==j)||(arr[j]-arr[i])<n) {
                j++;
            } else if ((arr[j]-arr[i])>n) {
                i++;
            } else { // (arr[j]-arr[i])==n
                return true;
            }
        }
        return false;
    }
    
    // m3
    static boolean m3(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        for (int i : arr) {
            if (set.contains((i+n))) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        
        // m1 brute force simple traversal
        // time O(n^2)
        // space O(1)

        // m2 (sorting and search) 
        // step-1 sort nlog(n)
            // step-2 
                // 1- traverse for the first element and binary searh for the required element so nlog(n)
                // time O(nlog(n)+nlog(n))
                // space O(1)
                // 2- two pointer
                // time O(nlog(n)+n)
                // space O(1)

        // m3 hashing
        // time O(n)
        // space O(n)


        int arr[] = {1, 8, 30, 40, 100};
        int n = -60;
        // System.out.println(m2(arr, n));
        System.out.println(m3(arr, n));




    }
}

// Two Pointer concept 
// Sum of two elements (p1+p2)
// p1-(0) p2-(arr.length-1)
// to increase: move p1 to right
// to decrease: move p2 to left
// Difference of two elements(p2-p1)
// p1-(0) p2-(1)
// to increase: move p2 to right
// to decrease: move p1 to right
