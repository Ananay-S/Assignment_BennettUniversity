package DSA_08_Hashing.Practice_08;

import java.util.HashMap;

public class P_07_CountDistinctElementsInEveryWindowOfSixek {
    
    // m2
    static void m2(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        System.out.println(map.size());
        for (int i = k; i < arr.length; i++) {
            // remove extra element
            if (map.get(arr[i-k])==1) {
                map.remove(arr[i-k]);
            } else {
                map.put(arr[i-k], map.get(arr[i-k])-1);
            }
            // 
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            System.out.println(map.size());
        }
    }


    public static void main(String[] args) {
        // m1 brute force
        // time O(n*k*k)
        // space O(1)

        // m2 hashing
        // time O(n)
        // space O(n)


    }
}
