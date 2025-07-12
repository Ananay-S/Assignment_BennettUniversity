package DSA_09_Heap.Practice_09;

public class P_05_FindMaximumRepeatingNumbers {
    
    // m3 using %k +=k index to store index 
    class MaxRepeating {
 
        // Returns maximum repeating element in arr[0..n-1].
        // The array elements are in range from 0 to k-1 and k<=n
        static int maxRepeating(int arr[], int n, int k)
        {
            // Iterate though input array, for every element
            // arr[i], increment arr[arr[i]%k] by k
            for (int i = 0; i< n; i++)
                arr[(arr[i]%k)] += k;
     
            // Find index of the maximum repeating element
            int max = arr[0], result = 0;
            for (int i = 1; i < n; i++)
            {
                if (arr[i] > max)
                {
                    max = arr[i];
                    result = i;
                }
            }
     
            /* Uncomment this code to get the original array back
            for (int i = 0; i< n; i++)
              arr[i] = arr[i]%k; */
     
            // Return index of the maximum element
            return result;
        }
    public static void main(String[] args) {
        
        
        // time O(n)
        // space O(1)

        // m1 brute force
        // time O(n^2)
        // space O(1)

        // m2 boyer-moore majpority voting algorithm
        // time O(2n)
        // space O(1)

        // m3 index (modify array)
        // time O(n)
        // space O(1)
    }
}
