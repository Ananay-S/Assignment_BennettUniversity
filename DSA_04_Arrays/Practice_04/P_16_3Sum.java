package DSA_04_Arrays.Practice_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P_16_3Sum {
    
    // m2'
    // public List<List<Integer>> threeSum(int[] arr) {
    //     int n = arr.length;
    //     List<List<Integer>> out = new ArrayList<>();
    //     List<List<Integer>> in = new ArrayList<>();
    //     Arrays.sort(arr);

    //     for (int i = 0; i < n-2; i++) {
    //         in = twoSum(arr, -(arr[i]), i+1);
    //         for (List<Integer> element : in) {
    //             if (!element.isEmpty()) {
    //                 element.add(arr[i]);
    //                 if (!out.contains(element)) {
    //                     out.add(element);
    //                 }
    //             }
    //         }
            

    //     }
    //     return out;
    // }

    // static List<List<Integer>> twoSum (int arr[], int e, int i) {
    //     int j = arr.length - 1;
    //     List<List<Integer>> in = new ArrayList<>();
    //     List<Integer> element = new ArrayList<>();
    //     while (i<j) {
    //         if (arr[i]+arr[j] < e) {
    //             i++;
    //         } else if (arr[i]+arr[j] > e) {
    //             j--;
    //         } else {
    //             element.add(arr[i]);
    //             element.add(arr[j]);
    //         }
    //         if (!in.contains(element)) {
    //             in.add(element);
    //         }
    //         // in.add(element);
    //         element.clear();
    //     }
    //     return in;
    // }

    // m
    static public List<List<Integer>> threeSum(int[] arr) {

        Arrays.sort(arr);
        List<List<Integer>> output = new ArrayList<>();
        HashSet<List<Integer>> out = new HashSet<>();
        // List<Integer> input = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i!=0 && arr[i] == arr[i-1]) continue;
            int j = i+1;
            if (i+1 < j && arr[j] == arr[j-1]) continue;
            int k = arr.length-1;
            while (j<k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    // List<Integer> input = Arrays.asList(arr[i], arr[j], arr[k]);
                    out.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        output.addAll(out);
        return output;
    }
    

    public static void main(String[] args) {
        System.out.println("hi");
        int arr[] = {6865, 8921, 22468, 20392, 27390, 31530, 8847, 26964, 20505, 21692, 7535, 31540, 18233, 19549, 30152, 12717, 28032, 25526, 23414, 7868, 26691, 22744, 18960, 28208, 6250, 7192, 30569, 10775, 7450, 22557, 2909};
        // int arr[] = {1, 2, 3, 4, 5};
        List<List<Integer>> l= threeSum(arr);
        for (List<Integer> list : l) {
            for (Integer element : list) {
                System.out.print(element+" ");
            }System.out.println();
        }
        System.out.println("hello");
    }
}
