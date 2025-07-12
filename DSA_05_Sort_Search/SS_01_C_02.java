package DSA_05_Sort_Search;

// BINARY SEARCH

public class SS_01_C_02 {

    // m1 iterative
    static int binarySearchI(int arr[], int key) {
        int low = 0, high = arr.length-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if (arr[mid]==key) {
                return mid;
            } else if (arr[mid]<key) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    // m2 recursive
    static int binarySearchR(int arr[], int key, int low, int high) {
        if (low>high) return -1;
        int mid = (low+high)/2;
        if (arr[mid]==key) {
            return mid;
        } else if (arr[mid]<key) {
            return binarySearchR(arr, key, mid+1, high);
        } else {
            return binarySearchR(arr, key, low, mid-1);
        }
    }

    public static void main(String[] args) {
        
        // binary search (Sorted array/contiguous allotment)
        // mid = low + (high-low)/2 = (low+high)/2;
        // if mid = key return key
        // if key>a[mid] or key<a[mid]
        
        int arr[] = {1,4,6,8};
        // m1 iterative
        // time O(log2(n))
        // space O(1)
        System.out.println(binarySearchI(arr, 2));
        // m2 recursive
        // time O(log2(n))
        // space O(log2(n))
        System.out.println(binarySearchR(arr, 8, 0, arr.length));
    }
}

// s1 concept
// s2 implementation iterative recursive
// s3 complexity analysis

// logarithm
// n/(2^k) = 1
// n = 2^k
// log2(n) = k