package DSA_04_Arrays.Practice_04;

public class P_07_NextPermutation {
    

    // m
        // swap 
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
        // reverse
    static void reverse(int[] arr, int i) { // i start j end
        int j = arr.length-1;
        while(i<j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    // next permutation
    public void nextPermutation(int[] nums) {
        int i1 = -1; // index
        int i2 = -1; // index

        // step-1 
        // find breaking point (in descending order from end).
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                i1=i;
                break;
            }
        }

        // step-2 
        // if there is no breaking point, means nums is in descending order and last permutation so fisrt permutation is ascending order. 
        if(i1==-1){
            reverse(nums,0);
        } else { // step-3 find next greater element, as nums is descending right to the right of i1 so we will find next greater elment from the first occurance from the end. 
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]>nums[i1]){
                    i2=i;
                    break;
                }
            }
            // step-4 swap i1 with i2 
            swap(nums,i1,i2);
            // step-5 reverse the nums to the right of i1
            reverse(nums,i1+1);
        }
    }
    
    public static void main(String[] args) {
        
        // m 
        // time O(n + n + n)
        // space O(1)

    }
}
