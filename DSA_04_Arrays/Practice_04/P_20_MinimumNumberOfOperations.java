package DSA_04_Arrays.Practice_04;

public class P_20_MinimumNumberOfOperations {
    
    // m1 two pointer
    static int m(int arr[], int n) {
        int count = 0;

        for (int i = 0, j = n-1; i <= j; ) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else if (arr[i] < arr[j]) {
                i++;
                arr[i] += arr[i-1];
                count++;
            } else {
                j--;
                arr[j] = arr[j+1];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        
        // Find minimum number of merge operations to make an array palindrome
        int arr[] = {1,45,6,8,1};
        System.out.println(m(arr, arr.length));
    }
}
