package DSA_04_Arrays.Practice_04;

/**
 * P_06_SearchInRotatedArray
 */
public class P_06_SearchInRotatedArray {

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        

        // m1 (normally)
        // time: O(n)
        // space: O(1)

        // m2 (advantage sorted) two pointers
        // time: O(logn)
        // space: O(1)


        
    }
}