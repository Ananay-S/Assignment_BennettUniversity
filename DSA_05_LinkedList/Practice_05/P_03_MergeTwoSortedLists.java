package DSA_05_LinkedList.Practice_05;

public class P_03_MergeTwoSortedLists {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // m1 wrong
    static ListNode m1(ListNode l1, ListNode l2) {
        ListNode l =  null;

        if (l1!=null && l2!=null) {
            l = (l1.val<=l2.val) ? l1 : l2;
        } else if (l1!=null) {
            l = l1;
        } else if (l2!=null) {
            l = l2;
        } else {
            return null;
        }

        ListNode lNode = l.next;
        // l.next = lNode;

        while (l1!=null && l2!=null) {
            if (l1.val<=l2.val) {
                lNode = l1;
                lNode = lNode.next;
                l1 = l1.next;
            } else {
                lNode = l2;
                lNode = lNode.next;
                l2 = l2.next;
            }
        }
        while (l1!=null) {
            lNode = l1;
                lNode = lNode.next;
                l1 = l1.next;
        }
        while (l2!=null) {
            lNode = l2;
                lNode = lNode.next;
                l2 = l2.next;
        }

        return l;
    }

    // m2 wrong
    static ListNode m2(ListNode l1, ListNode l2) {
        ListNode l = null;
        boolean bool = false;
        ListNode p = null;

        while (l1!=null && l2!=null) {
            if (!bool) {
                l = (l1.val<=l2.val) ? l1 : l2;
                p = l;
                bool = true;
            } else {
                // if (l1.val<=l2.val) {
                //     p.next = l1;
                // } else {
                //     p.next = l2;
                // }
                p.next = (l1.val<=l2.val) ? l1 : l2;
                p = p.next;
            }
        }
        while (l1!=null) {
            if (!bool) {
                l = l1;
                p = l;
                bool = true;
            } else {
                p.next = l1;
                p = p.next;
            }
        }
        while (l2!=null) {
            if (!bool) {
                l = l2;
                p = l;
                bool = true;
            } else {
                p.next = l2;
                p = p.next;
            }
        }

        return l;
    }

    // m3 working 100%
    static ListNode m3(ListNode l1, ListNode l2) {

        if (l1!=null && l2!=null) {
            
            ListNode l = null;
            ListNode p = null;
            if (l1.val<=l2.val) {
                l = l1;
                l1 = l1.next;
            } else {
                l = l2;
                l2 = l2.next;
            }
            p = l;

            while (l1!=null && l2!=null) {
                if (l1.val<=l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            while (l1!=null) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            }
            while (l2!=null) {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }

            return l;

        } else if (l1!=null) {
            return l1;
        } else if (l2!=null) {
            return l2;
        } else {
            return null;
        }

    }



    public static void main(String[] args) {
        
    }
}
