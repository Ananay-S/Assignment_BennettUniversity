package DSA_05_Sort_Search.Practice_05;

import java.util.Arrays;

public class P_13_RadixSort {

    // radix sort
    static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i : arr) max = Math.max(max, i);
        return max;
    }
    static void countSort(int[] arr, int n, int exp) {
        int[] temp = new int[n];


        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i : arr) { // get count of digits at exp th place
            count[(i/exp)%10]++;
        }
        for (int i = 0; i < 10; i++) { // gettin position of that digit by skipping index for the previous digits
            count[i] += count[i-1]; 
        }
        for (int i = n-1; i >= 0; i--) { // building temp
            count[(arr[i]/exp)%10]--;
            temp[count[(arr[i]/exp)%10]] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
    static void radixSort(int arr[], int n) {
        int max = getMax(arr, n);
        for (int i = 1; max/i > 0; i*=10) { // i=exponent traversing digits of maximun value
            countSort(arr, n, i);
        }
    }
    public static void main(String[] args) {
        // n* max(no.of digits+base of number system)
    }
}
