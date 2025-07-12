package DSA_05_Sort_Search.Practice_05;

import java.util.Arrays;

public class P_14_ProductOfArrayExcepetitself {
    

    // m3
    static void m3(int[] arr, int n) {
        if (n==1) {
            System.out.println(0);
            return;
        }
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] product = new int[n];
        prefix[0] = 1;
        suffix[n-1] = 1; 
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]*arr[i-1];
        }
        for (int i = n-2; i >= 0; i--) {
            suffix[i] =  suffix[i+1]*arr[i+1];
        }

        for (int i = 0; i < n; i++) {
            product[i] = prefix[i]*suffix[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(product[i]+" ");
        }

        return;
    }

    static void m3_(int[] arr, int n) {
        if (n==1) {
            System.out.println(0);
            return;
        }
        int[] product = new int[n];
        Arrays.fill(product, 1);
        
        int temp=1;
        for (int i = 0; i < n; i++) {
            product[i] = temp;
            temp *= arr[i];
        }
        temp=1;
        for (int i = n-1; i >= 0; i--) {
            product[i] *= temp;
            temp *= arr[i];
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(product[i]+" ");
        }

        return;
    } 
    public static void main(String[] args) {
        
        // m1 brute force
        
        // m2 total product divided by itself exception handle 0 and negative

        // m3 preffix suffix pre processing


    }
}
