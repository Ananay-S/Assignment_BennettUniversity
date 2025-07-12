package DSA_04_Arrays.Practice_04;

import java.util.HashMap;

public class P_23_SubarraySumDivisibleByK {
    
    // m
    static int m(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = (sum + arr[i]) % k;
            if (sum == 0) {
                max = Math.max(max, i+1);
            } else if (sum > 0) {
                if (map.containsKey(sum)) {
                    max = Math.max(max, (i-map.get(sum)));
                } else {
                    map.put(sum, i);
                }
            } else {
                sum = (sum + k) % k;
                if (map.containsKey(sum)) {
                    max = Math.max(max, (i-map.get(sum)));
                } else {
                    map.put(sum, i);
                }
            }
            // System.out.println(max);
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {2,7,6,1,4,5};
        System.out.println(m(arr, 5));
    }
}
