package DSA_05_LinkedList.Practice_05;

public class P_15_DeleteNodeWhichHaveGreaterValueOnRightSide {
    
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // m2
    static void reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr!=null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    static void m2(Node head) {
        reverse(head);
        Node pointer = head;
        int max = head.data;
        while (pointer!=null && pointer.next!=null) {
            if (pointer.next.data<max) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
                max = pointer.data;
            }
        } 
        reverse(head);
    }
    // m3
    static Node m3(Node head) {
        if (head==null || head.next==null) return head;

        Node next = m3(head.next);

        if (next.data>head.data) return next;

        head.next = next;
        return head;
    }
    public static void main(String[] args) {
        // // m1
        // time O(n^2)
        // space O(1)

        // m2 reverse ll
        // time O(n)
        // space O(1)

        // m3 recursive (reverse traversal)
        // time O(n)
        // space O(n)
    }
}
