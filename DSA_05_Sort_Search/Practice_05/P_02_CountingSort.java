package DSA_05_Sort_Search.Practice_05;

public class P_02_CountingSort {
    
    // counting sort
    static int[] countSort(int arr[]) {
        int n = arr.length;

        int m = 0;
        // get length
        for (int i : arr) {
            m = Math.max(m, i);
        }
        // initialise count array
        int countArr[] = new int[m+1];
        // get frequency
        // for (int i = 0; i < n; i++) {
        //     countArr[arr[i]]++;
        // }
        for (int i : arr) {
            countArr[i]++;
        }
        // update prefix sum
        for (int i = 1; i < m+1; i++) {
            countArr[i] += countArr[i-1];
        }

        // output array
        int outputArr[] = new int[n];
        for (int i = n-1; i >= 0; i--) {
            countArr[arr[i]]--;
            outputArr[countArr[arr[i]]] = arr[i]; 
        }

        return outputArr;
    }
    public static void main(String[] args) {
        
        // Counting sort
        int[] inputArray = {4, 3, 12, 1, 5, 5, 3, 9};
        int[] outputArray = countSort(inputArray);
 
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(outputArray[i] + " ");
        }
    }
}
