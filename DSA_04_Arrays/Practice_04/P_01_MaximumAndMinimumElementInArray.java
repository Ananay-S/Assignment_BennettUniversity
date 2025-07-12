package DSA_04_Arrays.Practice_04;

import java.util.Arrays;

/**
 * P_01_MaximumAndMinimumElementInArray
 */
public class P_01_MaximumAndMinimumElementInArray {

    // m1
    static int[] m1(int arr[]) {
        int a[] = new int[2];
        for (int i : arr) {
            if (a[0] > i) {
                a[0] = i;
            }
            if (a[1] < i) {
                a[1] = i;
            }
        }
        return a;
    }
    
    // m2
    static int[] m2(int arr[]) {
        int a[] = new int[2];
        Arrays.sort(arr);
        a[0] = arr[0];
        a[1] = arr[arr.length-1];
        return a;
    }

    public static void main(String[] args) {
        
        int arr[] = {1,-2,3,-4,5};
        int a[];

        // m1 
        // time: O(n)
        // space: O(1)
        a = m1(arr);
        System.out.println(" min: "+ a[0]+ " max: "+ a[1]);

        // m2 
        // time: O(nlogn)
        // space: O(1)
        a = m2(arr);
        System.out.println(" min: "+ a[0]+ " max: "+ a[1]);
    }
}