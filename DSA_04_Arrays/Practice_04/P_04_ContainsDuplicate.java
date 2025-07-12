package DSA_04_Arrays.Practice_04;

import java.util.Arrays;
import java.util.HashSet;

public class P_04_ContainsDuplicate {
    
    // m2
    public boolean m2(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0, j = 1; j < arr.length; i++, j++) {
            if (arr[i] == arr[j]) {
                return true;
            }
        }
        return false;
    }

    // m3
    static boolean m3(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        
        // for (int i : arr) {
        //     if (set.contains(i)) {
        //         return true;
        //     } else {
        //         set.add(i);
        //     }
        // }
        for (int num : nums) {
            if (!hashSet.add(num)) {
                return true;
            }
        }

        return false;      
    }

    public static void main(String[] args) {
        
        // m1 (brute force) (i == j)
        // time: O(n^2)
        // space: O(1)

        // m2 sorting (i == i+1)
        // time: O(nlogn + n)
        // space: O(1)

        // m3 hashing (set/map) ( .contains() )
        // time: O(n)
        // space: O(n)
    }
}
