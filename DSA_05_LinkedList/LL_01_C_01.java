package DSA_05_LinkedList;

import java.util.HashSet;

/**
 * LL_01_C_01
 */
public class LL_01_C_01 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // 
    static ListNode m1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while (!set.contains(head)) {
            set.add(head);
            head = head.next;
        }

        return head;
    }
    // 
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
    // start
    static ListNode ms(ListNode head) {
        ListNode meet = m2(head);
        if (meet==null) return null;

        ListNode start = head;

        while (start!=meet) {
            start = start.next;
            meet = meet.next;
        }

        return start;
    }

    static void md(ListNode head) {
        ListNode start = ms(head);
        if (start==null) return;

        ListNode end = start;

        while (end.next != start) {
            end = end.next;
        }

        end.next = null;
    }
        
    public static void main(String[] args) {
        
        // C1) Detect & Remove Cycle in a Linked List
        // brute force hashset space O(n) 

        // Floyd's cycle detection algorithm space O(1)
        // concept slow(+=1) fast(+=2) (slow==fast) or (fast==null)
        // Ds*2 = Df
        // find node of start of cycle
        // (a + m(b+c) + b)*2 = (a + n(b+c) + b) => a+b = (n-m)(b+c) => a = K(b+c) + c
        // while(head++ != (s==f)++)
        // delete cycle

    }
}