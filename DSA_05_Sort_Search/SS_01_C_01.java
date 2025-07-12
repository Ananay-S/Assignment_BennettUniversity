package DSA_05_Sort_Search;

// SORT
public class SS_01_C_01 {
    
    // print array
    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        } System.out.println();
    }

    // swap
    static int[] swap (int[] arr, int i1, int i2) {
        arr[i1] ^= arr[i2];
        arr[i2] ^= arr[i1];
        arr[i1] ^= arr[i2];
        
        // arr[i1] = arr[i1] + arr[i2];
        // arr[i2] = arr[i1] - arr[i2];
        // arr[i1] = arr[i1] - arr[i2];

        // above both fail for same index so put a if 
        return arr;
    }

    // bubble sort (optimaisation boolean swapped)
    static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n-1-i; j++) {
                if (arr[j+1] < arr[j]) {
                    swap(arr, j+1, j);
                    swapped = true;
                }
            }
            if (!swapped) { // optimisation as already sorted
                break;
            }
        }
        return arr;
    }

    // insertion sort
    static int[] insertionSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 1; i < n; i++) {
            temp = arr[i];
            int j;
            for (j = i-1; j >= 0 && arr[j]>temp; j--) {
                arr[j+1] = arr[j];
            } arr[j+1] = temp; 
        }
        return arr;
    }

    // selection sort
    static int[] selectionSort(int[] arr) {
        int n = arr.length;
        int min;
        for (int i = 0; i < n-1; i++) {
            min = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, min, i);
            }
        }
        return arr;
    }

    // quick sort
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        System.out.println(pivot);
        int i = low-1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
               i++;
               if (i != j)
               arr = swap(arr, i, j); 
            }
        }
        printArray(arr);
        i++;
        if (i != high) 
            swap(arr, i, high);
        printArray(arr);

        return i;
    }
    static void quickSort(int arr[], int low, int high) {
        if (low<high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    // merge sort
    public static void conquer(int[] arr, int si, int mi, int ei) { //O(n)
        int[] temp = new int[ei-si+1];
        int it = 0;

        int i1 = si;
        int i2 = mi+1;

        while(i1<=mi && i2<=ei) {
            if(arr[i1]<arr[i2]) {
                temp[it++] = arr[i1++];
            } else {
                temp[it++] = arr[i2++];
            }
        }
        while(i1<=mi) {
            temp[it++] = arr[i1++];
        }
        while(i2<=ei) {
            temp[it++] = arr[i2++];
        }

        for(int i=si, j=0; j<temp.length; i++, j++) {
            arr[i] = temp[j];
        }

    }
    public static void divide(int[] arr, int si, int ei) { //O(logn) 
        if(si >= ei) {
            return ;
        }
        int mi = si + (ei-si)/2;
        divide(arr, si, mi);
        divide(arr, mi+1, ei);

        conquer(arr,si, mi, ei);
    }
    public static void main(String[] args) {
        
        int[] arr = {4,3,7,1,5};
        System.out.println("array: ");
        printArray(arr);

        // bubble sort 
        System.out.println("bubble: ");
        // printArray(bubbleSort(arr));

        // insertion sort
        System.out.println("insertion sort: ");
        // printArray(insertionSort(arr));

        // selection sort
        System.out.println("selection sort: ");
        // printArray(selectionSort(arr));

        // quick sort
        System.out.println("quick sort: ");
        // quickSort(arr, 0, arr.length-1);
        // printArray(arr);

        // merge sort
        System.out.println("merge sort: ");


    }
}
