package DSA_08_Hashing.Practice_08;

import java.util.HashMap;

public class P_06_LargestSubarrayWith0Sum {
    
    // m2
    static int m2(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0;
        int max=0;

        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if (sum==0) max=i+1;
            
            Integer previous = map.get(sum);
            if (previous!=null) {
                max = Math.max(max, (i-previous));
            } else {
                map.put(sum, i);
            } 
        }
        return max;
    }
    public static void main(String[] args) {
        
        // m1 brute force 
        // time O(n^2)
        // space O(1)

        // m2 hashmap
    }
}
