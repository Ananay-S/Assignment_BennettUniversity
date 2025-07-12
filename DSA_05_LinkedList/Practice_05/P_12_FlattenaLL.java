package DSA_05_LinkedList.Practice_05;

public class P_12_FlattenaLL {
    
    static class List { 
        public int data; 
        public List next; 
        public List child; 
    };

    // m

    static void m(List head) {
        if (head==null) return;
        // find the end
        List endNode = head;
        while (endNode.next!=null) {
            endNode = endNode.next;
        } 
        // pointer
        List pointer = head;
        while (pointer!=null) {
            if (pointer.child!=null) {
                List temp = pointer.child;
                pointer.child = null;

                endNode.next = temp;
                endNode = endNode.next;
            }
            pointer = pointer.next;
        }
    }



    public static void main(String[] args) {
        
    }
}
