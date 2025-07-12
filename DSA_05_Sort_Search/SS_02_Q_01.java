package DSA_05_Sort_Search;

public class SS_02_Q_01 {
    
    // A1
    static int binarySearchI(int arr[], int key, int low, int high) {
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
    static int searchInfinite(int arr[], int key) {
        int low = 0;
        int high = 1;
        while (arr[high]<key) {
            low = high;
            high = high*2;
        }
        return binarySearchI(arr, key, low, high);
    }

    // A2
    static int searchRotated(int arr[], int key) {
        int low=0, high=arr.length-1;

        while (low<high) {
            int mid = (low+high)/2;

            if (arr[mid]==key) return mid;

            if (arr[low]<arr[mid]) { // left side sorted
                if ((arr[low]<=key)&&(key<arr[mid]) ) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else { // right side sorted
                if ((arr[mid]<key)&&(key<=arr[high])) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }

        return -1;
    }

    // A3
    static int maxOfArray(int arr[]) {
        int max=0;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }
    static int sumOfArray(int arr[]) {
        int sum=0;
        for (int i : arr) {
            sum+=i;
        }
        return sum;
    }
    static boolean isFeasible(int arr[], int k, int result) {
        int student=1, sum=0;
        for (int i = 0; i < arr.length; i++) {
            if ((sum+arr[i])>result) {
                student++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return (student<=k);
    }
    static int minPages(int arr[], int k) {
        // range of min pages (max pages, total pages)
        int min = maxOfArray(arr);
        int max = sumOfArray(arr);
        int result = 0;

        while (min<=max) {
            int mid = (min+max)/2;
            if (isFeasible(arr, k, mid)) {
                result = mid;
                max = mid-1;
            } else {
                min = mid+1;
            }
        }

        return result;
    }
    
    
    public static void main(String[] args) {
        
        // Q1 Search an element in an infinite sorted array.
        // problems to overcome:
        // array.length not possible as infinite array time limit exceeded.
        // do not have high for binary search
        // concept of skiping numbers in range
        // from constant(2) range to exponential(2^k) range
        
        // time O(log2(n)+log2(n))
        // space O(1)

        // Q2 Search in sorted rotated array
        // before rotation as the whole array is sorted thus same if else an be applied
        // after rotation about the pivot only one side of the mid is sorted (think)
        // so select the sorted side and check if the key exist, else it exist on the other side 
        // (there's no way tho check if the key exist on side containing pivot directly so 'else' is used)

        // time O(log2(n))
        // space O(1)

        // Q3 Books allocation (mininise the maximum number of pages read by a student)
        // (allot books in a contiguous fashion and each book is read by a student alone)
        // array of no. of pages in each book to be distributed among k students

        // time O(2n + log2(n)*n)
        // space O(1)
    }
}
