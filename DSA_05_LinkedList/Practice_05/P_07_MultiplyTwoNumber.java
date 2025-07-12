package DSA_05_LinkedList.Practice_05;

public class P_07_MultiplyTwoNumber {
    

    class Node {
        Integer data;
        Node next;

        Node(Integer data) {
            this.data = data;
            this.next = null;
        }
    }

    // m
    static int mn(Node num) {
        int n = 0;
        while (num!=null) {
            n = n*10 + num.data;
            num = num.next;
        }
        return n;
    }
    static int m(Node one, Node two) {

        int nOne = mn(one);
        int nTwo = mn(two);

        return nOne*nTwo;
    }

    public static void main(String[] args) {
        
        // note: integer overflow first 9 digit prime number 
        // (10^9+7)


    }
}
