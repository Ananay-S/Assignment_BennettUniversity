package DSA_05_Sort_Search.Practice_05;

public class P_04_SearchInArrayWhereAdjacentDiffer {
    
    // m1
    static int m1(int[] arr, int n, int x, int k) {
        int i=0;
        while (i<n) {
            if (arr[i]==x) return i;
            i += Math.max(1, Math.abs(arr[i]-x)/k); //minimum no. of steps
        }
        return-1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 5, 7, 7, 6 }; 
        int x = 4; 
        int k = 2; 
        int n = arr.length; 
        System.out.println(m1(arr, n, x, k));
    }
    // Q searching in an array where adjacent differ by at most k
}
