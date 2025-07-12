package DSA_05_LinkedList.Practice_05;

import java.util.HashSet;

public class P_02_LinkedListCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // m1
    static ListNode m1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while (!set.contains(head)) {
            set.add(head);
            head = head.next;
        }

        return head;
    }

    // m2
    static ListNode m2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }

        return fast;
    }
    
    public static void main(String[] args) {
        
    }
}
