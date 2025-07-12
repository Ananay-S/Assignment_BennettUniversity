package DSA_04_Arrays.Practice_04;

import java.util.Arrays;

public class P_24_PrintAllPossibleCombinationOfrElements {

    static void m1(int arr[], int k) {
        Arrays.sort(arr);
        int data[] = new int[k];
        mr(arr, arr.length, data, 0, 0, k);
    }
    static void mr(int arr[], int n, int data[], int i, int j, int k) {
        // combination complete
        if (j == k) {
            printArray(data);
            return;
        }
        // invalid 
        if (i>=n) {
            return;
        }
        // 
        data[j] = arr[i];
        mr(arr, n, data, i+1, j+1, k);

        while ((i<(n-1))&&(arr[i] == arr[i+1])) i++; // remove duplicates
        mr(arr, n, data, i+1, j, k);
    }
    static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i+" ");
        }System.out.println();
    }
    public static void main(String[] args) {
        
        int arr[] = {1,1,2};
        // int idx[] = new int[3];
        // // m(arr, 0, 3, idx);
        // m(arr, 0, idx, 0, 3);

        m1(arr, 2);
    }
}
