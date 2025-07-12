package DSA_05_LinkedList.Practice_05;

public class P_16_SegregateEvenOddElementsInLL {
    
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // m1
    static void m1(Node head) {
        if (head==null) return;

        Node endNode = head;
        while (endNode.next!=null) {
            endNode = endNode.next;
        }

        Node previousNode = null;
        Node currentNode = head;
        Node evenEnd = endNode;
        while (currentNode!=evenEnd) {
            if ((currentNode.data & 1)==0) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            } else {
                Node temp = currentNode;
                currentNode = currentNode.next;
                previousNode.next = currentNode;
                
                endNode.next = temp;
                endNode = endNode.next;
                endNode.next = null;

                // endNode.next = currentNode;
                // currentNode = currentNode.next;
                // previousNode.next = currentNode;
                // endNode = endNode.next;
                // endNode.next = null;
            }
        }
        if ((currentNode.data & 1)==0) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        } else {
            Node temp = currentNode;
            currentNode = currentNode.next;
            previousNode.next = currentNode;
            
            endNode.next = temp;
            endNode = endNode.next;
            endNode.next = null;

            // endNode.next = currentNode;
            // currentNode = currentNode.next;
            // previousNode.next = currentNode;
            // endNode = endNode.next;
            // endNode.next = null;
        }
        

    }

    public static void main(String[] args) {
        
        // m1 move odd to the end of the ll
        // m2 use recursive to traverse back and move even to the front of ll
    }
}
