package DSA_12_BinarySearchTree.Practice_12;


    
public class P_05_isDeadEnd {
    class Node {
        int data;
        Node left, right;
    
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    public static boolean isDeadEnd(Node root) {
        return isDeadEndUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean isDeadEndUtil(Node root, int pre, int suc) {
        if (root==null) return false;
        if (root.left==null&&root.right==null) {
            if ((suc-root.data>1)&&(root.data-pre>1)) {
                return false;
            } else {
                return true;
            }
        }
        Boolean l = isDeadEndUtil(root.left,pre,root.data);
        Boolean r = isDeadEndUtil(root.right,root.data,suc);
        return l|r;
    }
}
