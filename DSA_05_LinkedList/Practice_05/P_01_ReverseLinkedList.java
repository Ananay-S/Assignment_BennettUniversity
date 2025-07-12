package DSA_05_LinkedList.Practice_05;

/**
 * P_01_ReverseLinkedList
 */
public class P_01_ReverseLinkedList {

    public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
    // m1 iteratively
    static ListNode m1(ListNode head) {
        ListNode previousNode = null;
        ListNode currentNode = head;
        while (currentNode!=null) {
            ListNode nextNode = currentNode.next;

            currentNode.next = previousNode;

            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }
    static ListNode m11(ListNode head) {
        ListNode node = null;
        
        while (head!=null) {
            ListNode temp = head.next;

            head.next = node;

            node = head;
            head = temp;
        }
        return node;
    }

    // m2 recursive 
    static ListNode m2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = m2(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
    public static void main(String[] args) {
        
    }
}