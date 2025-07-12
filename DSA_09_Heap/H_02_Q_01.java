package DSA_09_Heap;

import java.util.PriorityQueue;

public class H_02_Q_01 {

    // A1
    static int kthLargest(int arr[], int k) {
        // min heap of length k then return the top element
        // for kthsmallest use max heap and add for '>' 
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (pq.peek()<arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
    
    // A2
    static int minCost(int arr[]) { // O(nlogn)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // O(nlog(n))
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int ans = 0;
        // O(3nlog(n))
        while (pq.size()>1) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first+second;
            ans+=sum;
            pq.add(sum);
        }
        return ans;
    }
    
    // A3
    class MedianOfStream {
        // time O(log(n))
        // space O(n)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(); // l
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // r
        public void insert(int num) {
            if ((maxHeap.isEmpty())||(max.peek()>=num)) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            if (maxHeap.size() > minHeap.size()+1) {
                minHeap.add(maxHeap.poll());
            } else {
                maxHeap.add(minHeap.poll());
            }
        }
        public double findMedian() {
            if (maxHeap.size()==minHeap.size()) {
                return (maxHeap.peek()+minHeap.peek())/2;
            } else {
                return maxHeap.peek();
            }
        }

    }
    
    public static void main(String[] args) {
        // default min heap
        // pass comparators for max heap Collections.reverseOrder()
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(15);
        pq.add(10);
        System.out.println(pq.size());
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.poll();
        }

        // Q1 kth largest element 

        // Q2 Connect N ropes with minimum cost 
        // cost of each connection is equal to the total of the two ropes

        // Q3 find median of running stream of integers
        // normal array bs (n^2) if we use sorting
        // l < x < r
        // time O(log(n))
        // space O(n)



    }
}