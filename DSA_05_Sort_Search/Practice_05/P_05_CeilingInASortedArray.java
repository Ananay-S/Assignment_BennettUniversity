package DSA_05_Sort_Search.Practice_05;

public class P_05_CeilingInASortedArray {
    
    // m1
    static int ceil_m1(int[] arr, int x) {
        if (x<=arr[0]) return 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==x) return i;
            if (arr[i]<x && x<= arr[i+1]) return i+1;
        }

        return -1;
    }

    // m2 (or recursive)
    static int ceil_m2(int[] arr, int x) {
        if (x<=arr[0]) return 0;
        if (x>arr[arr.length-1]) return -1;

        int low = 0;
        int high = arr.length;
        while (low<high) {
            int mid = (low+high)/2;
            if (arr[mid]<x) {
                if ((mid+1<=high)&&(x<=arr[mid+1])) return mid+1;
                low = mid+1;
            } else if (arr[mid]>x) {
                if (((mid-1)>=low)&&(x>arr[mid-1])) return mid;
                high = mid-1; 
            } else { //(arr[mid]==x)
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Q ceil and floor of x in in sorted array

        // m1 linear search
        // time O(n)
        // space O(1)

        // m2 binary search
        // time O(log(n))
        // space O(1)
    }
}
