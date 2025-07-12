package DSA_05_LinkedList.Practice_05;

public class P_18_RearrangeAGivenLL {
    
    // m2
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    static Node getMiddle(Node head) {
        if (head==null || head.next==null) return head;
        Node slow = head;
        Node fast = head;
        while (fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static Node reverse(Node head) {
        Node previousNode = null;
        Node currentNode = head;
        while (currentNode!=null) {
            Node nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
        return head;
    }
    static void m2(Node head) {
        Node middleNode = getMiddle(head);
        Node middleNextNode = middleNode.next;
        middleNode.next = null;
        Node revHead = reverse(middleNextNode);

        Node pointer = head;
        while (pointer!=null && revHead!=null) {
            Node pn = pointer.next;
            Node rhn = revHead.next;

            pointer.next = revHead;
            revHead.next = pn;

            revHead = rhn;
            pointer = pn;
        }
    }

    public static void main(String[] args) {
        
        // m1 use recursion to iterate reverse manner 

        // m2 split ll into two along mid point then reverse second half do alternate merge
    }
}
