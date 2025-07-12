package DSA_04_Arrays.Practice_04;

/**
 * P_15_FindPairWithSumInRotatedSortedArray
 */
public class P_15_FindPairWithSumInRotatedSortedArray {

    // m1
    static boolean m1(int arr[], int x) {
        int n = arr.length;
        // piviot
        int i;
        for (i = 1; i < n; i++) {
            if (arr[i-1] > arr[i]) {
                break;
            }
        }

        // two pointer (+ - with % as rotatted sorted array)
        int l = i;
        int h = (i-1)%n;
        while (l!=h) {
            if (arr[l] + arr[h] == x) {
                return true;
            }
            // 2 pointer algo (if sum< low ko high, if sum> high ko low)
            if (arr[l] + arr[h] < x) {
                l = (l+1)%n;
            } else {
                h = (h-1+n)%n;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        
        // m1 (piviot and two pointer)
        // time(n);
        // space(1);

        // 
        // roataed sorted array pivot index
        // distint values
    }
}