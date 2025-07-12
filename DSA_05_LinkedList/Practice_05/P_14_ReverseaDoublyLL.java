package DSA_05_LinkedList.Practice_05;

public class P_14_ReverseaDoublyLL {
    class Node {
        int data;
        Node next, prev;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    static Node m1(Node head) {
        if (head==null || head.next==null) return head;

        while (head.next!=null) {
            Node temp = head.next;
            head.next = head.prev;
            head.prev = temp;

            head = head.prev;    
        }
        Node temp = head.next;
        head.next = head.prev;
        head.prev = temp;

        return head;
    }
    // static Node m1(Node head) {
    //     if (head==null || head.next==null) return head;
    //     while (head!=null) {
    //         Node temp = head.next;
    //         head.next = head.prev;
    //         head.prev = temp;

    //         head = head.prev;    
    //     }
    //     return head.prev;
    // }
    public static void main(String[] args) {
        
    }
}
