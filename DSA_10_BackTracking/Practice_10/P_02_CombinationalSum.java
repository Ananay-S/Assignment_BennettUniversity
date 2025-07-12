package DSA_10_BackTracking.Practice_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class P_02_CombinationalSum {
    
    // m1
    static void findCombinations(ArrayList<Integer>arr, int x, int index,
                ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp) {
        // base case
        if (x==0) {
            list.add(new ArrayList<>(temp)); // adding copy
            return;
        }
        // 
        for (int i = index; i < arr.size(); i++) {
            int c = arr.get(i);
            if (x >= arr.get(i)) {
                temp.add(arr.get(i));
                findCombinations(arr, (x-arr.get(i)), i, list, temp);
                temp.remove(arr.get(i)); // backtracking
            }
        }
    
    }
    static ArrayList<ArrayList<Integer>> m1(ArrayList<Integer> arr, int x) {
        // 
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        // 
        HashSet<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        Collections.sort(arr);
        // 
        findCombinations(arr, x, 0, list, temp);;
        // 
        return list;
    }

    public static void main(String[] args) {
        
        // Given an array of positive integers arr[] and an integer x, The task is to find 
        //  all unique combinations in arr[] where the sum is equal to x. 

        // m1 backtracking
        ArrayList<Integer> arr = new ArrayList<>();
 
        arr.add(2);
        arr.add(4);
        arr.add(6);
        arr.add(8);
 
        int sum = 8;
 
        ArrayList<ArrayList<Integer>> result = m1(arr, sum);
 
        // If result is empty, then
        if (result.size() == 0) {
            System.out.println("Empty");
            return;
        }
 
        // print all combinations stored in ans
 
        for (int i = 0; i < result.size(); i++) {
 
            System.out.print("(");
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.print(") ");
        }
    }
}
