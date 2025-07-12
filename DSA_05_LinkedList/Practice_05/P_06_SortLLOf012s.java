package DSA_05_LinkedList.Practice_05;

public class P_06_SortLLOf012s {
    
    class Node {
        Integer data;
        Node next;

        Node(Integer data) {
            this.data = data;
            this.next = null;
        }
    }

    // m1
    static void m1(Node head) {
        int count[] = new int[3];
        Node pointer = head;
        while (pointer != null) {
            count[pointer.data]++;
            pointer = pointer.next;
        }
        pointer = head;
        for (int i = 0; i < count.length; i++) {
            pointer.data = i;
            count[i]--;
            pointer = pointer.next;
        }
    }

    // m2
    static void m2(Node head) {
        for (int i = 2; i >= 0; i--) {
            Node previousNode = null;
            Node currentNode = head;
            while (currentNode!=null) {
                if (currentNode.data == i) {
                    Node temp = currentNode;
                    previousNode.next = currentNode.next;
                    temp.next = head;
                    head = temp;
                } else {
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                }
            }
        }
    }
    // m3
    static void m3(Node head) {
        Node p0 = null;
        Node c0 = null;
        Node p1 = null;
        Node c1 = null;
        Node p2 = null;
        Node c2 = null;

        Node p = null;
        Node c = head;
        while (c!=null) {
            Node temp = null;
            if (c.data==0 && c0==null && p0==null) {
                p0 = p;
                c0 = c;
            } else if (c.data==1 && c1==null && p1==null) {
                p1 = p;
                c1 = c;
            } else if (c.data==2 && c2==null && p2==null) {
                p2 = p;
                c2 = c;
            } else {
                temp = c;
                p.next = c.next;
                if (c.data == 0) {
                    temp.next = c0;
                    p0.next = temp;
                } else if (c.data == 1) {
                    temp.next = c1;
                    p1.next = temp; 
                } else if (c.data == 2) {
                    temp.next = c2;
                    p2.next = temp;
                }
                p = p.next;
                c = p.next;
                
            }

            
        }
    }

    public static void main(String[] args) {
        
        // m1 count arr
        // m2 delete and add start
        // m3 changing links
    }
}
