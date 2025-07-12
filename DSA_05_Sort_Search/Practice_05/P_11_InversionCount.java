package DSA_05_Sort_Search.Practice_05;

public class P_11_InversionCount {
    
    // m1
    

    // m2 
    public static int conquer(int[] arr, int si, int mi, int ei) { //O(n)
        int count = 0; 
        int[] temp = new int[ei-si+1];
        int it = 0;

        int i1 = si;
        int i2 = mi+1;

        while(i1<=mi && i2<=ei) {
            if(arr[i1]<arr[i2]) {
                temp[it++] = arr[i1++];
            } else { // move element from right towards left so count + by mid idx - current first idx
                temp[it++] = arr[i2++];
                count += (mi-i1);
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
    public static int divide(int[] arr, int si, int ei) { //O(logn) 
        // if(si >= ei) {
        //     return ;
        // }
        int count = 0;
        if (si<ei) {
            int mi = si + (ei-si)/2;
            count += divide(arr, si, mi);
            count += divide(arr, mi+1, ei);

            count += conquer(arr,si, mi, ei);
        }
        return count;
    }
    public static void main(String[] args) {
        //two array elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.
        // skip
        // m1 brute force
        // m2 count while merge sort space used by stack memory
    }
}
