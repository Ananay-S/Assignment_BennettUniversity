package DSA_09_Heap.Practice_09;

import java.util.PriorityQueue;

public class P_06_FindKClosestElementToGivenValue {
    
    // m1
    static void m1(int[] arr, int x, int k) {
        int n = arr.length;

        // find x index
        int low = 0, high = n-1;
        int mid=0;
        while (low<high) {
            mid = (low+high)/2;
            if (arr[mid]<x) {
                low=mid+1;
            } else if (arr[mid]>x) {
                high=mid-1;
            } else {
                break;   
            }
        }
        // 
        int left = mid-1, right = mid+1;
        int count=0;
        while (left>=0 && right<=n-1 && count<k) {
            if ((x-arr[left]<arr[right]-x)) {
                System.out.println(arr[left--]+" ");
            } else {
                System.out.println(arr[right++]+" ");
            }
            count++;
        }
        while (count<k && left>=0) {
            System.out.println(arr[left--]+" ");
            count++;
        }
        while (count<k && right<n) {
            System.out.println(arr[right++]+" ");
            count++;
        }
    }
    // m2
    static class Pair implements Comparable<Pair> {
        int absDiff;
        int ind;
        Pair(int f, int s)
        {
            absDiff = f;
            ind = s;
        }
        public int compareTo(GFG.Pair o)
        {
            // If there are two elements with the same
            // difference with X, the greater element is
            // given priority.
            if (absDiff == o.absDiff)
                return ind - o.ind;
            else
                return o.absDiff - absDiff;
        }
    }
    static int[] printKClosest(int[] nums, int n, int k,
                               int x)
    {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = Math.abs(nums[i] - x);
          //if nums[i] == x then no need to consider that element
            if (diff != 0)
                maxHeap.add(new Pair(diff, i));
          //if maxheap size exceeds k then remove the element with maximum absolute difference
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        int ans[] = new int[k];
        int j = 0;
        while (!maxHeap.isEmpty()) {
          //Add the remaining elements to the answer
            ans[j] = nums[maxHeap.poll().ind];
            j++;
        }
      // reverse the array to get elements closest elements in ascending order
        for (int i = 0; i < k / 2; i++) {
            int t = ans[i];
            ans[i] = ans[k - i - 1];
            ans[k - i - 1] = t;
        }
        return ans;
    }

    // m3
    static void m3(int[] arr, int x, int k) {
        int n = arr.length;

        int left = 0, right = n-1;

        while (left-right >= k+1) {
            if (Math.abs(arr[left]-x) > Math.abs(arr[right]-x)) {
                left++;
            } else {
                right--;
            }
        }

        while (left<=right) {
            if (arr[left]!=x) System.out.println(arr[left]+" ");
            left++;
        }

    }
    public static void main(String[] args) {
        // int k and x
        // sorted array

        // m1 bs+comparision
        // time O(logn + k)
        // space O(1)

        // m2 priority queue
        // time O(n logk)
        // space O(k)

        // m3 two pointer 
        // time O(n)
        // space O(1)

    }
}
