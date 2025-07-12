package DSA_05_LinkedList.Practice_05;

public class P_11_WriteAFunctionToGetIntersectionOf2LL {
    
    static class Node {
        int data;
        Node next;
          Node(int x) {
            data = x;
              next = null;
        }
    }

    // 
    static Node m3(Node h1, Node h2) {
        // length of the two linkedlist
        Node p1 = h1;
        Node p2 = h2;
        int c1 = 0;
        int c2 = 0;
        while (p1!=null) {
            p1 = p1.next;
            c1++;
        }
        while (p2!=null) {
            p2 = p2.next;
            c2++;
        }
        // difference
        int d = Math.abs(c1-c2);
        // move to common point 
        p1=h1;
        p2=h2;
        if (c1>c2) {
            while (d>0) {
                p1=p1.next;
                d--;
            }
        } else {
            while (d>0) {
                p2=p2.next;
                d--;
            }
        }
        // intersection point
        while (p1!=p2) {
            p1=p1.next;
            p2=p2.next;
        }

        return p1;
        // return p2;
    }

    // m4 the trick to set to common pointer
    static Node m4(Node h1, Node h2) {
        if (h1==null || h2==null) {
            return null;
        }
        Node p1=h1;
        Node p2=h2;
        while (p1!=p2) {
            p1=p1.next;
            p2=p2.next;
            if (p1==p2) {
                return p1;
            }
            if (p1==null) {
                p1=h2;
            }
            if (p2==null) {
                p2=h1;
            }
        }
        return p1;
    }
    public static void main(String[] args) {
        
        // m1 nested loops
        // time O(mn)
        // space O(1)

        // m2 hashing
        // time O(max(m, n))
        // space O(max(m, n))

        // m3 common node
        // time O(m+n)
        // space O(1)

        // m4 two pointer
        // time O(m+n)
        // space O(1)
    }
}
