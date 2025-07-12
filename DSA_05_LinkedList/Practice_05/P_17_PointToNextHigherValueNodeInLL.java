package DSA_05_LinkedList.Practice_05;


public class P_17_PointToNextHigherValueNodeInLL {
    
    // m2
    static class node {
        int val;
        node next;
        public node(int val) {
            this.val = val;
        }
    }
    static node getMiddle(node head) {
        if (head==null || head.next==null) return head;
        node slow=head, fast=head;
        while (fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static node sortedMerge(node a, node b) {
        
        if (a==null) return b;
        if (b==null) return a;

        node result = null;
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
    static node mergeSort(node head) {
        if (head==null || head.next==null) return head;

        node middle = getMiddle(head);
        node middleNext = middle.next;
        middle.next = null;

        node left = mergeSort(middle);
        node right = mergeSort(middleNext);

        return sortedMerge(left, right);
    }
    public static void main(String[] args) {
        
        // m1 brute 
        // time O(n^2)
        // space O(1)

        // m2 merge sort for linked list (arbitrary pointer)
        // time O(nlogn)
        // space O(n)
    }
}
