package DSA_12_BinarySearchTree.Practice_12;


public class P_04_preSuc {

    class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left=right=null;
        }
    }
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        Node nodel=null;//pre
        Node noder=null;//suc
        while (root!=null) {
            if (key==root.data) {
                if(root.left==null) { //&&nodel!=null
                    pre[0] = nodel;
                } else {
                    pre[0] = max(root.left);
                }
                if(root.right==null) {
                    suc[0] = noder;
                } else {
                    suc[0] = min(root.right);
                }
                return;
            }
            if (key<root.data) {
                noder=root;
                root=root.left;
            } else {
                nodel=root;
                root=root.right;
            }
        }
        // update if key not still update the floor and ceil
        pre[0] = nodel;
        suc[0] = noder;
        return ;
    }
    public static Node min(Node root) {
        while (root!=null) {
            if (root.left==null) {
                return root;
            }
            root=root.left;
        }
        return null;
    }
    public static Node max(Node root) {
        while (root!=null) {
            if (root.right==null) {
                return root;
            }
            root=root.right;
        }
        return null;
    }
}
