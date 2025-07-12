package DSA_04_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_03_A_01 {
    
    // m1 (brute force)
    static boolean m1(int arr[], int n) {
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            for (int j = i+1; j < n; j++) {
                sum += arr[j];
                for (int k = j+1; k < n; k++) {
                    sum += arr[k];
                    if (sum == 0) {
                        return true;
                    }
                    sum -= arr[k];
                }
                sum -= arr[j];
            }
            sum -= arr[i];
        }
        return false;
    }

    // m2 (two pointer)
    static boolean m2(int arr[], int n) {
        Arrays.sort(arr);
        for (int i = 0; i < n-2; i++) {
            if (twoSum(arr, -(arr[i]), i+1)) {
                return true;
            }
        }
        return false;
    }

    // static boolean twoSum(int arr[], int e, int i) {
    //     int j = arr.length - 1;
    //     while (i<j) {
    //         if (arr[i]+arr[j] < e) {
    //             i++;
    //         } else if (arr[i]+arr[j] > e) {
    //             j--;
    //         } else {
    //             return true;
    //         }
    //     }
    //     return false;
    // }


    // m2'
    public List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n-2; i++) {
            in = twoSum(arr, -(arr[i]), i+1);
            if (!in.isEmpty()) {
                in.add(arr[i]);
                if (!out.contains(in)) {
                    out.add(in);
                }
            }

        }
        return out;
    }

    static List<Integer> twoSum (int arr[], int e, int i) {
        int j = arr.length - 1;
        List<Integer> in = new ArrayList<>();
        while (i<j) {
            if (arr[i]+arr[j] < e) {
                i++;
            } else if (arr[i]+arr[j] > e) {
                j--;
            } else {
                in.add(arr[i]);
                in.add(arr[j]);
                return in;
            }
        }
        return in;
    }

    public static void main(String[] args) {
        
        // 1. Two Pointers Algorithm
        // use case: sorted array [methods: 2 pointer, binary search]


        // Q1 three sum problem (triplet with sum equal to 0).
        int arr[] = {0,-1,2,-3,1};
        // int arr[] = {1,2,3};

        // m1 (brute force) 
        // time: O(n^3)
        // space: O(1)
        System.out.println("m1: "+ m1(arr, arr.length));
        int arr1[] = {6865, 8921, 22468, 20392, 27390, 31530, 8847, 26964, 20505, 21692, 7535, 31540, 18233, 19549, 30152, 12717, 28032, 25526, 23414, 7868, 26691, 22744, 18960, 28208, 6250, 7192, 30569, 10775, 7450, 22557, 2909};
        System.out.println("m1: "+m1(arr1, arr1.length));
        System.out.println();

        // m2 (two pointer)
        System.out.println("m2: "+ m2(arr, arr.length));
        System.out.println();



    }
}
