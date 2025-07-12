package DSA_09_Heap;

public class H_01_C_01 {
    
    // insert in max heap
    static void insertHeapM(int arr[], int value) {
        int i = arr.length+1;
        arr[i] = value;
        while (i>1) {
            int p = i/2; // parent
            if (arr[p]<arr[i]) {
                // swap(arr, p, i);
                i = p;
            } else {
                return;
            }
        }
    }
    // delete in max heap
    static void deleteHeapM(int arr[]) {
        int n = arr.length;
        arr[1] = arr[n-1];
        n = n-1;
        int i = 1;
        while (i<n) {
            int left = arr[2*i];
            int right = arr[2*i+1];
            int maxChild = (left>right) ? 2*i : 2*i+1;
            if (arr[i]<arr[maxChild]) {
                // swap(arr, i, maxChild);
                i = maxChild;
            } else {
                return;
            }

        }
    }

    // heapify O(n)
    static void buildHeap(int arr[], int n) {
        for (int i = n/2; i > 0; i--) {
            heapify(arr, n, i);
        }
    }
    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2*i;
        int r = 2*i + 1;
        if ((l<=n)&&(arr[l]>arr[largest])) {
            largest = l;
        } 
        if ((l<=n)&&(arr[r]>arr[largest])) {
           largest = r;
        } 
        if (largest!=i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }

    }
    
    // heapsort
    static void heapSort(int arr[], int n) {
        for (int i = n; i > 1; i--) {
            // swap(arr, 1, i);
            heapify(arr, i-1, i);
        }
    }
    public static void main(String[] args) {
        
        // heap: a complete binary tree that satisfies a heap's property
        // complete two children or zero at leaf node or left node. 
        // (only for complete bt height always equals logn)
        // max heap: children values < parent value
        // min heap: children values > parent value

        // for complete (filled in order 's1) both null s2) only left s3) both left and right')
        // parent -> left -> right
        // fill array from 1st index skiping 0th index
        // then for node i
        // parent(i): Math.floor(i/2)
        // left(i): 2*i
        // right(i): 2*i+1

        // pseudo code not checking for length of array static not dynmic or for null nodes
        // insert in max heap logn
        // add node at the end then compare with parent and swap 

        // delete in max heap logn
        // delete node and replace with last node then compare with childern and swap

        // leaf node start fron [n/2]+1 to n

        // heap sort delete root node and call heapify O(n+log(n))

    }
}
