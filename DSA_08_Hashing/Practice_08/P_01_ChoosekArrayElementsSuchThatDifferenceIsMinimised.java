package DSA_08_Hashing.Practice_08;

import java.util.Arrays;

public class P_01_ChoosekArrayElementsSuchThatDifferenceIsMinimised {
    

    // m1
    static int m1(int[] arr, int k) {
        Arrays.sort(arr);
        int min = arr[k-1]-arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.max(min, (arr[i+k-1]-arr[i]));
        }
        return min;
    }
    public static void main(String[] args) {
        // minminmum and maximum

        // m1
        // sort array
        // traverse with k distance 
    }
}
