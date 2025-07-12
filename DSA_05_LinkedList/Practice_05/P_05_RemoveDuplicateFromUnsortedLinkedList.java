package DSA_05_LinkedList.Practice_05;

import java.util.HashSet;

public class P_05_RemoveDuplicateFromUnsortedLinkedList {
    
    static class Node {
        int val;
        Node next;

        public Node(int val) { this.val = val; }
    }

    // m1
    static void m1(Node head) {
        while (head!=null && head.next!=null) {
            Node pointer = head;
            while (pointer.next!=null) {
                if (head.val == pointer.next.val) {
                    pointer.next = pointer.next.next;
                } else { // tricky 2 hrs
                    pointer = pointer.next; 
                }
            }
            head = head.next;
        }
    }

    // m2
    static void m2(Node head) {
        HashSet<Integer> has = new HashSet<>();

        Node currentNode = head;
        Node previousNode = null;

        while (currentNode!=null) {
            if (has.contains(currentNode.val)) {
                previousNode.next = currentNode.next;
            } else {
                has.add(currentNode.val);
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
    
        // m1 
        // time O(N^2)
        // space O(1)

        // m2
        // time O(N)
        // space O(N)
    }
}
