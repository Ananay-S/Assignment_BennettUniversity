package DSA_08_Hashing.Practice_08;

import java.util.HashSet;
import java.util.Set;

public class P_03_KthSmallestElementAfterRemovingSomeNaturalNumbers {
    
    // m3
    public class KthSmallestNumber {
    
    public static void main(String[] args) {
        int[] arr = {1, 3};
        int k = 4;
        int kthSmallest = findKthSmallestNumber(arr, k);
        System.out.println("K-th smallest number: " + kthSmallest);
    }
    
    public static int findKthSmallestNumber(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        
        // Add elements from the array to the set
        for (int num : arr) {
            set.add(num);
        }
        
        int num = 1; // Current natural number
        
        while (k > 0) {
            if (set.contains(num)) {
                num++;
            } else {
                k--;
                num++;
            }
        }
        
        return num - 1; // Subtract 1 to get the k-th smallest number
    }
}
    public static void main(String[] args) {
        
        // m1 auxilary array
        // with index intialised as 0 
        // mark index 1 if present 
        // side by side mintain count for each present element

        // m2 sorting
        // missing numbers bw i and i+1 index = arr[i+1]-arr[i]-1
        // O(nlogn) O(1)

        // m3 hashing
        // O(n+k) O(n)


    }
}
