package DSA_05_LinkedList.Practice_05;

public class P_09_ReorderList {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // 
    static ListNode reverse(ListNode head) {
        if (head==null || head.next==null) return head;

        ListNode p = null;
        ListNode c = head;
        ListNode n = null;

        while (c!=null) {
            n = c.next;

            c.next = p;

            p = c;
            c = n;
        }

        return p;
    }

    static ListNode middlePoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next.next; //as nor middile return (int) n/2  +1.

        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    static void m1(ListNode head) {
        if (head==null || head.next==null) return ;
        
        ListNode middle = middlePoint(head);
        ListNode revHead = middle.next.next;

        middle.next = null;
        revHead = reverse(revHead);

        ListNode nHead = head;
        while (revHead!=null) {
            ListNode to = nHead.next;
            nHead.next = revHead;
            revHead = revHead.next;
            nHead.next.next = to;
            nHead = to;
        }

    }

    // m2
    static void m2(ListNode head) {

        // dp
        if (head==null || head.next==null || head.next.next==null) {
            return;
        }

        // middle point
        ListNode middleNode = head;
        ListNode endNode = head;
        while (endNode.next!=null && endNode.next.next!=null) {
            middleNode = middleNode.next;
            endNode = endNode.next.next;
        } 

        // reverse from middleNode+1
        endNode = null;
        // ListNode previousNode = null;
        ListNode currentNode = middleNode.next;
        while (currentNode!=null) {
            ListNode nextNode = currentNode.next;

            currentNode.next = endNode;
            // currentNode.next = previousNode;

            endNode = currentNode;
            // previousNode = currentNode;
            currentNode = nextNode;
        }

        // reorder
        ListNode mainNode = head;
        ListNode subNode = endNode;
        while (mainNode!=middleNode) {
            ListNode mNn = mainNode.next;
            ListNode sNn = subNode.next;

            mainNode.next = subNode;
            subNode.next = mNn;

            mainNode = mNn;
            subNode = sNn;
        }
        // eception in case of odd to avoid loop
        if (subNode==null) {
            mainNode.next=null;
        }





    }
    public static void main(String[] args) {
        
    }
}
