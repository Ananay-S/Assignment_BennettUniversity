package DSA_04_Arrays;

public class A_03_Q_02 {

    public static void main(String[] args) {
        
        // maximum sum subarray (kadane's algorithm)

        int arr[] = {5,-4,-2,-6,-1};

        int currentSum = 0;
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        System.out.println("Maximum Sum: " + maxSum);
    }
}