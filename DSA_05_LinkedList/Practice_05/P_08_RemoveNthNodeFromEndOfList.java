package DSA_05_LinkedList.Practice_05;

public class P_08_RemoveNthNodeFromEndOfList {
    
    public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
    
    // m2
    static ListNode m1(ListNode head, int n) {
        if (head.next==null) {
            return null;
        }
        
        ListNode pointerb = head;
        ListNode pointerf = head;
        int count = 1;

        while (pointerf!=null) {
            pointerf = pointerf.next;
            if (count<n) {
                count++;
            } else {
                pointerb = pointerb.next;
            }
        }

        if (count == n) {
            return head.next;
        }

        pointerb.next = pointerb.next.next;
        
        return head;
    }
    static ListNode m2(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) { //edge case
            return head.next;
        }
        while (fast.next!=null&&fast!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        
        // m1 two trversal
        // first find total length then node from start then maintain count

        // m2 two pointer
        // maintain two pointer at distance n
    }
}
