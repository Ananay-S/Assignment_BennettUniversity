package DSA_04_Arrays.Practice_04;

/**
 * P_03_MaximumSubarray
 */
public class P_03_MaximumSubarray {

    // m1 (brute force)
    static int m1(int arr[]) {
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                sum += arr[j];
                maxSum = (sum > maxSum) ? sum : maxSum;
                // System.out.println(i+" "+j+" "+sum+" "+maxSum);
            }
        }
        return maxSum;
    }

    // m2 kadane's algorithm
    static int m2(int arr[]) {
        int currentSum = 0;
        int maxSum = 0;

        // for (int i = 0; i < arr.length; i++) {
        //     currentSum += arr[i];
        //     if (currentSum > maxSum) {
        //         maxSum = currentSum;
        //     }
        //     if (currentSum < 0) {
        //         currentSum = 0;
        //     }
        // }

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            maxSum = (currentSum > maxSum) ? currentSum : maxSum;
            if (currentSum < 0) currentSum = 0;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};

        // m1 (brute force)
        // time: O(n^2)
        // space: O(1)
        System.out.println("max sum: "+ m1(arr));
        // m2 kadane's algorithm
        // time: O(n)
        // space: O(1)
        System.out.println("max sum: "+ m2(arr));
    }
}