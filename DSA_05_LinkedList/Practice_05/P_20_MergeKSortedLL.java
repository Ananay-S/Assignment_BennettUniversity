package DSA_05_LinkedList.Practice_05;

public class P_20_MergeKSortedLL {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // m1
    static ListNode m1(ListNode heads[]) {
        if (heads.length==0) return null;
        if (heads.length==1) return heads[0];
        
        ListNode head = null;
        ListNode pointer = null;
        while (true) {
            int i;
            int minIndex = -1;
            ListNode minNode = null;
            for (i = 0; i < heads.length; i++) {
                if (heads[i]!=null) {
                    if ((minNode==null)||(minNode.val > heads[i].val)) {
                        minIndex = i;
                        minNode = heads[i];
                    }
                }
            }
            // 
            if (minIndex==-1) {
                break;
            }
            // 
            if (head==null) {
                head = minNode;
                pointer = head;
            } else {
                pointer.next = minNode;
                pointer = pointer.next;
            }
            heads[minIndex] = heads[minIndex].next;
        }
        
        return head;
    }


    public static void main(String[] args) {
        
    }
}
