package DSA_08_Hashing.Practice_08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_02_TopkFrequentElements {

    // m1
    static int[] m1(int[] arr, int k) {
        // hashmap
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        // heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int key : map.keySet()) {
            maxHeap.add(key);
        }
        // result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        // return
        return result;
    }
    // m2
    static int[] m2(int[] arr, int k) {
        // hashmap
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // 
        List<Integer> bucket[] = new ArrayList[arr.length + 1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int res[] = new int[k];
        int index = 0;
        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(int val : bucket[i]){
                    res[index++] = val;
                    if(index == k) return res;
                }
            }
        }
        return res;

    }

    // m3 
    
    // public int[] topKFrequent(int[] nums, int k) {
    //     Map<Integer, Integer> map = new HashMap<>(nums.length, 1.0f);
    //     for (int val : nums) {
    //         map.merge(val, 1, Integer::sum);
    //     }
    //     Map<Integer, List<Integer>> reverseMap = new HashMap<>();
    //     int maxFreq = 0;
    //     for (Map.Entry<Integer, Integer> e : map.entrySet()) {
    //         int val = e.getKey(), freq = e.getValue();
    //         reverseMap.computeIfAbsent(freq, x -> new ArrayList<>()).add(val);
    //         maxFreq = Math.max(maxFreq, freq);
    //     }
    //     int[] res = new int[k];
    //     for (int i = maxFreq, j = 0; i > 0 && j < k; i--) {
    //         List<Integer> list = reverseMap.get(i);
    //         if (list != null) {
    //             for (int x = 0; x < list.size() && j < k; x++, j++) {
    //                 res[j] = list.get(x);
    //             }
    //         }
    //     }
    //     return res;
    // }
    public static void main(String[] args) {
        
        // m1 
        // hashmap (value, frequency) 
        // maxheap (based on frequency)
        // add elements to result[] peek until k

        // m2 bucket sorting or bin sort (array of bucket)
        // hashmap (value, frequency) 
        // array (index=frequency)
        // traverse backwards
        // time O(klogd)
        // space O(d)

        // m3
        // hashmap (value, frequency) 
        // reverse hash map 
        // reverse iterate for max frequency
        // time O(n)
        // space O(n)

    }    
}